package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "info-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "info-user";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
