package com.yidatec.monomer.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidatec.monomer.common.api.CommonPage;
import com.yidatec.monomer.common.api.CommonResult;
import com.yidatec.monomer.modules.sys.dto.SysUserEditParam;
import com.yidatec.monomer.modules.sys.dto.SysUserEditPasswordParam;
import com.yidatec.monomer.modules.sys.dto.SysUserLoginParam;
import com.yidatec.monomer.modules.sys.dto.SysUserParam;
import com.yidatec.monomer.modules.sys.entity.SysUser;
import com.yidatec.monomer.modules.sys.service.SysUserCustomerService;
import com.yidatec.monomer.modules.sys.service.SysUserService;
import com.yidatec.monomer.modules.sys.vo.SysUserRoleVo;
import com.yidatec.monomer.security.util.GetPostUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_NUM;
import static com.yidatec.monomer.common.constant.Const._DEFAULT_PAGE_SIZE;

/**
 * 小程序
 * @author xudk
 * @since 2022-05-24
 */
@RestController
@Api(tags = "AppletController", description = "小程序")
@RequestMapping("/applet")
public class AppletController {

    /**
     * 获取openid
     * @param
     * @param
     * @return
     */
    @ApiOperation(value = "登录以后返回token")
    @CrossOrigin
    @RequestMapping("/getOpenid")
    @ResponseBody
    public String getOpenid(String code, HttpServletRequest request, HttpServletResponse response){
        String appid= "wx07b46ae24e4ee0ef";
        String secret = "53db9a577bc792d0edf8594473e61102";
        response.setHeader("Access-Control-Allow-Origin", "*");
        /*星号表示所有的域都可以接受，*/
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wxLoginUrl = "https://api.weixin.qq.com/sns/jscode2session";
        String param = "appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        String jsonString = GetPostUntil.sendGet(wxLoginUrl, param);
        JSONObject json = JSONObject.parseObject(jsonString);
        String openid = json.getString("openid");
        System.out.println("###############"+openid);
        return openid;
    }

}
