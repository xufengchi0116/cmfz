package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    //根据id查询
    public User selectByPrimaryKey(String id);

    //查询全部
    public List<User> selectAll(
            @Param("begin") Integer begin,
            @Param("rows") Integer rows
    );

    //总数
    public Integer count();

    //查询全部不分页
    public List<User> FindAll();

}
