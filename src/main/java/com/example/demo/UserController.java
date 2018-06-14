package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    public String getUser(@PathVariable Integer id, Model model) {
        System.out.println("id");
        model.addAttribute("user", new User(id, "张三", 20, "中国广州"));
        return "/user/detail";
    }

    @RequestMapping("/list")
    public String listUser(Model model) {
        System.out.println("list");
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i, "张三" + i, 20 + i, "中国广州"));
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }

    @RequestMapping("/list2")
    public String listUser2(Model model) {
        System.out.println("list2");
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i, "张三" + i, 20 + i, "中国广州"));
        }

        model.addAttribute("users", userList);
        return "/user/angularjs";
    }

//    http://localhost:8080/user/angularjs2
    @RequestMapping("/angularjs2")
    public String angularjs2(Model model) {
        System.out.println("angularjs2");
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i, "张三" + i, 20 + i, "中国广州"));
        }

        model.addAttribute("users", userList);
        return "/user/angularjs2";
    }
}