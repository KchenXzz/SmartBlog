package com.kcx.dao;

import com.kcx.extity.Link;
import org.junit.Test;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 26/09/2023 11:04 am
 */
public class TestLinkDao {

    @Test
    public void testGetLinkList(){
        LinkDao linkDao = new LinkDao();
        for (Link link : linkDao.getLinkList()) {
            System.out.println(link);
        }
    }
}
