package com.bishe.travel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.travel.entity.R;
import com.bishe.travel.entity.User;
import com.bishe.travel.service.OrderService;
import com.bishe.travel.service.ScenicService;
import com.bishe.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 */

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private OrderService orderService;


    @GetMapping("/baseInfo")
    public R baseInfo() {

        // 总用户数，总景点数，总订单数
        HashMap<String, Integer> resData = new HashMap<>();
        resData.put("totalUser", userService.count());
        resData.put("totalScenic", scenicService.count());
        resData.put("totalOrder", orderService.count());
        return new R(resData);
    }

}
