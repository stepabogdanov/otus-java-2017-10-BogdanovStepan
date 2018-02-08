package servlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map mapParam = request.getParameterMap();

        //request.getP
        response.getWriter().println(getPage(request));
        //response.getWriter().println(mapParam);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map mapParam = request.getParameterMap();


        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    String getPage(HttpServletRequest request) throws IOException {

        try (Writer stream = new StringWriter()) {
            String cacheValue = request.getParameter("username");
            System.out.println(cacheValue);
            Configuration configuration = new Configuration();
            Template template = configuration.getTemplate("public_html/index.html");
            Map<String, String> map = new HashMap<>();
            map.put("cache", cacheValue);
            template.process(map, stream);
            return stream.toString();
        } catch (TemplateException e) {
            throw  new IOException();
        }
        //return null;
    }
}
