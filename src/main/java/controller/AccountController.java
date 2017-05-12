package controller;

import form.UserLoginForm;
import form.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.validation.Valid;

/**
 * Created by Andrey on 23.04.2017.
 */
@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String getRegister(Model model){
        model.addAttribute("userform", new UserRegistrationForm());
        return "security/register_form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String register(@ModelAttribute("userform") @Valid UserRegistrationForm form, BindingResult res){
        if(!res.hasErrors()){
            userService.saveNewUser(form);
            return "redirect:/";
        }else {
            //TODO: Обработка неправильного ввода
            return "redirect:/register";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String getLoginForm(@RequestParam(value = "error", required = false) Boolean error, Model model){
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("userform", new UserLoginForm());
        return "security/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String login(@ModelAttribute("userform") UserLoginForm form){
        return "";
    }
}
