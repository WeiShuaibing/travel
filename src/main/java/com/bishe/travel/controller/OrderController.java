package com.bishe.travel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.travel.entity.Order;
import com.bishe.travel.entity.R;
import com.bishe.travel.entity.Scenic;
import com.bishe.travel.service.OrderService;
import com.bishe.travel.service.ScenicService;
import com.bishe.travel.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Or;
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
    @Autowired
    private UserService userService;

    /**
     * 根据用户id查询他的订单
     * @param userId
     * @return
     */
    @GetMapping("/orderList")
    public R orderList(int userId) {
        QueryWrapper<Order> query = Wrappers.<Order>query();
        query.eq("user_id", userId).orderByDesc("id");
        List<Order> list = service.list(query);
        for (Order order : list) {
            order.setScenic(scenicService.getById(order.getScenicId()));
        }
        return new R(list);
    }

    @GetMapping("/allOrder")
    public R allOrder(){
        QueryWrapper<Order> query = Wrappers.<Order>query();
        query.orderByDesc("id");
        List<Order> list = service.list(query);
        for (Order order : list) {
            order.setScenic(scenicService.getById(order.getScenicId()));
            order.setUser(userService.getById(order.getUserId()));
        }
        return new R(list);
    }


    @PostMapping("/userPintuan")
    public R userPintuan(@RequestBody Order order) {

        /**
         * 思路：传过来 用户id 景点id 以及要拼团的类型,
         * order表 保存拼单的用户
         * 从order表计算拼单的用户数
         * 修改景点表中用户拼单的数量
         */
        Order or = service.getOne(Wrappers.<Order>query().eq("user_id", order.getUserId()).eq("scenic_id", order.getScenicId()).eq("status", 0));
        if (or != null) {
            return new R(20001, "该景点您已经拼团过了哦");
        }
        order.setCreateDate(new Date());
        service.save(order);// 保存订单信息

        // 查询拼单数量
        QueryWrapper<Order> query = Wrappers.<Order>query();
        query.eq("status", 0).eq("type", order.getType());
        int count = service.count(query);

        Scenic scenic = scenicService.getById(order.getScenicId());
        String pindanNum = scenic.getPindanNum();
        char[] pindanNumCharts = pindanNum.toCharArray();
        R r = new R();
        if (order.getType().equals("car")) {
            if (count == 4 || pindanNumCharts[0] == '4') {
                pindanNumCharts[0] = '0';
                r.setCode(20002);
                r.setMsg("恭喜您拼单成功");
                // 拼单成功，order表中的数据status应该设置为1 表明拼单成功！
                service.updateOrderStatus(order.getUserId(), order.getScenicId(), 1);

            } else {
                int num = Integer.parseInt(String.valueOf(scenic.getPindanNum().charAt(0))) + 1;
                pindanNumCharts[0] = (char) (num + '0');
                r.setCode(20000);
                r.setMsg("已开始拼单...");

            }
        } else if (order.getType().equals("train")) {
            if (count == 4 || pindanNumCharts[1] == '4') {
                pindanNumCharts[1] = '0';
                r.setCode(20002);
                r.setMsg("恭喜您拼单成功");
                // 拼单成功，order表中的数据status应该设置为1 表明拼单成功！
                service.updateOrderStatus(order.getUserId(), order.getScenicId(), 1);
            } else {
                int num = Integer.parseInt(String.valueOf(scenic.getPindanNum().charAt(1))) + 1;
                pindanNumCharts[1] = (char) (num + '0');
                r.setCode(20000);
                r.setMsg("已开始拼单...");
            }
        } else {
            if (count == 4 || pindanNumCharts[2] == '4') {
                pindanNumCharts[2] = '0';
                r.setCode(20002);
                r.setMsg("恭喜您拼单成功");
                // 拼单成功，order表中的数据status应该设置为1 表明拼单成功！
                service.updateOrderStatus(order.getUserId(), order.getScenicId(), 1);
            } else {
                int num = Integer.parseInt(String.valueOf(scenic.getPindanNum().charAt(2))) + 1;
                pindanNumCharts[2] = (char) (num + '0');
                r.setCode(20000);
                r.setMsg("已开始拼单...");
            }
        }
        scenic.setPindanNum(String.valueOf(pindanNumCharts));
        scenicService.updateById(scenic);

        return r;
    }

    @GetMapping("/deleteById")
    public R deleteById(int id) {
        boolean b = service.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R(20001, "服务异常，删除订单失败！");
        }
    }

}
