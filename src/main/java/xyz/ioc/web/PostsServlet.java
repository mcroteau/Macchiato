package xyz.ioc.web;

import io.github.mcroteau.Parakeet;
import xyz.ioc.dao.PostsDao;
import xyz.ioc.ordinary.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostsServlet extends HttpServlet {

    PostsDao postsDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        ServletContext context = req.getServletContext();
        Parakeet parakeet = (Parakeet) context.getAttribute(Constants.PARAKEET_LOOKUP);
        PostsDao postsDao = (PostsDao) context.getAttribute(Constants.POSTS_DAO_LOOKUP);

        if(parakeet.isAuthenticated()){

        }

    }
}
