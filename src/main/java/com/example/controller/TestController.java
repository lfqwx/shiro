package com.example.controller;

import com.example.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author L.F.Q
 * @date 2019/5/20 11:27
 */
@Controller
public class TestController {
    @RequestMapping(value = {"/login","/"})
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit() {
        return "edit success";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            subject.logout();
        }
        return "login";
    }


    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin success";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            return "login";
        }
    }
}
