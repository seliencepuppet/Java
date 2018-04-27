package com.iotek.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vitme on 2016/9/6.
 */
public class User {
    private String id;
    private String name;
    private String pass;
    private int age;
    private String img;
    private Set<UserDetails> userDetailsSet = new HashSet<>();

    public User() {
    }

    public User(String id, String name, String pass, int age, String img) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<UserDetails> getUserDetailsSet() {
        return userDetailsSet;
    }

    public void setUserDetailsSet(Set<UserDetails> userDetailsSet) {
        this.userDetailsSet = userDetailsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        if (img != null ? !img.equals(user.img) : user.img != null) return false;
        return !(userDetailsSet != null ? !userDetailsSet.equals(user.userDetailsSet) : user.userDetailsSet != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (userDetailsSet != null ? userDetailsSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", age=" + age +
                ", img='" + img + '\'' +
                ", userDetailsSet=" + userDetailsSet +
                '}';
    }
}
