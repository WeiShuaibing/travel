package com.bishe.travel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.travel.entity.R;
import com.bishe.travel.entity.Scenic;
import com.bishe.travel.service.OrderService;
import com.bishe.travel.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/userPintuan")
    public R userPintuan() {

        return new R();
    }

}
