package xyz.ioc.web.post;

import io.github.mcroteau.Parakeet;
import xyz.ioc.dao.PostDao;
import xyz.ioc.model.Post;
import xyz.ioc.ordinary.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        Parakeet parakeet = (Parakeet) context.getAttribute(Constants.PARAKEET_LOOKUP);
        PostDao postDao = (PostDao) context.getAttribute(Constants.POSTS_DAO_LOOKUP);

        if(parakeet.isAuthenticated() &&
                parakeet.hasRole(Constants.ROLE_ADMIN)){

            long id = Long.parseLong(req.getParameter("id"));
            postDao.delete(id);
            resp.sendRedirect(context.getContextPath() + "/");

        }else{
            req.setAttribute("message", "You must be signed in before continuing...");
            req.getRequestDispatcher("/jsp/signin.jsp");
        }
    }
}
