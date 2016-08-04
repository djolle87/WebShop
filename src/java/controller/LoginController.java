package controller;

import javax.validation.Valid;
import model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin_login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "admin_login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("loginModel") @Valid LoginModel loginModel) {
        System.out.println("in submit" + loginModel);
        String username = loginModel.getUserName();
        String password = loginModel.getPassword();
        if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
            modelMap.put("userInfo", loginModel.getUserName());
            System.out.println(modelMap);
            return "Home";
        } else {
            modelMap.put("error", "Invalid UserName / Password");
            return "admin_login";
        }

    }

}
