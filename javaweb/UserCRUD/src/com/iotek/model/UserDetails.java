package com.iotek.model;

/**
 * Created by vitme on 2016/9/6.
 */
public class UserDetails {
    private String id;
    private String address;
    private String phone;
    private String postid;
    private String userID;

    public UserDetails() {
    }

    public UserDetails(String id, String address, String phone, String postid, String userID) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.postid = postid;
        this.userID = userID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetails that = (UserDetails) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (postid != null ? !postid.equals(that.postid) : that.postid != null) return false;
        return !(userID != null ? !userID.equals(that.userID) : that.userID != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (postid != null ? postid.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", postid='" + postid + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
