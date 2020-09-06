package xyz.ioc.web;

import io.github.mcroteau.Parakeet;
import xyz.ioc.factory.ParakeetFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    Parakeet parakeet;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        ParakeetFactory parakeetFactory = (ParakeetFactory) context.getAttribute("parakeetFactory");
        if(parakeetFactory == null) {
            parakeetFactory = new ParakeetFactory();
            context.setAttribute("parakeetFactory", parakeetFactory);
        }
        parakeet = parakeetFactory.getParakeet();
    }

}
