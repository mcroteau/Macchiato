package xyz.ioc.dao;

import xyz.ioc.factory.DbFactory;
import xyz.ioc.model.Post;
import xyz.ioc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Post> getPosts(String username){
        try {
            Statement stmt = connection.createStatement();
            String sql = "select * from posts";
            ResultSet rs = stmt.executeQuery(sql);

            List<Post> posts = new ArrayList<Post>();
            while(rs.next()){
                Post post = new Post();
                post.setId(rs.getLong("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDateCreated(rs.getLong("date_created"));
                posts.add(post);
            }

            return posts;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
