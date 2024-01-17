package CRRW.MyPlushie.controllers;

import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.models.PlushieData;
import CRRW.MyPlushie.repositories.PlushieRepository;
import CRRW.MyPlushie.repositories.UserRepository;
import CRRW.MyPlushie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlushieRepository plushieRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();
    public SearchController() {
        columnChoices.put("all", "All");
        columnChoices.put("name", "Name");
        columnChoices.put("emblem", "Emblem");

    }


    @RequestMapping("")
    public String search(Model model) {
        //model.addAttribute("username", user);
        model.addAttribute("columns", columnChoices);
        return "/search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Plushie> plushies;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            plushies = plushieRepository.findAll();
        } else {
            plushies = PlushieData.findByColumnAndValue(searchType, searchTerm, plushieRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("Hi", "Plushies with " + columnChoices.get(searchTerm) + ": " + searchTerm);
        model.addAttribute("plushies", plushies);

        return "search";
    }

}

