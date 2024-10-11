package spitter_maven.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spitter_maven.entities.Spitter;
import spitter_maven.entities.Spittle;
import spitter_maven.service.SpittleService;


import javax.servlet.http.HttpServlet;
import java.util.List;


@Controller
public class SpittleController extends HttpServlet {

    @Autowired
    private SpittleService splittleService;


    @GetMapping("/spittles")
    public String listSpittles(@RequestParam(value = "authorId", required = false) Integer authorId, Model model) {
        if (authorId != null) {
            List<Spittle> spittles = splittleService.findSpittlesByAuthorId(authorId);
            model.addAttribute("spittles", spittles);


        }
        return "spittles";
    }
}