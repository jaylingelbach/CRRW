package CRRW.MyPlushie.controllers;
import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.services.PlushieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plushies")
public class PlushieController {


    @Autowired
    private List<Plushie> plushies = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Plushie>> getAllPlushies() {
        return new ResponseEntity<>(plushies, HttpStatus.OK);
    }

    // Create a new plushie
    @PostMapping
    public ResponseEntity<Plushie> createPlushie(@RequestBody Plushie plushie) {

//        DONE: removed generateId method call, no need for this when plushies already make their own ids
        plushies.add(plushie);
        return new ResponseEntity<>(plushie, HttpStatus.CREATED);
    }

    // Update a plushie by ID
    @PutMapping("/{id}")  // {id} refers to the ID that we want to change. if my plushie has an id of 25, then the mapping
                          //is going to "/plushies/25", "/plushies" comes from the fact that this is like a branch off
                          // from "/plushies" on line 16

    public ResponseEntity<Plushie> updatePlushie(@PathVariable Long id, @RequestBody Plushie updatedPlushie) {
        Plushie existingPlushie = findPlushieById(id);
        if (existingPlushie != null) {
            existingPlushie.setName(updatedPlushie.getName());
            return new ResponseEntity<>(existingPlushie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a plushie by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlushie(@PathVariable Long id) {
        Plushie plushieToRemove = findPlushieById(id);
        if (plushieToRemove != null) {
            plushies.remove(plushieToRemove);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Get all plushies sorted alphabetically by name
    @GetMapping("/alphabetical")
    public ResponseEntity<List<Plushie>> getAllPlushiesAlphabetical() {
        List<Plushie> sortedPlushies = plushies.stream()
                .sorted(Comparator.comparing(Plushie::getName))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortedPlushies, HttpStatus.OK);
    }

    // Get all plushies sorted by date adopted
    @GetMapping("/date-adopted")
    public ResponseEntity<List<Plushie>> getAllPlushiesByDateAdopted() {
        List<Plushie> sortedPlushies = plushies.stream()
                .sorted(Comparator.comparing(Plushie::getDateAdopted))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortedPlushies, HttpStatus.OK);
    }

    // Get all plushies sorted by emblem
    @GetMapping("/by-emblem")
    public ResponseEntity<List<Plushie>> getAllPlushiesByEmblem() {
        List<Plushie> sortedPlushies = plushies.stream()
                .sorted(Comparator.comparing(Plushie::getEmblem))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortedPlushies, HttpStatus.OK);
    }


    @Autowired
    private PlushieService plushieService;

    @GetMapping("/sorted/alphabetically")
    public List<Plushie> getPlushiesSortedAlphabetically() {

        return plushieService.getPlushiesSortedAlphabetically();
    }

    @GetMapping("/sorted/bydateadopted")
    public List<Plushie> getPlushieSortedByDateAdopted() {
        return plushieService.getPlushiesSortedByDateAdopted();
    }

    @GetMapping("/sorted/byemblem")
    public List<Plushie> getPlushiesSortedByEmblem() {
        return plushieService.getPlushiesSortedByEmblem();
    }


    //method that finds a plushie by Id
    private Plushie findPlushieById(Long id) {
        //this actually is using the dedicated get plushie by id. no need to make another method that does the same thing
        // in this file when we can just call
        return plushieService.getPlushieById(id).orElse(null);
    }
}