package com.yidatec.monomer.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yidatec.monomer.modules.sys.entity.SysMenu;
import com.yidatec.monomer.modules.sys.mapper.SysMenuMapper;
import com.yidatec.monomer.modules.sys.service.SysMenuService;
import com.yidatec.monomer.modules.sys.vo.SysMenuTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 后台管理员管理Service实现类
 * @author xudk
 * @since 2022-05-24
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Override
    public List<SysMenuTree> getMenuList() {
        List<SysMenuTree> sysMenuList = baseMapper.getMenus();
        return streamToTree(sysMenuList,0L,null);
    }

    @Override
    public List<SysMenuTree> getRoleMenuList() {
        List<SysMenuTree> sysMenuList = baseMapper.getRoleMenuList(getUserName());
        return streamToTree(sysMenuList,0L,null);
    }

    @Override
    public List<SysMenuTree> getRoleCheckedMenuList(String roleId) {
        List<SysMenuTree> sysMenuList = baseMapper.getMenus();
        List<Long> checkedMenuList = baseMapper.getRoleCheckedMenuList(roleId);
        return streamToTree(sysMenuList,0L,checkedMenuList);
    }

    /**
     * 生成树形结构
     * @param treeList 原始结果
     * @param parentId 父节点
     * @return 带children的属性结构
     */
    private List<SysMenuTree> streamToTree(List<SysMenuTree> treeList, Long parentId,List<Long> checkedList) {
        if(Objects.nonNull(checkedList)){
            return treeList.stream().peek(item->{
                //勾选
                if( checkedList.stream().anyMatch(x-> x.equals(item.getId()))){
                    item.setChecked(true);
                }
            })
                    // 过滤父节点
                    .filter(parent -> parent.getParentId().equals(parentId))
                    // 把父节点children递归赋值成为子节点
                    .peek(child -> child.setChildren(streamToTree(treeList,child.getId(),checkedList))).collect(Collectors.toList());
        }
        return treeList.stream()
                // 过滤父节点
                .filter(parent -> parent.getParentId().equals(parentId))
                // 把父节点children递归赋值成为子节点
                .peek(child -> child.setChildren(streamToTree(treeList,child.getId(),checkedList))).collect(Collectors.toList());
    }

    /**
     * 获取用户信息
     * @return userName
     */
    private String getUserName(){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
}
