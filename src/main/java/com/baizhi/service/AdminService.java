package com.baizhi.service;

import com.baizhi.entity.Admin;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AdminService {

    //查询
    public Map<String, Object> FindAdmin(Admin admin, String enCode, HttpSession session);

}
