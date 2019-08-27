package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("selectuser")
    public Map<String, Object> selectAll(Integer page, Integer rows) {
        Map<String, Object> map = userService.selectAll(page, rows);
        return map;
    }


    @RequestMapping("out")
    public void out(HttpServletRequest request, HttpServletResponse resp) throws Exception {

//        做文件的导出
//        1.注入userService查询出所有的用户   list
        List<User> list = userService.FindAll();
//        2.导出

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("java班学生", "学生表"),
                User.class, list);

        String fileName = "用户报表(" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ").xls";

        fileName = new String(fileName.getBytes("gbk"), "iso-8859-1");
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);
        workbook.write(resp.getOutputStream());


    }


}
