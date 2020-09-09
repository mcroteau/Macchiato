package xyz.ioc.web;

import io.github.mcroteau.Parakeet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    Parakeet parakeet;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

        if(parakeet.isAuthenticated()){
            req.getRequestDispatcher("/jsp/blog/posts.jsp").forward(req, resp);
        }else{
            req.setAttribute("message", "You must be signed in before continuing...");
            req.getRequestDispatcher("/jsp/signin.jsp");
        }
    }
}
