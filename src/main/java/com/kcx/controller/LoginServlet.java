package com.kcx.controller;

import com.kcx.dao.UserDao;
import com.kcx.extity.User;
import com.kcx.util.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
//改成使用会话跟踪

        if (new UserDao().login(name, pwd)){
            out.println("<script>alert('登录成功！');window.location.href='home?name="+name+"';</script>");
        }else {
            // 登录失败，返回一个包含JavaScript提示和重定向的响应
            out.println("<script>alert('登录失败，用户名或密码错误。'); window.location.href='showlogin';</script>");
        }
        out.close();
    }
}
