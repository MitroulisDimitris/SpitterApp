package org.spitterwebapp.spitterspringbootapp.controller;

import org.spitterwebapp.spitterspringbootapp.entities.Spitter;
import org.spitterwebapp.spitterspringbootapp.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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