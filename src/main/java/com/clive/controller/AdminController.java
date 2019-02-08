package com.clive.controller;

import com.clive.model.User;
import com.clive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public String getAllUsers(Model model){

        List<User> users = adminService.getUserList();

        model.addAttribute("allUsers", users);

        return "allUsers";
    }

}
