package com.yidatec.monomer.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.yidatec.monomer.security.util.GetPostUntil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 小程序
 *
 * @author xudk
 * @since 2022-05-24
 */
@RestController
@Api(tags = "AppletController", description = "小程序")
@RequestMapping("/applet")
public class AppletController {

    /**
     * 获取openid
     *
     * @param
     * @param
     * @return
     */
    @ApiOperation(value = "登录以后返回token")
    @CrossOrigin
    @RequestMapping("/getOpenid")
    @ResponseBody
    public String getOpenid(String code, HttpServletRequest request, HttpServletResponse response) {
        String appid = "wx07b46ae24e4ee0ef";
        String secret = "53db9a577bc792d0edf8594473e61102";
        response.setHeader("Access-Control-Allow-Origin", "*");
        /*星号表示所有的域都可以接受，*/
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wxLoginUrl = "https://api.weixin.qq.com/sns/jscode2session";
        String param = "appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        String jsonString = GetPostUntil.sendGet(wxLoginUrl, param);
        JSONObject json = JSONObject.parseObject(jsonString);
        String openid = json.getString("openid");
        System.out.println("###############" + openid);
        return openid;
    }

}
