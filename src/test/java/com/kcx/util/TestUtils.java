package com.kcx.util;

import com.kcx.util.DBUtils;
import org.junit.Test;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 25/09/2023 2:42 pm
 */


public class TestUtils {


    @Test
    public void testDBConn(){
        try {
            System.out.println(DBUtils.getConn());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }




}
