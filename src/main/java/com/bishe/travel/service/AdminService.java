package com.bishe.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.travel.entity.*;

public interface AdminService extends IService<Admin> {

    public R verifyLogin(Admin admin);

}
