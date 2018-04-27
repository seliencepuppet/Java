package com.iotek.dao;

import com.iotek.model.User;
import com.iotek.model.UserDetails;

/**
 * Created by vitme on 2016/9/6.
 */
public interface UserDAO {

    /**
     * @param user
     *      user only own a name and a pass
     * */
    User checkLogin(User user);

    boolean userNameIsInvalidate(String name);

    boolean createUser(User user);

    boolean updateUser(User user);

    boolean createDetails(UserDetails userDetails);

    boolean updateDetails(UserDetails userDetails);

    boolean deleteDetails(UserDetails userDetails);


}
