package com.bishe.travel.controller;

import com.bishe.travel.entity.*;
import com.bishe.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public R login(@RequestBody Admin admin){
        R r = adminService.verifyLogin(admin);
        return r;
    }

    /**
     * 获取用户基本信息
     * @return
     */
    @GetMapping("/info")
    public R info(@RequestHeader String Token){
        return new R(adminService.getById(Token));
    }

    @GetMapping("/logout")
    public R logout(){
        return new R();
    }

}
