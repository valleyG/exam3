package com.nm.exam3.utils;

import com.nm.exam3.poji.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class c3p0utilsTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void test(){
        String sql = "select * from t_student";
        System.out.println(c3p0utils.queryList(sql, Student.class, null));
    }
}