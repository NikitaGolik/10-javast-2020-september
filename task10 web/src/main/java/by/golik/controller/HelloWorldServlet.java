package by.golik.controller;

import by.golik.builder.FlowerDOMBuilder;
import by.golik.builder.FlowerSaxBuilder;
import by.golik.builder.FlowerStAXBuilder;
import by.golik.entity.Flower;
import by.golik.exception.ParserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * @author Nikita Golik
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/Hello")
public class HelloWorldServlet extends HttpServlet {

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

        FlowerDOMBuilder flowersDOMBuilder = new FlowerDOMBuilder();
        try {
            HashSet<Flower> set = new HashSet<>();
            flowersDOMBuilder.buildFlowerList("src/main/resources/data/flowers.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }

        request.setAttribute("listFlowers", flowersDOMBuilder.getFlowerSet());


        getServletContext().getRequestDispatcher("/flowers.jsp").forward(request, response);


    }
}
