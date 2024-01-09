package CRRW.MyPlushie.services;
//PlushieService.java (Service)

import CRRW.MyPlushie.models.User;
import CRRW.MyPlushie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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