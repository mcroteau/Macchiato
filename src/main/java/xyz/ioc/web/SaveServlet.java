package xyz.ioc.web;

import io.github.mcroteau.Parakeet;
import xyz.ioc.ordinary.Constants;

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

        if(parakeet.isAuthenticated()){
            //save
            
            req.getRequestDispatcher("/jsp/create.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(context.getContextPath() + "/signin");
        }
    }
}
