package com.hzg.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {

    /**
     * 打开首页
     * @return
     */
    @RequestMapping("/home")
    public String openHome(){
        System.out.println("hello");
        return "index";
    }
}
