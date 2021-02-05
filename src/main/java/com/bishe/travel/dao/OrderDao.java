package com.bishe.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.travel.entity.Order;
import com.bishe.travel.entity.Scenic;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends BaseMapper<Order> {

    // 修改订单的状态
    @Update("update myorder SET status = #{status} where scenic_id=#{scenicId} AND user_id = #{userId}")
    public int updateOrderStatus(String userId, int scenicId, int status);

}
