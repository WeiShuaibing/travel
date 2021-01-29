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
    public R login(User user) {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("phone", user.getPhone());
        User one = userService.getOne(query);
        if (one.getPassword().equals(user.getPassword())) {
            return new R("登陆成功");
        } else {
            return new R(20001, "账号或密码错误！！！");
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
        List<User> list = userService.list();
        return new R(list);
    }

    @PostMapping("/save")
    public R save(User user) {
        boolean b = userService.saveOrUpdate(user);
        if (b) {
            return new R();
        } else {
            return new R("服务异常，保存或更新失败！");
        }
    }

}