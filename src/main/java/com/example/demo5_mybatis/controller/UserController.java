package com.example.demo5_mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo5_mybatis.entity.User;
import com.example.demo5_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // 用来储存用户数据
    private List<User> users;

    @RequestMapping("/")
    public String index(Model model){

        Page<User> page=new Page<>(1,10);
        userService.page(page,null);
        model.addAttribute("page",page);

        return "index";
    }

    // 用于翻页
    @RequestMapping("/index")
    public String index(int current,Model model){

        Page<User> page=new Page<>(current,10);
        userService.page(page,null);
        model.addAttribute("page",page);

        return "index";
    }

    @RequestMapping("/update")
    public String update(int id,Model model){
        User u=userService.getById(id);
        u.setAge(10);
        u.setName("name1");
        u.setTel("123456789");

        userService.updateById(u);
        System.out.println("修改的信息为:"+u);

        Page<User> page=new Page<>(1,10);
        userService.page(page,null);
        model.addAttribute("page",page);


        /*
        User u=userService.getById(id);
        u.setAge(10);
        u.setName("name1");
        u.setTel("123456789");

        userService.updateById(u);
        System.out.println("修改的信息为:"+u);

        users=userService.list();
        model.addAttribute("li",users);
        */

        return "index";
    }

    @RequestMapping("/delete")
    public String delete(int id,Model model){
        userService.removeById(id);
        System.out.println("删除用户,id="+id);

        Page<User> page=new Page<>(1,10);
        userService.page(page,null);
        model.addAttribute("page",page);

        /*
        userService.removeById(id);
        System.out.println("删除用户,id="+id);

        users=userService.list();
        model.addAttribute("li",users);
         */

        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        User u=new User();
        u.setName("hello");
        u.setPassword("pass1");
        u.setAge(11);
        u.setTel("123456789");
        userService.save(u);

        Page<User> page=new Page<>(1,10);
        userService.page(page,null);
        model.addAttribute("page",page);

        /*
        User u=new User();
        u.setName("hello");
        u.setPassword("pass1");
        u.setAge(11);
        u.setTel("123456789");
        userService.save(u);

        users=userService.list();
        model.addAttribute("li",users);
         */

        return "index";
    }


    @PostMapping("selectLike")
    public String selectSome(String name,Model model){

        LambdaQueryWrapper<User> lambdaQueryWrapper= Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(User::getName,name);

        Page<User> page=new Page<>(1,10);
        userService.page(page,lambdaQueryWrapper);
        model.addAttribute("page",page);

        /*
        LambdaQueryWrapper<User> lambdaQueryWrapper= Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(User::getName,name);

        users=userMapper.selectList(lambdaQueryWrapper);
        model.addAttribute("li",users);

         */

        return "index";
    }

}
