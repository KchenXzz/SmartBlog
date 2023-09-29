package com.kcx.controller;

import com.kcx.dao.ArticleDao;
import com.kcx.dao.LinkDao;
import com.kcx.dao.TagDao;
import com.kcx.extity.Article;
import com.kcx.extity.Link;
import com.kcx.extity.Tag;
import com.kcx.extity.User;
import com.kcx.util.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description 处理请求文章列表的处理类
 * @createTime 26/09/2023 3:49 pm
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获得session会话对象
        HttpSession session= req.getSession();
        User user=(User)session.getAttribute("user");
        if(user==null){
            //用户没有登录
            //登录失败，重定向登录页面
            res.sendRedirect(req.getContextPath()+"/showlogin");
            //防止后面的代码运行
            return;
        }
        ArticleDao articleDao = new ArticleDao();
        Context context = new Context();

        List<Article> articleList = articleDao.getArticleList();
        context.setVariable("list",articleList);
        //查询右侧文章
        //最新文章
        List<Article> timeList = articleDao.getListByType("created");
        //评论最多文章
        List<Article> commentList = articleDao.getListByType("commentCount");
        //浏览最多文章
        List<Article> viewList = articleDao.getListByType("viewCount");
        //保存
        context.setVariable("timeList",timeList);
        context.setVariable("commentList",commentList);
        context.setVariable("viewList",viewList);
        //分类标签
        TagDao tagDao = new TagDao();
        List<Tag> tagTypeList = tagDao.getTagType();
        context.setVariable("tagTypeList",tagTypeList);
        //友情链接
        LinkDao linkDao=new LinkDao();
        List<Link> linkList = linkDao.getLinkList();
        context.setVariable("linkList",linkList);
        //将session中获得的登录用户信息保存到context中
        //以便模板页面使用
        context.setVariable("user",user);

        THUtils.print("blog/list.html",context,res);
    }
}
