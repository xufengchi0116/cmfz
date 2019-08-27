package com.baizhi.controller;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    @RequestMapping("/createCaptcha")
    public void createCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        //获取验证码随机数
        String securityCode = SecurityCode.getSecurityCode();
        //将随机数保存到session中，未来做登录验证
        session.setAttribute("securityCode", securityCode);
        //使用验证码随机数，绘制验证码图片
        BufferedImage image = SecurityImage.createImage(securityCode);
        //使用IO响应验证码图片
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
    }
}
