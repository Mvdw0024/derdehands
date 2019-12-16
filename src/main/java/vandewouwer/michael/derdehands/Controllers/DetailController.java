package vandewouwer.michael.derdehands.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;
import vandewouwer.michael.derdehands.Models.ProductDAO;

@Controller
public class DetailController {

    @Autowired
    ProductDAO dao;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showDetails(ModelMap map, @PathVariable(name = "id") int id) {
        if (dao.findById(id).isPresent()) {
            map.addAttribute("product", dao.findById(id).get());
            return "details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dat es hie ni just he, VRIEND ! Kom, probeert ne keer oppernief... ");
        }


    }
}
