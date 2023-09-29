package com.kcx.dao;

import com.kcx.extity.Tag;
import com.kcx.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description 根据文章id查询文章相关标签列表
 * @createTime 25/09/2023 4:23 pm
 */
public class TagDao {


    /**
     * 根据id 查标签
     *
     * @param oId 要查询的oId
     * @return 标签集合
     */
    public List<Tag> getTagsByArticleId(int oId) {
        List<Tag> list = new ArrayList<>();
        //根据id 查标签
        try (Connection conn = DBUtils.getConn()) {
            //使用子查询  只需要查询一次 就可以得到tag 只需要while 遍历一次
            String sql = "SELECT oid, referencecount, title FROM tag WHERE oId IN (SELECT tag_oId FROM tag_article WHERE article_oId=?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, oId);
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                list.add(new Tag(set.getInt(1), set.getInt(2), set.getString(3)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取关联次数前五的所有标签
     * @return 标签集合
     */
    public List<Tag> getTagType() {
        List<Tag> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn()) {
            String sql = "SELECT oid, referenceCount, title FROM tag ORDER BY referenceCount DESC LIMIT 0,5";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                list.add(new Tag(set.getInt(1), set.getInt(2), set.getString(3)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
