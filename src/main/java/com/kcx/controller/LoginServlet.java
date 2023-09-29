package com.kcx.controller;

import com.kcx.dao.UserDao;
import com.kcx.extity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * @author kcx
 * @version v1.0.0
 * @description 登录请求处理类
 * @createTime 26/09/2023 9:36 pm
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String rem=  req.getParameter("rem");
        resp.setContentType("text/html;charset=UTF-8");

//改成使用会话跟踪

        User login = new UserDao().login(name, pwd);
        if (login==null){
            PrintWriter out = resp.getWriter();
            // 登录失败，返回一个包含JavaScript提示和重定向的响应
            out.println("<script>alert('登录失败，用户名或密码错误。'); window.location.href='showlogin';</script>");
            out.close();
        }else {
            //判断用户是否需要保存用户信息
            if(rem!=null){
                //将需要保存的用户数据保存在浏览器端
                Cookie c=new Cookie("name", URLEncoder.encode(name,"utf8"));
                Cookie c1=new Cookie("pwd",pwd);
                //设置cookie的保存时效
                c.setMaxAge(60);
                c1.setMaxAge(60);

                resp.addCookie(c);
                resp.addCookie(c1);
            }
            //登录成功跳转到首页页面
            //获取当前会话对象
            HttpSession session= req.getSession();
            //将登录成功的用户信息保存在session中
            session.setAttribute("user",login);
            resp.sendRedirect(req.getContextPath()+"/home");
        }

    }
}
