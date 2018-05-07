package com.nm.exam3.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class c3p0utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static QueryRunner qr= new QueryRunner(dataSource);

    private c3p0utils(){

    }
//  获取数据元
    public static ComboPooledDataSource getInstance(){
        return dataSource;
    }
    //获取连接
    public static Connection getConn(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }


    public static <T> List<T> queryList(String sql,Class<T> tClass,Object...params){
        try {
            return qr.query(sql,new BeanListHandler<T>(tClass),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static int update(String sql,Object...params){
        try {
            return qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static <T> T queryOne(String sql,Class<T> tClass ,Object...params){
        try {
            return qr.query(sql, new BeanHandler<T>(tClass),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
