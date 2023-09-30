package com.kcx.dao;

import com.kcx.extity.Article;
import com.kcx.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description 与文章有关的数据访问层
 * @createTime 25/09/2023 4:50 pm
 */
public class ArticleDao {

    /**
     * 获取置顶文章 （8篇）
     *
     * @return 指定文章集合
     */
    public List<Article> getHomeList() {
        List<Article> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn()) {
            String sql = "SELECT " +
                    "a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.imgName,u.userName " +
                    "FROM article AS a INNER JOIN user AS u " +
                    "ON  a.authorId=u.oId ORDER BY a.putTop DESC ,a.created DESC LIMIT 0,8;";
            PreparedStatement pst = conn.prepareStatement(sql);
            return eachResultSet(pst, list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取右侧分类文章
     *
     * @return 指定文章集合
     */
    public List<Article> getListByType(String type) {
        List<Article> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn()) {
            //ORDER BY 子句通常需要指定列名，而不能使用参数化查询方式动态设置列名。因此，无法使用占位符 ? 来代替列名。
            String sql = "SELECT oId,title,created FROM article ORDER BY " + type + " DESC LIMIT 0,5;";
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                int oId = set.getInt(1);
                String title = set.getString(2);
                Article article = new Article(oId, title);
                //设置当前文章的相关的标签
                TagDao tagDao = new TagDao();
                article.setTags(tagDao.getTagsByArticleId(oId));
                //放到list里
                list.add(article);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 通过标题获取文章
     *
     * @param title 文章标题
     * @return 文章对象
     */
    public Article getArticleByTitle(String title) {
        //ORDER BY 子句通常需要指定列名，而不能使用参数化查询方式动态设置列名。因此，无法使用占位符 ? 来代替列名。
        try (Connection conn = DBUtils.getConn()) {
            String sql = "SELECT a.oId,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.imgName,u.userName " +
                    "FROM article AS a INNER JOIN user AS u " +
                    "ON  a.authorId=u.oId WHERE a.title=?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, title);
            ResultSet set = pst.executeQuery();
            if (set.next()) {
                int oId = set.getInt(1);
                String abs = set.getString(2);
                int commentCount = set.getInt(3);
                int viewCount = set.getInt(4);
                int putTop = set.getInt(5);
                long created = set.getLong(6);
                String imgName = set.getString(7);
                String userName = set.getString(8);
                Article article = new Article(oId, title, abs, commentCount, viewCount, putTop, created, imgName, userName);
                //设置当前文章的相关的标签
                TagDao tagDao = new TagDao();
                article.setTags(tagDao.getTagsByArticleId(oId));
                return article;
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 查询文章列表 按照发布时间，倒叙返回
     *
     * @return 文章集合
     */
    public List<Article> getArticleList() {
        try (Connection conn = DBUtils.getConn()) {
            List<Article> list = new ArrayList<>();
            String sql = "SELECT " +
                    "a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.imgName,u.userName " +
                    "FROM article AS a INNER JOIN user AS u " +
                    "ON  a.authorId=u.oId ORDER BY a.created DESC LIMIT 0,8;";
            PreparedStatement pst = conn.prepareStatement(sql);
            return eachResultSet(pst, list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 按照关键字，查询文章
     *
     * @return 文章对象
     */
    public List<Article> getArticleByKeyWord(String keyword) {
        try (Connection conn = DBUtils.getConn()) {
            List<Article> list = new ArrayList<>();
            String sql = "SELECT " +
                    "a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.imgName,u.userName " +
                    "FROM article AS a INNER JOIN user AS u " +
                    "ON  a.authorId=u.oId WHERE a.title LIKE ? ORDER BY a.created DESC LIMIT 0,8;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            return eachResultSet(pst, list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取含有当前标签的所有文章
     * @param type 文章标签
     * @return 文章集合
     */
    public List<Article> getArticleByType(String type) {
        try (Connection conn = DBUtils.getConn()) {
            List<Article> list = new ArrayList<>();
            String sql = "SELECT " +
                    "a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.imgName,u.userName " +
                    "FROM article AS a INNER JOIN user AS u " +
                    "ON  a.authorId=u.oId WHERE a.oid IN "+
                    "(SELECT article_oId FROM tag_article WHERE tag_oId IN " +
                    "(SELECT oId FROM tag WHERE title=?)) ORDER BY a.created DESC LIMIT 0,8;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, type);
            return eachResultSet(pst, list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 根据标题获取文章的内容
     *
     * @param title 文章标题
     * @return 文章内容字符串
     */
    public String getContentByTitle(String title) {
        try (Connection conn = DBUtils.getConn()) {
            List<String> list = new ArrayList<>();
            String sql = "SELECT " +
                    "content " +
                    "FROM article  " +
                    "WHERE title=?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, title);
            ResultSet set = pst.executeQuery();
            String content = "";
            while (set.next()) {
                content = set.getString(1);
            }
            return content;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Article> eachResultSet(PreparedStatement pst, List<Article> list) throws SQLException {
        ResultSet set = pst.executeQuery();
        while (set.next()) {
            int oId = set.getInt(1);
            String title = set.getString(2);
            String abs = set.getString(3);
            int commentCount = set.getInt(4);
            int viewCount = set.getInt(5);
            int putTop = set.getInt(6);
            long created = set.getLong(7);
            String imgName = set.getString(8);
            String userName = set.getString(9);
            Article article = new Article(oId, title, abs, commentCount, viewCount, putTop, created, imgName, userName);
            //设置当前文章的相关的标签
            TagDao tagDao = new TagDao();
            article.setTags(tagDao.getTagsByArticleId(oId));
            //放到list里
            list.add(article);
        }
        return list;
    }

    public boolean addArticle(Article article, int userOid) {
        try (Connection conn = DBUtils.getConn()) {
            String sql = "INSERT INTO article(title,abstract,content,commentCount,viewCount,putTop,imgName,created,authorId) " +
                    "VALUES (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, article.getTitle());
            pst.setString(2, article.getAbs());
            pst.setString(3, article.getContent());
            pst.setInt(4, article.getCommentCount());
            pst.setInt(5, article.getViewCount());
            pst.setInt(6, article.getPutTop());
            pst.setString(7, article.getImgName());
            pst.setLong(8, article.getCreated());
            pst.setInt(9, userOid);//当前登录用户就是作者
            return pst.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
