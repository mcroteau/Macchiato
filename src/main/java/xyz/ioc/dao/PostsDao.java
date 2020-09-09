package xyz.ioc.dao;

import xyz.ioc.factory.DbFactory;
import xyz.ioc.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostsDao {
    Connection connection;

    public PostsDao(){
        connection = DbFactory.getConnection();
    }

    public boolean save(Post post){
        try {
            String sql = "insert into posts values ( null, ?, ?, ? );";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setLong(3, post.getDateCreated());
            ResultSet rs = stmt.executeQuery(sql);
            int result = stmt.executeUpdate();
            if(result == 1) return true;

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
