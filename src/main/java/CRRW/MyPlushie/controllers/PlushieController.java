// PlushieController.java (Controller)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plushies")
public class PlushieController {
    @Autowired
   private PlushieService plushieService;

     //Existing methods...

    @GetMapping("/sorted/alphabetically")
    public List<Plushie> getPlushiesSortedAlphabetically() {
        return plushieService.getPlushiesSortedAlphabetically();
    }

    @GetMapping("/sorted/bydateadopted")
    public List<Plushie> getPlushiesSortedByDateAdopted() {
        //return plushieService.getPlushiesSortedByDateAdopted();
    }

    @GetMapping("/sorted/byemblem")
    public List<Plushie> getPlushiesSortedByEmblem() {
        //return plushieService.getPlushiesSortedByEmblem();
    }
}