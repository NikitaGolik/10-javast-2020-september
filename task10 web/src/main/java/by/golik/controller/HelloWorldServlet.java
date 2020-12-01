package by.golik.controller;

import by.golik.builder.*;
import by.golik.entity.Flower;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 * @author Nikita Golik
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/Hello")
public class HelloWorldServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(HelloWorldServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
//       PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Hello World!</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Hello World!</h1>");
//        out.println("</body>");
//        out.println("</html>");


        FlowerDOMBuilder builder = new FlowerDOMBuilder();
        try {
            builder.buildFlowerList("D:\\eclipse-workspace\\10-javast-2020-september\\task10 web\\src\\main\\resources\\data\\flowers.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }
        request.setAttribute("flowerList", builder.getFlowerSet().toString());
        request.getRequestDispatcher("/flowers.jsp").forward(request, response);



    }



}
