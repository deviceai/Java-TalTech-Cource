package mywebapp.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyServletListener started!");

        //Some information for all servlets
        String servletInformation = "information";
        ServletContext context = sce.getServletContext();
        context.setAttribute("servletInformation", servletInformation);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyServletListener destroyed!");
    }
}
