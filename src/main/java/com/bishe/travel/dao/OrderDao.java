package com.bishe.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.travel.entity.Order;
import com.bishe.travel.entity.Scenic;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends BaseMapper<Order> {
}
