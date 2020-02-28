package pl.kolban.SpringCarRental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kolban.SpringCarRental.model.LoginForm;

@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String getHome(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model){

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        System.out.println(username + " password to:: " + password);

        if("admin".equals(username) && "admin".equals(password)){
            return "home";
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

}
