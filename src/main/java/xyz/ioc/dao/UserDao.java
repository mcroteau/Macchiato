package xyz.ioc.dao;

public class UserDao {

    public String getPassword(String username){
        String sql = "select * from accounts where username = '" + username + "'";
        return "";
    }

}
