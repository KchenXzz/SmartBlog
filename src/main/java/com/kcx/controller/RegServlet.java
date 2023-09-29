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

/**
 * @author kcx
 * @version v1.0.0
 * @description 注册请求处理类
 * @createTime 26/09/2023 5:32 pm
 */
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        User user = new User(name, pwd, email);
        new UserDao().save(user);

        Context context = new Context();
        THUtils.print("blog/login.html",context,resp);
    }
}
