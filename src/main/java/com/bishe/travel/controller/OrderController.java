package com.bishe.travel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.travel.entity.Order;
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
    @Autowired
    private ScenicService scenicService;

    @GetMapping("/userPintuan")
    public R userPintuan(@RequestBody Order order) {
        System.out.println(order);
        /**
         * 思路：传过来 用户id 景点id 以及要拼团的类型,
         * order表 保存拼单的用户
         * 从order表计算拼单的用户数
         * 修改景点表中用户拼单的数量
         */
        service.save(order);// 保存订单信息

        // 查询拼单数量
        QueryWrapper<Order> query = Wrappers.<Order>query();
        query.eq("status", 0).eq("type", order.getType());
        int count = service.count(query);

        Scenic scenic = scenicService.getById(order.getScenicId());
        String pindanNum = scenic.getPindanNum();
        char[] pindanNumCharts = pindanNum.toCharArray();
        if (order.getType().equals("car")) {
            if (count == 5) {
                pindanNumCharts[0] = '0';
            } else {
                int num = Integer.parseInt(String.valueOf(scenic.getPindanNum().charAt(0))) + 1;
                pindanNumCharts[0] = (char) (num + '0');
            }
        } else if (order.getType().equals("train")) {
            if (count == 5) {
                pindanNumCharts[1] = '0';
            } else {
                int num = Integer.parseInt(String.valueOf(scenic.getPindanNum().charAt(0))) + 1;
                pindanNumCharts[1] = (char) (num + '0');
            }
        } else {
            if (count == 5) {
                pindanNumCharts[2] = '0';
            } else {
                int num = Integer.parseInt(String.valueOf(scenic.getPindanNum().charAt(0))) + 1;
                pindanNumCharts[2] = (char) (num + '0');
            }
        }
        scenic.setPindanNum(String.valueOf(pindanNumCharts));
        scenicService.updateById(scenic);

        return new R();
    }

}
