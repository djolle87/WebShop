package controller;

import java.sql.SQLException;
import model.Product;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/user_managment", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("user", new User());
        model.addAttribute("users", User.allUsers());
        return "user_managment";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String createIndex(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.allProducts());
        return "index";
    }
    
            @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String createFormSuccess(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.allProducts());
        return "success";
    }
    
      @RequestMapping(value = "/shopping", method = RequestMethod.GET)
    public String createIndex2(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.allProducts());
        return "shopping";
    }

    @RequestMapping(value = "/user_managment", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, ModelMap model) throws ClassNotFoundException {
        user.addUser();
        createForm(model);
        return "user_managment";
    }
    
    @RequestMapping(value = "/user_delete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("user") User user, ModelMap model) throws ClassNotFoundException {

        model.addAttribute("id", user.getId());
        user.deleteUser();
        createForm(model);
        return "user_managment";
    }

    @RequestMapping(value = "/user_edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user, ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("id",user.getId());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        user.editUser();
        createForm(model);
        return "user_managment";
    }
}
