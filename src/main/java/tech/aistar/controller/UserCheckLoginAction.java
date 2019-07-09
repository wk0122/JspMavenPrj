package tech.aistar.controller;

import tech.aistar.entity.User;
import tech.aistar.service.UserMapperService;
import tech.aistar.service.impl.UserMapperServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by js on 2019/6/12.
 */
@WebServlet(urlPatterns = "/user/checklogin")
public class UserCheckLoginAction extends HttpServlet {
    private UserMapperService mapper=new UserMapperServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //拿到填到表单的code
        String code=req.getParameter("code");

        //手机号
        String phone=req.getParameter("phone");

        //从session作用域中取出code
        String codeUtil= (String) req.getSession().getAttribute("codes");

        if (!code.equals(codeUtil)){

            User user =mapper.getByPhone(phone);
            req.getSession().setAttribute("user",user);
            req.getSession().removeAttribute("codes");
//            resp.sendRedirect("/JspStudent/user/permission/list");
            resp.sendRedirect("/JspMavenPrj/user/ajaxlist.jsp");
        }else {
            resp.sendRedirect("/JspMavenPrj/user/login.jsp?error=1");
        }
    }
}
