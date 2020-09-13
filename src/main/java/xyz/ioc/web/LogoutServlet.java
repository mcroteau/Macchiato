package xyz.ioc.web;

import io.github.mcroteau.Parakeet;
import xyz.ioc.factory.ParakeetFactory;
import xyz.ioc.ordinary.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        Parakeet parakeet = (Parakeet) context.getAttribute(Constants.PARAKEET_LOOKUP);
        parakeet.logout();

        resp.sendRedirect(req.getContextPath() + "/");
    }

}
