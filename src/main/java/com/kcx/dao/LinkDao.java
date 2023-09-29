package com.kcx.dao;

import com.kcx.extity.Link;
import com.kcx.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description 处理链接的数据访问层
 * @createTime 26/09/2023 10:06 am
 */
public class LinkDao {


    /**
     * 获取所有的友情连接的标题
     * @return 链接集合
     */
    public List<Link> getLinkList(){
        try (Connection conn = DBUtils.getConn()) {
            List<Link> list = new ArrayList<>();
            Statement statement = conn.createStatement();
            String sql="SELECT address,title FROM link LIMIT 0,8;";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                list.add(new Link(set.getString(1),set.getString(2)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
