package by.golik.task10web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;


/**
 * @author Nikita Golik
 */
//todo incorrect, need to find error
@WebServlet(name = "LoadServlet", urlPatterns = "/load")

public class LoadServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PARAMETER_FOR_FILE_CHOOSING = "description";
    private static final String PATH_TO_DOWNLOAD = "download";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * load file
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart(PARAMETER_FOR_FILE_CHOOSING);

        String fileName = getFileName(filePart);
        try {
            OutputStream out = new FileOutputStream(new File(PATH_TO_DOWNLOAD + File.separator + fileName));
            InputStream fileContent = filePart.getInputStream();

            int read;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException e) {
            LOGGER.catching(e);
        }
        request.getRequestDispatcher("/loadFile.jsp").forward(request, response);
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
