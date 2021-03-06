package com.bishe.travel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.travel.dao.OrderDao;
import com.bishe.travel.dao.ScenicDao;
import com.bishe.travel.entity.Order;
import com.bishe.travel.entity.Scenic;
import com.bishe.travel.service.OrderService;
import com.bishe.travel.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int updateOrderStatus(String userId, int scenicId, int status) {
        return orderDao.updateOrderStatus(userId, scenicId, status);
    }
}
