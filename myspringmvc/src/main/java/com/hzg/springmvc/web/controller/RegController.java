package com.hzg.springmvc.web.controller;

import com.hzg.springmvc.domain.User;
import com.hzg.springmvc.util.DB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * HomeController
 */
@Controller
public class RegController {

    /**
     * 注册
     * @return
     */
    @RequestMapping("/toReg")
    public String toRegView(){
        return "reg";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("/doReg")
    public String doReg(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);
        return "index";
    }

    /**
     * 实现方式2
     * @return
     */
    @RequestMapping("/doReg2")
    public String doReg(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("插入数据");
        System.out.println(username + ":" + password);
        return "index";
    }

    /**
     * 控制器和jsp之间传递参数
     * @return
     */
    @RequestMapping("/selectOne")
    public String selectOne(Model m, @RequestParam("uid") String uid){
        System.out.println("接收到了参数 UID = " + uid);
        String username = "toms";
        // 向Model中添加属性，传递给jsp
        m.addAttribute("myusername", username);
        return "selectOne";
    }

    /**
     * 控制器和jsp之间传递集合
     * @return
     */
    @RequestMapping("/selectAll")
    public String selectAll(Model m){
        m.addAttribute("userList", DB.findAll());
        return "userList";
    }

    /**
     * 删除一个用户
     * @return
     */
    @RequestMapping("/deleteOne")
    public String deleteOne(@RequestParam("uid") Integer uid){
        System.out.println(uid);
        DB.delete(uid);
        // forward请求转发，服务器端完成
        // redirect重定向
        return "forward:/selectAll";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("/editOne")
    public String editOne(Model m, @RequestParam("uid") Integer uid){
        System.out.println(uid);
        User user = DB.findOne(uid);
        m.addAttribute("user", user);
        return "editUser";
    }

    /**
     * 更新一个
     */
    @RequestMapping("/updateOne")
    public String updateOne(User user){
        DB.update(user);
        return "forward:/selectAll";
    }
}
