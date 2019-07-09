package tech.aistar.controller;

import org.apache.commons.lang3.RandomStringUtils;
import tech.aistar.util.SMSCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by js on 2019/6/12.
 */
@WebServlet(urlPatterns = "/user/logincl")
public class MessageLoginClACtion extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("====");
        String phone=req.getParameter("phone");

        //产生一个随机的手机验证码
        String code= RandomStringUtils.randomNumeric(6);

        //将code放到session作用域中
        HttpSession session=req.getSession();
        session.setAttribute("codes",code);

        System.out.println(code);

        //将code发送到phone
        try {
            SMSCode.sendCode(phone,code);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
