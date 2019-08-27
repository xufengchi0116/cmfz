package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
    //查询
    public Admin FindAdmin(Admin admin);
}
