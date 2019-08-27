package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BannerDao {

    //查询
    public List<Banner> selectAllBanner(
            @Param("begin") Integer begin,
            @Param("rows") Integer rows);

    //数量
    public Integer count();

    //添加
    public void add(Banner banner);

    //添加图片
    public void update(Banner banner);

    //修改
    public void edit(Banner banner);

    //删除
    public void del(String id);
}

