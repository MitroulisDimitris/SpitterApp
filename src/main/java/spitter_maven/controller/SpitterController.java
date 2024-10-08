package spitter_maven.controller;

import spitter_maven.dao.impl.SpitterDaoImpl;
import spitter_maven.entities.Spitter;
import spitter_maven.service.SpitterService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/spitter")
public class SpitterController extends HttpServlet {

        private SpitterDaoImpl spitterDaoImpl = new SpitterDaoImpl();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // Fetch all Spitter objects
            List<Spitter> spitters = spitterDaoImpl.findAll();

            request.setAttribute("spitters", spitters);
            request.setAttribute("test", "testing complete");

            // Forward to the JSP page
            request.getRequestDispatcher("/WEB-INF/views/spitter.jsp").forward(request, response);

            //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/spitter.jsp");
            //dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}