package servlets;

import resources.ResourceServer;
import resources.ResourceServerI;
import resources.TestResource;
import sax.ReadXMLFileSAX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user
 * on 21.12.2018
 */

public class HomePageServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(HomePageServlet.class.getName());
    public static final String PAGE_URL = "/resources";

    private ResourceServerI resourceServer;

    public HomePageServlet(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

        public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().println("Hello");

        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        String path = request.getParameter("path");

        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);

        resourceServer.setResource(resource);
        System.out.println(resourceServer.readName());
        System.out.println(resourceServer.readAge());
        response.getWriter().println(resource);
        response.setContentType("text/html;charset=utf-8");

        response.setStatus(HttpServletResponse.SC_OK);


    }
}
