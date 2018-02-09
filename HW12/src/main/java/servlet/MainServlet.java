package servlet;

import base.DBService;
import base.DataSet;
import base.UserDataSet;
import connnection.DBServiceCache;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jetty.JdbcCacheMain;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private UserDataSet userDataSet;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map mapParam = request.getParameterMap();
        if (request.getParameter("add") != null) {
            saveUser(request);

        }


        response.getWriter().println(getPage(request));

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
            Map<String, String[]> param = request.getParameterMap();
            Configuration configuration = new Configuration();
            Template template = configuration.getTemplate("public_html/index.html");

            Map<String, String> map = new HashMap<>();

            if (request.getParameter("cache") != null) {
                map.put("cache", JdbcCacheMain.getCache().toString());
                map.put("parameters" , "");
            }
            else {
//                map.put("parameters", request.getParameterMap().toString());
                map.put("parameters", request.getParameterMap().toString());
                map.put("cache", "wrong button!");

                //request.getQueryString();
            }
            template.process(map, stream);

            return stream.toString();
        } catch (TemplateException e) {
            throw  new IOException();
        }

    }

    private void saveUser(HttpServletRequest request) {
        UserDataSet user = new UserDataSet();
        user.setName(request.getParameter("username"));
        user.setAge( Integer.parseInt(request.getParameter("age").replaceAll("[\\D]","")));


        try (DBService dbService = new DBServiceCache()) {
            dbService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
