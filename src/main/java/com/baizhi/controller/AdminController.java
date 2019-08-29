package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    @ResponseBody
    public Map<String, Object> login(Admin admin, HttpSession session, String captcha) {

        Map<String, Object> map = adminService.FindAdmin(admin, captcha, session);
		System.out.println();
        return map;
        /*Admin findAdmin = adminService.FindAdmin(admin);
        String  code = (String) session.getAttribute("securityCode");
        if(findAdmin!=null && captcha.equals(code)){
            session.setAttribute("Admin",findAdmin);
            return "success";
        }
        return "error";*/
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.invalidate();

        return "redirect:/login/login.jsp";
    }
}
