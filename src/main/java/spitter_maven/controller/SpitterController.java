package spitter_maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spitter_maven.dao.impl.SpitterDaoImpl;
import spitter_maven.entities.Spitter;
import spitter_maven.service.SpitterService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@Controller
public class SpitterController extends HttpServlet {

     @Autowired
    private SpitterService spitterService;

    @GetMapping("/splitter")
        public String  listSplitters(Model model) {
            // Fetch all splitter objects
            List<Spitter> spitters = spitterService.getAllSpitters();

            //add data to the model to pass to the view
            model.addAttribute("spitters", spitters);

            //return name of the view
            return "spitter";
       }
}