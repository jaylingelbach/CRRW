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
    private PlushieService plushieService;

    @GetMapping("/list")
    public String listPlushies(Model model) {
        List<Plushie> plushies = plushieService.getAllPlushies();
        model.addAttribute("plushies", plushies);
        return "plushie/list";
    }

    @GetMapping("/add")
    public String showAddPlushieForm(Model model) {
        model.addAttribute("plushie", new Plushie());
        return "plushie/add";
    }

    @PostMapping("/add")
    public String addPlushie(@ModelAttribute("plushie") Plushie plushie) {
        plushieService.addPlushie(plushie);
        return "redirect:/plushies/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditPlushieForm(@PathVariable("id") Long id, Model model) {
        Optional<Plushie> plushie = plushieService.getPlushieById(id);
        plushie.ifPresent(value -> model.addAttribute("plushie", value));
        return "plushie/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPlushie(@PathVariable("id") Long id, @ModelAttribute("plushie") Plushie updatedPlushie) {
        plushieService.updatePlushie(id, updatedPlushie);
        return "redirect:/plushies/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePlushie(@PathVariable("id") Long id) {
        plushieService.deletePlushie(id);
        return "redirect:/plushies/list";
    }
}
