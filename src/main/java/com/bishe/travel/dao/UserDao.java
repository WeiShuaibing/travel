package com.bishe.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.travel.entity.Admin;
import com.bishe.travel.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
}
