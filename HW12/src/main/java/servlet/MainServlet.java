package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MainServlet extends HttpServlet{

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map mapParam = request.getParameterMap();


        System.out.println(request.getParameter("username"));

        response.getWriter().println(mapParam);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map mapParam = request.getParameterMap();

        doPost(request, response);

        response.getWriter().println(mapParam);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

}
