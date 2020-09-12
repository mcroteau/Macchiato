package xyz.ioc.web.post;

import io.github.mcroteau.Parakeet;
import xyz.ioc.dao.PostDao;
import xyz.ioc.model.Post;
import xyz.ioc.ordinary.Constants;
import xyz.ioc.ordinary.Utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {

    PostDao postDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        Parakeet parakeet = (Parakeet) context.getAttribute(Constants.PARAKEET_LOOKUP);
        PostDao postDao = (PostDao) context.getAttribute(Constants.POSTS_DAO_LOOKUP);

        if(parakeet.isAuthenticated()) {
            List<Post> posts = postDao.getPosts(parakeet.getUser());
            for (Post post : posts) {
                post.setDate(Utils.getDate(post.getDateCreated()));
            }
            req.setAttribute("posts", posts);
        }
        req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
    }
}
