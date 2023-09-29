package com.kcx.controller;

import com.kcx.extity.User;
import com.kcx.util.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author kcx
 * @version v1.0.0
 * @description 定向到登录界面
 * @createTime 26/09/2023 9:10 pm
 */
@WebServlet("/showlogin")
public class ShowLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断用户是否为空
        HttpSession session= req.getSession();
        User user= (User) session.getAttribute("user");
        if(user!=null){
            //如果用户已经登录，直接重定向到首页
            resp.sendRedirect(req.getContextPath()+"/home");
            return;
        }
        Context context=new Context();
        //判断Cookie中是否保存之前登录过的用户信息
        //如果有则将数据保存在context中
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){//非空判断
            for(Cookie c:cookies){
                //如果e是用户名当前cookie的nam，取出放到context中
                if(c.getName().equals("name")){
                    String name= URLDecoder.decode(c.getValue(),"utf8");
                    context.setVariable("name",name);
                }
                //如果当前cookie的pwd是用户密码，取出放到context中
                if(c.getName().equals("pwd")){
                    String pwd= c.getValue();
                    context.setVariable("pwd",pwd);
                }
            }
        }

        THUtils.print("blog/login.html",context,resp);
    }
}
