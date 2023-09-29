package com.kcx.controller;

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
 * @description
 * @createTime 29/09/2023 4:56 pm
 */
@WebServlet("/showsend")
public class ShowSendServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Context context=new Context();
        THUtils.print("blog/send.html",context,res);
    }
}
