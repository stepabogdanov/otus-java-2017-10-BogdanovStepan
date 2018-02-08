package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.MainServlet;

public class Main {
    public static void main(String[] args) throws Exception {




        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("public_html");

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        servletContextHandler.addServlet(MainServlet.class,  "/*");

        Server server = new Server(8080);
        server.setHandler(new HandlerList(resourceHandler, servletContextHandler));


        server.start();
        server.join();

    }
}
