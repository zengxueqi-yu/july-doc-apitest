package com.api.apitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自动化测试工具入口
 * @author zengxueqi
 * @since 2020/2/3
 */
@Controller
public class IndexController {

    /**
     * 首页
     * @param
     * @return java.lang.String
     * @author zengxueqi
     * @since 2020/2/26
     */
    @RequestMapping("/api")
    public String test(){
        return "/api";
    }

    @GetMapping("/testapi")
    @ResponseBody
    public String testapi(String name){
        return name;
    }

}
