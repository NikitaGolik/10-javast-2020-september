package by.golik.controller;

import by.golik.builder.*;
import by.golik.exception.IncorrectInputException;
import by.golik.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * @author Nikita Golik
 */
@WebServlet(name = "XMLParser", urlPatterns = "/parser")
public class XMLParser extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(XMLParser.class);

    private static final String PARAMETER_FOR_TYPE_OF_PARSING = "button";
    private static final String PARAMETER_FOR_PATH_TO_XML = "pathToXML";
    private static final String PARAMETER_FOR_PATH_TO_XSD = "pathToXSD";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get file name


        FlowerBuilderFactory factory = new FlowerBuilderFactory();
        AbstractFlowerBuilder builder = null;
        try {
            builder = factory.createFlowerBuilder("DOM");
            builder.buildFlowerList("D:\\eclipse-workspace\\10-javast-2020-september\\task10 web\\src\\main\\resources\\data\\flowers.xml");
        } catch (IncorrectInputException | ParserException e) {
            logger.catching(e);
        }

        request.setAttribute("flowerList", builder.getFlowerSet());
        request.getRequestDispatcher("/flowers.jsp").forward(request, response);
    }





}

