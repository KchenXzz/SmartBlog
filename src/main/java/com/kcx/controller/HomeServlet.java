package com.kcx.controller;

import com.kcx.dao.ArticleDao;
import com.kcx.dao.LinkDao;
import com.kcx.dao.TagDao;
import com.kcx.extity.Article;
import com.kcx.extity.Link;
import com.kcx.extity.Tag;
import com.kcx.util.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description 首页请求处理类
 * @createTime 26/09/2023 9:30 am
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        ArticleDao articleDao = new ArticleDao();
        //获取置顶文章集合
        List<Article> homeList = articleDao.getHomeList();

        Context context = new Context();
        String username = req.getParameter("name");
        System.out.println("home "+(username==null));
        context.setVariable("username",username);

        //第 1 篇
        context.setVariable("first", homeList.get(0));
        //第 2~4 篇
        context.setVariable("head", homeList.subList(1, 4));
        //第 4~8 篇
        context.setVariable("body", homeList.subList(4, homeList.size()));

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

        THUtils.print("blog/index.html",context,res);
    }
}
