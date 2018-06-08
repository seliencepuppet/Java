#### 使用jdbc的方式连接mysql数据库

```db.config
driver = com.mysql.jdbc.Driver
path = jdbc.mysql://127.0.0.1:3306/school
name = root
password = 123456
```

```java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public static String driver;
    public static String path;
    public static String name;
    public static String password;

    static{
        try{
	    try{
		BufferedReader br = new BufferedReader(new FileReader(new File("config.pro")));
		driver = br.readLine().split("=")[1].trim();
		path = br.readLine().split("=")[1].trim();
		name = br.readLine().split("=")[1].trim();
		password = br.readLine().split("=")[1].trim();
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	    Class.forName(driver);
        }catch(ClassNotFoundException e){
	    e.printStackTrace();
	}
    }
	
    public Connection getConnection(){
	Connection connection = null;
	try{
	    connection = DriverManager.getConnection(path, name, password);
	}catch(SQLException e){
	    e.printStackTrace();
	}
	return connection;
    }
	
    public boolean operUpdate(String sql, List<Object> params){
	Connection connection = getConnection();
	PreparedStatement ps = null;
	int res = 0;
	try{
	    ps = connection.prepareStatement(sql);
	    for(int i = 0; i < params.size(); i++){
	        ps.setObject(i+1, params.get(i));
	    }
	    res = ps.executeUpdate();
	}catch(SQLException e){
	    e.printStackTrace();
	}
	close(connection, ps, null);
	if(res > 0){
	    return true;
	}
	return false;
    }

    public void close(Connection connection, Statement statement, ResultSet rs){
	if(rs != null){
	    try{
	        rs.close();
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	}

	if(statement != null){
	    try{
	        statement.close();
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	}

	if(connection != null){
	    try{
		connection.close();
	    }catch(SQLException e){
		e.printStackTrace();
	    }
	}
    }

    public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls) throws Exception{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<T> data = new ArrayList<T>();
	try{
	    conn = getConnection();
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
	}catch(SQLException e){
	    e.printStackTrace();
	}finally{
	    close(conn, ps, rs);
	}
    }
    
}

```








```java
import java.sql.*;

/**
 * Created by vitme on 2016/9/30.
 */
public class BaseDAO {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/WebBuyer?useUnicode=true&characterEncoding=UTF-8";
    private final String NAME = "root";
    private final String PASS = "123456";
    private Connection conn = null;
    private PreparedStatement preStat = null;
    private ResultSet rs = null;

    public BaseDAO() {
        try {
            Class.forName(DRIVER);//注册驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        try {
            conn = DriverManager.getConnection(URL, NAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean doQuery(String sql, Object... param) {
        conn = getConn();
        try {
            preStat = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                preStat.setObject(i + 1, param[i]);
            }
            rs = preStat.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    public boolean doUpdate(String sql, Object... param) {
        conn = getConn();
        try {
            preStat = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                preStat.setObject(i + 1, param[i]);
            }
            int rows = preStat.executeUpdate();
            if (0 != rows) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }


    public void closeAll() {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != preStat) {
            try {
                preStat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```
