package com.kcx.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 29/09/2023 4:40 pm
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得会话对象
        HttpSession session= req.getSession();
        //删除会话中保存的用户信息
//       session.removeAttribute("user");

        //让session失效
        session.invalidate();

        //重定向到登录页面
        resp.sendRedirect(req.getContextPath()+"/showlogin");
    }
}