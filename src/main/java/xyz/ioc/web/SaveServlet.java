package xyz.ioc.web;

import io.github.mcroteau.Parakeet;
import xyz.ioc.dao.PostsDao;
import xyz.ioc.dao.UserDao;
import xyz.ioc.model.Post;
import xyz.ioc.model.User;
import xyz.ioc.ordinary.Constants;
import xyz.ioc.ordinary.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        Parakeet parakeet = (Parakeet) context.getAttribute(Constants.PARAKEET_LOOKUP);
        PostsDao postsDao = (PostsDao) context.getAttribute(Constants.POSTS_DAO_LOOKUP);
        UserDao userDao = (UserDao) context.getAttribute(Constants.USER_DAO_LOOKUP);

        if(parakeet.isAuthenticated()){
            User user = userDao.getUser(parakeet.getUser());
            Post post = new Post();
            String title = (String) req.getAttribute("title");
            String content = (String) req.getAttribute("content");

            post.setTitle(title);
            post.setContent(content);
            post.setDateCreated(Utils.getDate());
            post.setUserId(user.getId());

            postsDao.save(post);

            req.setAttribute("message", "Successfully saved post!");
            req.getRequestDispatcher("/jsp/create.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(context.getContextPath() + "/signin");
        }
    }
}