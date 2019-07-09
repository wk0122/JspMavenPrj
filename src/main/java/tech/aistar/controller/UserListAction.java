package tech.aistar.controller;

import com.github.pagehelper.PageInfo;
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
 * Created by js on 2019/6/13.
 */
@WebServlet(urlPatterns = "/user/permission/list")
public class UserListAction extends HttpServlet {
    private UserMapperService mapper=new UserMapperServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取查询条件
        String username=req.getParameter("username");

        String pageNow=req.getParameter("pageNow");

        String pageSize=req.getParameter("pageSize");

        PageInfo<User> pageInfo=mapper.getPageInfo(username,Integer.valueOf(pageNow==null?"1":pageNow),Integer.valueOf(pageSize==null?"3":pageSize));

        //放到request
        req.setAttribute("pageInfo",pageInfo);

        req.setAttribute("searchName",username);
        req.setAttribute("pageSize",pageSize==null?"3":pageSize);
//        req.getRequestDispatcher("/user/list.jsp").forward(req,resp);

        req.getRequestDispatcher("/user/page.jsp").forward(req,resp);
    }
}
