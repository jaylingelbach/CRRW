package CRRW.MyPlushie.services;



import CRRW.MyPlushie.models.Plushie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CRRW.MyPlushie.repositories.PlushieRepository;

import java.util.*;
@Service
public class PlushieService {
    @Autowired
    private PlushieRepository plushieRepository;

    public List<Plushie> getAllPlushies() {
        return plushieRepository.findAll();
    }

    public Optional<Plushie> getPlushieById(Long id) {
        return plushieRepository.findById(id);
    }

    public Plushie createPlushie(Plushie plushie) {
        return plushieRepository.save(plushie);
    }

    public void updatePlushie(Long id, Plushie updatedPlushie) {
        Plushie plushie = plushieRepository.findById(id).orElseThrow(() -> new RuntimeException("Plushie not found"));
        plushie.setName(updatedPlushie.getName());
        plushie.setDescription(updatedPlushie.getDescription());
        plushieRepository.save(plushie);
    }

    public void deletePlushie(Long id) {
        plushieRepository.deleteById(id);
    }

    //TODO: in PlushieRepository.java, add the following methods: findAllByOrderByName, findAllByOrderByDateAdopted,
    // and findAllByOrderByEmblem that are referenced here but don't exist yet.
    public List<Plushie> getPlushiesSortedAlphabetically() {
        return plushieRepository.findAllByOrderByName();
    }

    public List<Plushie> getPlushiesSortedByDateAdopted() {
        // Assuming you have a 'dateAdopted' property in your Plushie entity
        return plushieRepository.findAllByOrderByDateAdopted();
    }

    public List<Plushie> getPlushiesSortedByEmblem() {
        // Assuming you have an 'emblem' property in your Plushie entity
        return plushieRepository.findAllByOrderByEmblem();
    }
}