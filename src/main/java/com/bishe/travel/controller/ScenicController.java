package com.bishe.travel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.travel.entity.R;
import com.bishe.travel.entity.Scenic;
import com.bishe.travel.entity.User;
import com.bishe.travel.service.ScenicService;
import com.bishe.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 */

@RestController
@RequestMapping("/scenic")
public class ScenicController {

    @Autowired
    private ScenicService scenicService;

    @GetMapping("/getById")
    public R login(int id) {
        Scenic byId = scenicService.getById(id);
        return new R(byId);
    }

    @GetMapping("/deleteById")
    public R deleteById(int id) {
        boolean b = scenicService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R("服务异常，删除失败！");
        }
    }

    @GetMapping("/getAll")
    public R getAll(String matchStr) {
        System.out.println(matchStr);
        if (matchStr == null || matchStr.equals("")) {
            List<Scenic> list = scenicService.list();
            return new R(list);
        } else {
            QueryWrapper<Scenic> query = Wrappers.<Scenic>query();
            query.like("name", matchStr).or().like("address", matchStr).or().like("des", matchStr).or()
                    .like("text", matchStr);
            return new R(scenicService.list(query));
        }

    }

    @PostMapping("/save")
    public R save(@RequestBody Scenic scenic) {
        scenic.setCreateDate(new Date());
        scenic.setUpdateDate(new Date());
        boolean b = scenicService.saveOrUpdate(scenic);
        if (b) {
            return new R();
        } else {
            return new R("服务异常，保存或更新失败！");
        }
    }

}
