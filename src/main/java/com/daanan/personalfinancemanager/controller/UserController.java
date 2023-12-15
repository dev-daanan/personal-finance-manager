package com.daanan.personalfinancemanager.controller;

import com.daanan.personalfinancemanager.dto.UserDto;
import com.daanan.personalfinancemanager.model.Category;
import com.daanan.personalfinancemanager.model.User;
import com.daanan.personalfinancemanager.service.CategoryService;
import com.daanan.personalfinancemanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    private CategoryService categoryService;

    @Autowired
    public UserController(UserService userService, CategoryService categoryService) {

        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            // If there are validation errors, return to the registration form
            return "register";
        }

        try {
            userService.registerNewUser(userDto);
        } catch (Exception e) {
            // Handle any exceptions, such as a username already in use
            model.addAttribute("registrationError", e.getMessage());
            return "register";
        }

        // Redirect to a success page or login page after successful registration
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm( ) {

        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        String username = principal.getName(); // Get the logged-in username
        User user = userService.findByUsername(username); // Retrieve user details

        // Assuming you have a method to get categories by user
        List<Category> categories = categoryService.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("categories", categories);
        return "home";
    }

    // add an initBinder ... to convert trim input strings
    // remove leading and trailing whitespaces
    // resolve issue for our #validation#
    // called for EVERY web request coming into this controller
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
