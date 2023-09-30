package com.kcx.controller;

import com.kcx.dao.CommentDao;
import com.kcx.extity.Comment;
import com.kcx.extity.User;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 29/09/2023 4:31 pm
 */
@WebServlet("/comment")
public class CommentActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String article = req.getParameter("article");
        String articleId = article.split(":")[0];
        String articleTitle = article.split(":")[1];
        System.out.println(articleTitle);
        String commentContent = req.getParameter("commentContent");
        long created = System.currentTimeMillis();
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getOId();
        String name = user.getUsername();
        Comment comment = new Comment(commentContent, created, name, Integer.parseInt(articleId), userId);
        // 添加评论并获取结果
        new CommentDao().addComment(comment);
        res.setCharacterEncoding("utf-8");
        // 将中文参数进行URL编码
        String encodedTitle = URLEncoder.encode(articleTitle, "UTF-8");
        // 使用编码后的参数构建重定向URL
        res.sendRedirect(req.getContextPath() + "/article?title=" + encodedTitle);
    }

}
