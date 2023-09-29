package com.kcx.controller;

import com.kcx.util.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author kcx
 * @version v1.0.0
 * @description 定向到登录界面
 * @createTime 26/09/2023 9:10 pm
 */
@WebServlet("/showlogin")
public class ShowLoginServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Context context = new Context();
        THUtils.print("blog/login.html",context,res);
    }
}
