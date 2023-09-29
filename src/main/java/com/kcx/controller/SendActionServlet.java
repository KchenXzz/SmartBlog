package com.kcx.controller;

import com.kcx.dao.ArticleDao;
import com.kcx.extity.Article;
import com.kcx.extity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 29/09/2023 4:57 pm
 */
@WebServlet("/send")
public class SendActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取文章信息(send.html表单中的值)
        String title= req.getParameter("title");
        String abs=req.getParameter("abs");
        String content=req.getParameter("content");
        String imgName= req.getParameter("imgName");
        String putTop=req.getParameter("putTop");
        Long creaed = System.currentTimeMillis();
        User user = (User)req.getSession().getAttribute("user");
        //是否置顶，转int
        int isPutTop = (putTop == null ? 0 : 1);

        Article article = new Article(user.getOId(), title, abs, 0, 0, content, isPutTop, creaed, imgName, null);
        ArticleDao articleDao = new ArticleDao();
        if (articleDao.addArticle(article, article.getOId())){
            //文章发布成功后跳转页面到文章列表页面
            res.sendRedirect(req.getContextPath() + "/list");
        }else {
            PrintWriter out = res.getWriter();
            // 登录失败，返回一个包含JavaScript提示和重定向的响应
            out.println("<script>alert('发布失败，请稍后重试或检查内容。');</script>");
            out.close();
        }

    }
}
