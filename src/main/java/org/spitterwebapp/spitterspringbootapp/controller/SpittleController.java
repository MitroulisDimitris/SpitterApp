package org.spitterwebapp.spitterspringbootapp.controller;


import jakarta.servlet.http.HttpServlet;
import org.spitterwebapp.spitterspringbootapp.entities.Spitter;
import org.spitterwebapp.spitterspringbootapp.entities.Spittle;
import org.spitterwebapp.spitterspringbootapp.service.SpitterService;
import org.spitterwebapp.spitterspringbootapp.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class SpittleController extends HttpServlet {

    @Autowired
    private SpittleService splittleService;
    @Autowired
    private SpitterService spitterService;



    @GetMapping("/spittles")
    public String listSpittles(@RequestParam(value = "authorId", required = false) Integer authorId, Model model) {
        if (authorId != null) {
            Spitter spitter = spitterService.findById(authorId);
            List<Spittle> spittles = splittleService.findSpittlesBySpitter(spitter);
            model.addAttribute("spittles", spittles);
        }
        return "spittles";
    }
}