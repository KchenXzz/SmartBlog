package com.kcx.dao;

import com.kcx.dao.TagDao;
import com.kcx.extity.Tag;
import org.junit.Test;

import java.util.List;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 26/09/2023 10:03 am
 */
public class TestTagDao {

    @Test
    public void testGetTagsByArticleId() {
        TagDao tagDao = new TagDao();
        List<Tag> list = tagDao.getTagsByArticleId(2);
        System.out.println(list);
    }
   @Test
    public void testGetTagType() {
        TagDao tagDao = new TagDao();
        List<Tag> list = tagDao.getTagType();
       for (Tag tag : list) {
           System.out.println(tag);
       }
    }


}
