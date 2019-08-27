package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.Map;

public interface BannerService {

    //查询
    public Map<String, Object> selectAllBanner(Integer page, Integer rows);

    //添加
    public String add(Banner banner);

    //添加图片
    public void update(Banner banner);

    //修改
    public void edit(Banner banner);

    //删除
    public void del(Banner banner);
}
