package com.bishe.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.travel.entity.Order;
import com.bishe.travel.entity.Scenic;

public interface OrderService extends IService<Order> {


    public int updateOrderStatus(String userId, int scenicId, int status);

}
