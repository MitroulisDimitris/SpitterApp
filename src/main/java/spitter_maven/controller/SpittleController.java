package spitter_maven.controller;


import spitter_maven.dao.impl.SpitterDaoImpl;
import spitter_maven.dao.impl.SpittleDaoImpl;
import spitter_maven.entities.Spitter;
import spitter_maven.entities.Spittle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/spittles")
public class SpittleController extends HttpServlet {

    private SpittleDaoImpl spittleDaoImpl = new SpittleDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract the userId from the request parameter
        //String userId = request.getParameter("id");
        String userId = request.getParameter("authorId");
        System.out.println(userId);

        if (userId != null && !userId.isEmpty()) {
            int authorId = Integer.parseInt(userId);

            // Fetch the list of spittles for the given authorId from the database
            List<Spittle> spittles =  spittleDaoImpl.findByAuthorId(authorId);

            // Set the spittles in the request so that JSP can access them
            request.setAttribute("spittles", spittles);
        }

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/spittles.jsp");
        dispatcher.forward(request, response);
    }
}