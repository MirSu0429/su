package com.su.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: supengfei
 * @Date: 2019/1/7 17:16
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/app")
    public String index() {
        return "index1";
    }
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
