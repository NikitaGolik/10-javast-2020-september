package by.golik.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.apache.logging.log4j.LogManager.*;

/**
 * @author Nikita Golik
 */
@WebServlet(name = "ReadFromFileServlet", urlPatterns = "/read")


public class ReadFromFileServlet extends HttpServlet {

    private static final Logger LOGGER = getLogger();
    private static final String PARAMETER_FOR_PATH_TO_DATA = "path";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        char var = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(getClass().getClassLoader()
                    .getResource(request.getParameter(PARAMETER_FOR_PATH_TO_DATA)).getFile()));
            try {
                var = (char) fileInputStream.read();
            } catch (IOException e) {
                LOGGER.catching(e);
            }
        } catch (FileNotFoundException e) {
            LOGGER.catching(e);
        }
        LOGGER.log(Level.INFO, "- Data is successfully read.");

        String localValue = request.getParameter("local");
        request.setAttribute("localValue", localValue);
        request.setAttribute("res", var);
        request.getRequestDispatcher("resultOfReading.jsp").forward(request, response);
    }
}
