package CRRW.MyPlushie.controllers;
import CRRW.MyPlushie.models.Emblem;
import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.repositories.PlushieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Base64;
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
    public String addPlushie(@ModelAttribute Plushie plushie/*, @RequestParam ("photo") MultipartFile photoFile,Model model*/)
        {
            /* Convert MultipartFile to String using the FileConverter
            String base64EncodedPhoto = photoFile.convertMultipartFileToString(photoFile);

            // Set the photo field in the Plushie object
            plushie.setPhoto(base64EncodedPhoto);

            // Convert MultipartFile to byte[]
            try {
                String photoBytes = photoFile.getPhoto();
                plushie.setPhoto(photoBytes);
                plushieRepository.save(plushie);
            } catch (IOException e) {
                // Handle the exception (e.g., log it, show an error message)
                e.printStackTrace();
            }*/

            // Convert MultipartFile to byte[]


            //plushie.setPhoto(photoFile.getOriginalFilename());
            System.out.println("Before saving plushie");
            plushieRepository.save(plushie);
//            System.out.println(plushie.getPurchaseLink());
//            System.out.println(photoFile.getContentType());
//            System.out.println(photoFile.getOriginalFilename());
//            System.out.println(photoFile.getResource());

            // plushieRepository.save(plushie);
        //return "list";

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
    // Handle edit form submission and return to plushie list
    @PostMapping("/edit/{id}")
    public String updatePlushie(@PathVariable Long id, @ModelAttribute Plushie updatedPlushie,Model model) {
        Optional<Plushie> optionalPlushie = plushieRepository.findById(id);
        //if (optionalPlushie.isPresent()) {
            Plushie existingPlushie = optionalPlushie.get();
            existingPlushie.setName(updatedPlushie.getName());
            existingPlushie.setEmblem(updatedPlushie.getEmblem());
            existingPlushie.setDescription(updatedPlushie.getDescription());
            existingPlushie.setDateAdopted(updatedPlushie.getDateAdopted());
            existingPlushie.setPhoto(updatedPlushie.getPhoto());
            existingPlushie.setZipcode(updatedPlushie.getZipcode());
            existingPlushie.setPurchaseLink(updatedPlushie.getPurchaseLink());
            plushieRepository.save(existingPlushie);
            //model.addAttribute("emblem", Emblem.values());
            //model.addAttribute("plushie",existingPlushie);
            return "redirect:/plushies";
        // }
        //else {
        //    return "notFound";
        //}
    }

    // Handle delete operation
    @GetMapping("/delete/{id}")
    public String deletePlushie(@PathVariable Long id) {
        Optional<Plushie> plushieOptional = plushieRepository.findById(id);

        if (plushieOptional.isPresent()) {
            Plushie plushieToDelete = plushieOptional.get();

            // Delete the plushie from the repository
            plushieRepository.delete(plushieToDelete);
        }

        return "redirect:/plushies";
    }

}