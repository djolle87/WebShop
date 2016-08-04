package controller;

import java.sql.SQLException;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(value = "/product_managment", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.allProducts());
        return "product_managment";
    }

    @RequestMapping(value = "/buy_product", method = RequestMethod.GET)
    public String createFormPr(ModelMap model) throws ClassNotFoundException {

        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.allProducts());
        return "buy_product";
    }

    @RequestMapping(value = "/product_managment", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, ModelMap model) throws ClassNotFoundException {
        product.addProduct();
        createForm(model);
        return "product_managment";
    }

    @RequestMapping(value = "/product_delete", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute("product") Product product, ModelMap model) throws ClassNotFoundException {

        model.addAttribute("id", product.getId());
        product.deleteProduct();
        createForm(model);
        return "product_managment";
    }

    @RequestMapping(value = "/product_edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product, ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("id", product.getId());
        model.addAttribute("name", product.getName());
        model.addAttribute("brand", product.getBrand());
        model.addAttribute("model", product.getModel());
        model.addAttribute("price", product.getPrice());
        model.addAttribute("quantity", product.getQuantity());
        product.editProduct();
        createForm(model);
        return "product_managment";
    }

    @RequestMapping(value = "/buy_product", method = RequestMethod.POST)
    public String buyProduct(@ModelAttribute("product") Product product, ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("id", product.getId());
        model.addAttribute("quantity", product.getQuantity());
        if (product.buyProduct()) {
            createForm(model);
            return "success";
        } else {
            return "fail";
        }
    }

}
