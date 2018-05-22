package com.hitrader.daoimpl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.HandlerBase;

import com.hitrader.model.DarkHorse;

import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

public class BaseDao {
    public final static String DRIVER = "com.mysql.jdbc.Driver";
    public final static String path = "jdbc:mysql://10.203.206.234:3306/hia";
    public final static String name = "hia";
    public final static String password = "SubVersion1234567890";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	
    static{
        try {
            Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
	
    public Connection getConn(){
	try {
	    conn = DriverManager.getConnection(path, name, password);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	    return conn;
    }
	
    public boolean operUpdate(String sql, List<Object> params){
	int res = 0;
	conn = getConn();
	try {
	    ps = conn.prepareStatement(sql);
	    for(int i = 0; i < params.size(); i++){
	        ps.setObject(i+1, params.get(i));
	    }
	    res = ps.executeUpdate();
	    System.out.println("½á¹ûÎª: " + res);
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    close(conn, ps, null);
	}
		
	if(res>0){
	    return true;
	}
	    return false;
    }
	
    public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls)throws Exception {
        List<T> data = new ArrayList<T>();
	try{
	    conn = getConn();
	    ps = conn.prepareStatement(sql);
	    if(params != null){
	        for(int i = 0; i < params.size(); i++){
		    ps.setObject(i+1, params.get(i));
		}
	    }
			
	    rs = ps.executeQuery();
	    ResultSetMetaData rsd = rs.getMetaData();
	    while(rs.next()){
		T m = cls.newInstance();
		for(int i = 0; i < rsd.getColumnCount(); i++){
		    String col_name = rsd.getColumnName(i+1);
		    Object values = rs.getObject(col_name);
		    Field field = cls.getDeclaredField(col_name);
		    field.setAccessible(true);
		    field.set(m, values);
		}
		data.add(m);
	    }
	    return data;
	}catch(SQLException e){
	    e.printStackTrace();
	}finally {
	    close(conn, ps, rs);
	}
	    return null;
    }
	
    public <T> List<Map> operDarkHorse(String sql, List<Object> params, Class<T> cls)throws Exception {
        List<Map> data = new ArrayList<Map>();
	try{
	    conn = getConn();
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
	    while(rs.next()){
		Map<Object, Object> map = new HashMap<Object, Object>();	
				
		Object idValue = rs.getObject("id");
		Object roleValue = rs.getObject("role");
				Object aidValue = rs.getObject("aid");
				Object unameValue = rs.getObject("uname");
				Object headValue = rs.getObject("head");
				Object nationalNameValue = rs.getObject("national_name");
				Object nationalUsNameValue = rs.getObject("national_us_name");
				Object nationalTwNameValue = rs.getObject("national_tw_name");
				Object nationalByNameValue = rs.getObject("national_by_name");
				Object flagImgSrcValue = rs.getObject("flag_img_src");
				Object commodityIdValue = rs.getObject("commodity_id");
				Object commodityNameValue = rs.getObject("commodity_name");
				Object strategyIdValue = rs.getObject("strategy_id");
				Object nextWinRateValue = rs.getObject("next_win_rate");
				Object crscValue = rs.getObject("crsc");		
				
				map.put("id", idValue);
				map.put("role", roleValue);
				map.put("aid", aidValue);
				map.put("uname", unameValue);
				map.put("head", headValue);
				map.put("national_name", nationalNameValue);
				map.put("national_us_name", nationalUsNameValue);
				map.put("national_tw_name", nationalTwNameValue);
				map.put("national_by_name", nationalByNameValue);
				map.put("flag_img_src", flagImgSrcValue);
				map.put("commodity_id", commodityIdValue);
				map.put("commodity_name", commodityNameValue);
				map.put("strategy_id", strategyIdValue);
				map.put("next_win_rate", nextWinRateValue);
				map.put("crsc", crscValue);
				
				data.add(map);
			}
			return data;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return null;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
