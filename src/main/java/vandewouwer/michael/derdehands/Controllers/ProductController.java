package vandewouwer.michael.derdehands.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vandewouwer.michael.derdehands.Models.Product;
import vandewouwer.michael.derdehands.Models.ProductDAO;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    @ModelAttribute("productall")
    public Iterable<Product> toonProducten() {
        return dao.findAll();
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";


    }
    @RequestMapping(value = {"/about"},method = RequestMethod.GET)
    public String showAbout(){
        return "about";
    }

    @ModelAttribute("nProduct")
    public Product productToPost() {
        return new Product();
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String showNew() {
        return "new";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("nProduct") @Valid Product nProduct, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        dao.save(nProduct);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delBlog(@PathVariable(value = "id") int id) {
        dao.deleteById(id);
        return "redirect:/index";
    }
}
