package spitter_maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spitter_maven.entities.Spitter;
import spitter_maven.service.SpitterService;


import java.util.List;

@Controller
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @GetMapping("/spitter")
    public String  listSpitters(Model model) {
        // Fetch all splitter objects
        List<Spitter> spitters = spitterService.findAll();

        //add data to the model to pass to the view
        model.addAttribute("spitters", spitters);

        //return name of the view
        return "spitter";
   }
}