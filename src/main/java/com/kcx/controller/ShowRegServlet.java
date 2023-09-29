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
 * @description 定向到注册界面
 * @createTime 26/09/2023 5:23 pm
 */
@WebServlet("/showreg")
public class ShowRegServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Context context = new Context();
        THUtils.print("blog/reg.html",context,res);
    }
}
