package com.iotek.dao;

import com.iotek.model.User;
import com.iotek.model.UserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vitme on 2016/9/6.
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {
    private Connection conn = null;
    private PreparedStatement preStat = null;
    private ResultSet rs = null;
    @Override
    public User checkLogin(User user) {
        String sql = "select u.id id, u.name name,u.pass pass,u.age age,u.img img,ud.id uid,ud.address address,ud.phone phone,ud.postid postid,ud.userID userID from t_user u left join t_userDetails ud on u.id = ud.userID where u.name=? and pass=?";
        conn = getConn();
        try {
            preStat = conn.prepareStatement(sql);
            preStat.setString(1,user.getName());
            preStat.setString(2,user.getPass());
            rs = preStat.executeQuery();
            User loadUser = new User();
            Set<UserDetails> userDetailsSet = new HashSet<>();
            boolean flag = false;
            while (rs.next()){
                flag = true;
                loadUser.setId(rs.getString("id"));
                loadUser.setName(rs.getString("name"));
                loadUser.setPass(rs.getString("pass"));
                loadUser.setAge(rs.getInt("age"));
                loadUser.setImg(rs.getString("img"));
                UserDetails userDetails = new UserDetails();
                userDetails.setId(rs.getString("uid"));
                userDetails.setAddress(rs.getString("address"));
                userDetails.setPhone(rs.getString("phone"));
                userDetails.setPostid(rs.getString("postid"));
                userDetails.setUserID(rs.getString("userID"));
                userDetailsSet.add(userDetails);//把本次循环得到的userDetails放入userDetailsSet集合中
            }
            loadUser.setUserDetailsSet(userDetailsSet);//把得到的userDetails集合放到user对象中
            if (flag){
                System.out.println(loadUser);
                return loadUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return null;
    }

    @Override
    public boolean userNameIsInvalidate(String name) {
        String sql = "select * from t_user u where u.name=?";
        return doQuery(sql,name);
    }

    @Override
    public boolean createUser(User user) {
        String sql = "insert into t_user values(?,?,?,?,?)";
        return doUpdate(sql,user.getId(),user.getName(),user.getPass(),user.getAge(),"images/default.jpg");
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update t_user u set u.pass = ?,u.age = ?,u.img = ? where u.id = ?";
        return doUpdate(sql,user.getPass(),user.getAge(),user.getImg(),user.getId());
    }

    @Override
    public boolean createDetails(UserDetails userDetails) {
        return false;
    }

    @Override
    public boolean updateDetails(UserDetails userDetails) {
        String sql = "update t_userDetails set address=?,phone=?,postid=? where id=?";
        return doUpdate(sql,userDetails.getAddress(),userDetails.getPhone(),userDetails.getPostid(),userDetails.getId());
    }

    @Override
    public boolean deleteDetails(UserDetails userDetails) {
        String sql = "delete from t_userDetails where id =?";
        return doUpdate(sql,userDetails.getId());
    }
}
