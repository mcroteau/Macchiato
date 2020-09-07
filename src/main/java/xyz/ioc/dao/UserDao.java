package xyz.ioc.dao;

import xyz.ioc.factory.DbFactory;
import xyz.ioc.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDao {

    Connection connection;

    public UserDao(){
        connection = DbFactory.getConnection();
    }

    public User getUser(String username){
        try {
            Statement stmt = connection.createStatement();
            String sql = "select * from accounts where username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String getPassword(String username){
        try {
            Statement stmt = connection.createStatement();
            String sql = "select password from accounts where username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Set<String> getUserRoles(String username){
        try {
            User user = getUser(username);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select r.name from account_roles ur, role r where ur.role_id = r.id and ur.account_id = " + user.getId());
            Set roles = new HashSet();
            while(rs.next()){
                String role = rs.getString("name");
                roles.add(role);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
