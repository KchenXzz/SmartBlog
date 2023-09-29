package com.kcx.dao;

import com.kcx.dao.ArticleDao;
import com.kcx.extity.Article;
import org.junit.Test;

import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 25/09/2023 4:43 pm
 */
public class TestArticleDao {


    @Test
    public void testGetHomeList() {
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.getHomeList();
        for (Article article : list) {
            System.out.println(article.getTitle() + " " + article.getCreateStr() + " " + article.getViewCount() + " " + article.getCommentCount());
        }
    }

    @Test
    public void testGetArticleList() {
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.getArticleList();
        for (Article article : list) {
            System.out.println(article.getTitle() + " " + article.getCreateStr());
        }
    }


    @Test
    public void testGetArticleByKeyWord() {
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.getArticleByKeyWord("的");
        for (Article article : list) {
            System.out.println(article.getTitle() + " " + article.getCreateStr());
        }
    }


    @Test
    public void testArticleDaoGetListByType() {
        ArticleDao articleDao = new ArticleDao();
        //查询右侧文章
        //最新文章
        List<Article> timeList = articleDao.getListByType("created");
        //评论最多文章
        List<Article> commentList = articleDao.getListByType("commentCount");
        //浏览最多文章
        List<Article> viewList = articleDao.getListByType("viewCount");
        for (Article article : timeList) {
            System.out.print(article.getTitle() + " ");
        }
        System.out.println();
        for (Article article : commentList) {
            System.out.print(article.getTitle() + " ");
        }
        System.out.println();
        for (Article article : viewList) {
            System.out.print(article.getTitle() + " ");
        }


    }

    @Test
    public void testArticleDaoGetArticleByTitle() {
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticleByTitle("法国隆重纪念一战结束百年");
        System.out.println(article);
    }

    @Test
    public void testGetContentByTitle() {
        ArticleDao articleDao = new ArticleDao();
      String list = articleDao.getContentByTitle("好评大片《我不是药神》观后的反思");
        System.out.println(list);
    }


}
