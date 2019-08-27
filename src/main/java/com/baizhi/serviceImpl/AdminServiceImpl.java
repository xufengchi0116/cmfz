package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Map<String, Object> FindAdmin(Admin admin, String enCode, HttpSession session) {

        /*Admin newadmin = adminDao.FindAdmin(admin);
        return newadmin;*/

        Map<String, Object> map = new HashMap<>();
        String code = (String) session.getAttribute("securityCode");
        if (enCode.equals(code)) {
            Admin newadmin = adminDao.FindAdmin(admin);
            if (newadmin != null) {
                if (newadmin.getPassword().equals(admin.getPassword())) {
                    map.put("msg", "success");
                    /*map.put("admin",newadmin);*/
                    session.setAttribute("Admin", newadmin);
                    return map;
                } else {
                    map.put("msg", "密码错误");
                    return map;
                }
            } else {
                map.put("msg", "用户不存在");
                return map;
            }
        } else {
            map.put("msg", "验证码错误");
            return map;
        }
    }
}
