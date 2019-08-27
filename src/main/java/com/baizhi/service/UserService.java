package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User selectUserById(String id);

    //查询全部
    public Map<String, Object> selectAll(Integer page, Integer rows);

    //查询全部不分页
    public List<User> FindAll();
}
