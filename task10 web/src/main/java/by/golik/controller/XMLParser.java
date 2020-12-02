package by.golik.controller;

import by.golik.builder.*;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


/**
 * @author Nikita Golik
 */
@WebServlet(name = "XMLParser", urlPatterns = "/parser")
public class XMLParser extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(XMLParser.class);

    private static final String PARAMETER_FOR_TYPE_OF_PARSING = "button";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter(PARAMETER_FOR_TYPE_OF_PARSING);

        FlowerBuilderFactory factory = new FlowerBuilderFactory();
        AbstractFlowerBuilder builder = null;
        try {
            builder = factory.createFlowerBuilder(button.toUpperCase());
            builder.buildFlowerList("D:\\eclipse-workspace\\10-javast-2020-september\\task10 web\\src\\main\\\\resources\\data\\flowers.xml");
        } catch (ParserException | IncorrectInputException e) {
            logger.catching(e);
        }
        request.setAttribute("flowerList", builder.getFlowerSet());
        request.getRequestDispatcher("flowers.jsp").forward(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}


