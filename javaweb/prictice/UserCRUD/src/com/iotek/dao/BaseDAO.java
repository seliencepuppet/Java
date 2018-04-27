package com.iotek.dao;

import java.sql.*;

/**
 * Created by vitme on 2016/9/6.
 */
public class BaseDAO {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/HT1111111?userUnicode=true&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASS = "root";
    private Connection conn = null;
    private PreparedStatement preStat = null;
    private ResultSet rs = null;
    public BaseDAO(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean doQuery(String sql,Object...param){
        conn = getConn();
        try {
            preStat = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                preStat.setObject(i+1,param[i]);
            }
            rs = preStat.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return false;
    }

    public boolean doUpdate(String sql,Object...param){
        conn = getConn();
        try {
            preStat = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                preStat.setObject(i+1,param[i]);
            }
            int rows = preStat.executeUpdate();
            if (0!=rows){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return false;
    }

    public void closeAll(){
        if (null!=rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null!=preStat){
            try {
                preStat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null!=conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
