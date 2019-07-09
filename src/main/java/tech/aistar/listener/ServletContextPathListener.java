package tech.aistar.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/6/13 0013
 */
@WebListener
public class ServletContextPathListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取到ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //获取项目的上下文的路径
        String path = servletContext.getContextPath();//  /JspTeach

        //将路径入放入到application作用域
        servletContext.setAttribute("path",path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
