package com.bishe.travel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.travel.entity.Admin;
import com.bishe.travel.entity.R;
import com.bishe.travel.entity.User;
import com.bishe.travel.service.AdminService;
import com.bishe.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("phone", user.getPhone());
        User one = userService.getOne(query);
        if (one == null) {
            return new R(20001, "账号不存在！！！");
        }
        if (one.getPassword().equals(user.getPassword())) {
            return new R(one);
        } else {
            return new R(20001, "账号或密码错误！！！");
        }
    }

    @PostMapping("/register")
    public R register(@RequestBody User user) {

        user.setPassword(user.getPhone());
        User byPhone = userService.getOne(Wrappers.<User>query().eq("phone", user.getPhone()));
        if (byPhone == null) {
            user.setPassword(user.getPhone());
            boolean save = userService.save(user);
            if (save) {
                return new R("注册成功！");
            } else {
                return new R("服务异常，注册失败！！！");
            }
        } else {
            return new R(20001, user.getPhone() + "用户已经存在");
        }
    }

    @GetMapping("/getById")
    public R login(int id) {
        User byId = userService.getById(id);
        return new R(byId);
    }

    @GetMapping("/deleteById")
    public R deleteById(int id) {
        boolean b = userService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R("服务异常，删除失败！");
        }
    }

    @GetMapping("/getAll")
    public R getAll() {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.orderByDesc("create_date");
        List<User> list = userService.list(query);
        return new R(list);
    }

    @PostMapping("/save")
    public R save(@RequestBody User user) {
        System.out.println(user);
        boolean b = userService.updateById(user);
        if (b) {
            return new R();
        } else {
            return new R("服务异常，保存或更新失败！");
        }
    }

}
