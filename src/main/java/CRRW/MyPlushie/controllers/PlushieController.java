package CRRW.MyPlushie.controllers;
import CRRW.MyPlushie.models.Emblem;
import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.repositories.PlushieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plushies")
public class PlushieController {

    @Autowired
    private PlushieRepository plushieRepository;

    //list the Plushie
    @GetMapping
    public String getAllPlushies(Model model) {
        List<Plushie> plushies = plushieRepository.findAll();
        model.addAttribute("plushies", plushies);
        return "list";
    }
    //Adding the Plushie
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
    // Editing the Plushie
    @GetMapping("/edit/{id}")
    public String editPlushie(@PathVariable Long id, Model model) {
        Optional<Plushie> plushie = plushieRepository.findById(id);

        if (plushie.isPresent()) {
            model.addAttribute("emblem", Emblem.values());
            model.addAttribute("plushie", plushie.orElse(null));
            return "edit";
        } else {
            // Handle plushie not found
            return "redirect:/plushies";
        }
    }

    /*@PostMapping("/edit/{id}")
    public String updatePlushie(@ModelAttribute Plushie updatedPlushie) {
        // Perform update logic using the repository
        plushieRepository.save(updatedPlushie);
        return "list";
    }*/

    /*@GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Plushie> optionalPlushie = plushieRepository.findById(id);
        optionalPlushie.ifPresent(plushie -> model.addAttribute("plushie", plushie));
        return optionalPlushie.map(plushie-> "editPlushie").orElse("notFound");
    }*/

    @PostMapping("/edit/{id}")
    public String editPlushie(@PathVariable Long id, @ModelAttribute Plushie updatedPlushie) {
        Optional<Plushie> optionalPlushie = plushieRepository.findById(id);
        if (optionalPlushie.isPresent()) {
            Plushie existingPlushie = optionalPlushie.get();
            existingPlushie.setName(updatedPlushie.getName());
            existingPlushie.setEmblem(updatedPlushie.getEmblem());
            existingPlushie.setDescription(updatedPlushie.getDescription());
            existingPlushie.setDateAdopted(updatedPlushie.getDateAdopted());
            existingPlushie.setPhoto(updatedPlushie.getPhoto());
            existingPlushie.setZipcode(updatedPlushie.getZipcode());

            plushieRepository.save(existingPlushie);
            return "redirect:/plushies";
        } else {
            return "notFound";
        }
    }

    // Handle delete operation
    @GetMapping("/{id}/delete")
    public String deletePlushie(@PathVariable Long id) {
        Optional<Plushie> plushieOptional = plushieRepository.findById(id);

        if (plushieOptional.isPresent()) {
            Plushie plushieToDelete = plushieOptional.get();

            // Delete the plushie from the repository
            plushieRepository.delete(plushieToDelete);
        }

        return "redirect:/plushies";
    }
    /*@GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/items";
    }
}*/
}