package CRRW.MyPlushie.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import CRRW.MyPlushie.services.UserService;

@Controller
@RequestMapping("/plushies")
public class PlushieController {

    @Autowired
    private PlushieService plushieService;

    // Mapping for the list view
    @GetMapping("/list")
    public String listPlushies(Model model) {
        List<Plushie> plushies = plushieService.getAllPlushies();
        model.addAttribute("plushies", plushies);
        return "plushie/list";
    }

    // Mapping for the form to add a new plushie
    @GetMapping("/add")
    public String showAddPlushieForm(Model model) {
        model.addAttribute("plushie", new Plushie());
        return "plushie/add";
    }

    // Mapping to process the form submission
    @PostMapping("/add")
    public String addPlushie(Plushie plushie) {
        plushieService.addPlushie(plushie);
        return "redirect:/plushies/list";
    }
}

