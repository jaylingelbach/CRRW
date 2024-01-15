package CRRW.MyPlushie.controllers;

import CRRW.MyPlushie.models.Plushie;
import CRRW.MyPlushie.models.PlushieData;
import CRRW.MyPlushie.repositories.PlushieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;


@Controller
@RequestMapping("sortBy")
public class SortByController {
    @Autowired
    private PlushieRepository plushieRepository;

    static HashMap<String, String> plushieChoices = new HashMap<>();
    public SortByController () {
        plushieChoices.put("all", "All");
        plushieChoices.put("name", "Name");
        plushieChoices.put("emblem", "Emblem");

    }


    @RequestMapping("")
    public String sortBy(Model model) {
        model.addAttribute("plushies", plushieChoices);
        return "sortBy";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String sortByType, @RequestParam String sortByTerm){
        Iterable<Plushie> plushies;
        if (sortByTerm.toLowerCase().equals("all") || sortByTerm.equals("")){
            plushies = plushieRepository.findAll();
        } else {
            plushies = PlushieData.findByColumnAndValue(sortByType, sortByTerm, plushieRepository.findAll());
        }
        model.addAttribute("plushies", plushieChoices);
        model.addAttribute("Hi", "Plushies with " + plushieChoices.get(sortByTerm) + ": " + sortByTerm);
        model.addAttribute("plushies", plushies);

        return "sortBy";
    }

}

/*static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("skill", "Skill");

    }


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Job> jobs;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            jobs = jobRepository.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("jobs", jobs);

        return "search";
    } }*/
