package spitter_maven;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    // Handles GET requests (e.g., when user loads a page)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Processing logic here
        String message = "Hello, this is your Main Servlet!";

        // Set an attribute to be accessed in the JSP page
        request.setAttribute("message", message);

        // Forward to JSP page for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(request, response);
    }

    // Handles POST requests (e.g., form submissions)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
