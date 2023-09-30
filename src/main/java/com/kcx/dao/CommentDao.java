package com.kcx.dao;

import com.kcx.extity.Comment;
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
 * @description 文章评论数据操作层
 * @createTime 29/09/2023 4:16 pm
 */
public class CommentDao {

    /**
     按文章id查询该篇文章的所有评论
     * @return 评论对象
     */
    public List<Comment> getCommentsByArticleId(int oid){
        List<Comment> comments=new ArrayList<>();
        try(Connection conn= DBUtils.getConn()){
            String sql="SELECT oid,content,created,name  " +
                    "from comment WHERE onid=?;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,oid);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String content= rs.getString(2);
                long created= rs.getLong(3);
                String name=rs.getString(4);
                comments.add(new Comment(oid,content,created,name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public boolean addComment(Comment comment){

        try (Connection conn = DBUtils.getConn()){
            String sql="INSERT INTO comment(content,created,name,onId,userId) VALUES (?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,comment.getContent());
            pst.setString(2, comment.getCreated().toString());
            pst.setString(3,comment.getName());
            pst.setInt(4,comment.getOnId());
            pst.setInt(5,comment.getUserId());
            return pst.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
