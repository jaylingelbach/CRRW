package CRRW.MyPlushie.controllers;
import CRRW.MyPlushie.models.Emblem;
import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.repositories.PlushieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plushies")
public class PlushieController {

    @Autowired
    private PlushieRepository plushieRepository;

    @GetMapping
    public String getAllPlushies(Model model) {
        List<Plushie> plushies = plushieRepository.findAll();
        model.addAttribute("plushies", plushies);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("emblem", Emblem.values());
        model.addAttribute("plushie", new Plushie());
        return "add";
    }

    @PostMapping("/add")
    public String addPlushie(@ModelAttribute Plushie plushie) {
        plushieRepository.save(plushie);
        return "redirect:/plushies";
    }
}