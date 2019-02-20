package com.clive.controller;

import com.clive.model.Major;
import com.clive.model.UserData;
import com.clive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        List<UserData> users = adminService.getUserList();
        model.addAttribute("allUsers", users);

        return "allUsers";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {

        model.addAttribute("userData", new UserData());
        appendOtherInfo(model);

        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @Valid @ModelAttribute("userData") UserData userData, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            appendOtherInfo(model);
        }

        adminService.addUser(userData);

        return "redirect:/admin/users";

    }

    public void appendOtherInfo(Model model) {

        model.addAttribute("genders", adminService.getGenders());
        model.addAttribute("departments", adminService.getDepartmentList());
        model.addAttribute("majors", new ArrayList<Major>());
        model.addAttribute("roles", adminService.getRoleList());

    }

    @ResponseBody
    @GetMapping(value = "/department/{deptId}/majors", produces = "application/json")
    public List<Major> getMajors(@PathVariable Integer deptId) {
        return adminService.getMajorListByDeptId(deptId);
    }

    @GetMapping("/updateUser/{userId}")
    public String showUserInfo(Model model, @PathVariable String userId){

        model.addAttribute("userData", adminService.getUserByUserId(userId));
        appendOtherInfo(model);

        return "updateUser";
    }

    @PostMapping("/updateUser/{userId}")
    public String updateUserInfo(Model model, @Valid @PathVariable String userId, @ModelAttribute("userData") UserData userData){

        adminService.updateUser(userData);

        return "redirect:/admin/users";

    }

    @GetMapping("/deleteUser/{userId}")
    public String deleteUserInfo(Model model, @PathVariable Integer userId) {

        adminService.deleteUser(userId);

        return "redirect:/admin/users";
    }

}
