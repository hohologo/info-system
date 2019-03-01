package com.clive.controller;

import com.clive.model.Major;
import com.clive.model.UserData;
import com.clive.service.AdminService;
import com.clive.support.AdminValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminValidator validator;

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        List<UserData> users = adminService.getUserList();
        model.addAttribute("allUsers", users);

        return "admin/allUsers";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {

        model.addAttribute("userData", new UserData());
        appendOtherInfo(model, null);

        return "admin/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @Valid @ModelAttribute("userData") UserData userData, BindingResult bindingResult){
        validator.validateUserId(bindingResult, userData.getUserId());

        if(bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            appendOtherInfo(model, userData.getDepartment() == null ? null:userData.getDepartment().getDeptId());

            return "admin/addUser";
        }

        adminService.addUser(userData);

        return "redirect:/admin/users";

    }

    @ResponseBody
    @GetMapping(value = "/department/{deptId}/majors", produces = "application/json")
    public List<Major> getMajors(@PathVariable Integer deptId) {
        return adminService.getMajorListByDeptId(deptId);
    }

    @GetMapping("/updateUser/{userId}")
    public String showUserInfo(Model model, @PathVariable String userId){
        UserData userData = adminService.getUserDataByUserId(userId);
        model.addAttribute("userData", userData);
        appendOtherInfo(model, userData.getDepartment() == null ? null:userData.getDepartment().getDeptId());

        return "/admin/updateUser";
    }

    @PostMapping("/updateUser/{userId}")
    public String updateUserInfo(Model model, @Valid @PathVariable String userId, @ModelAttribute("userData") UserData userData,BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            appendOtherInfo(model, userData.getDepartment() == null ? null : userData.getDepartment().getDeptId());

            return "admin/updateUser";
        }

        adminService.updateUser(userData, userId);

        return "redirect:/admin/users";

    }

    @GetMapping("/deleteUser/{userId}")
    public String deleteUserInfo(Model model, @PathVariable String userId) {

        adminService.deleteUserDataByUserId(userId);

        return "redirect:/admin/users";
    }

    public void appendOtherInfo(Model model, Integer deptId) {

        model.addAttribute("genders", adminService.getGenders());
        model.addAttribute("departments", adminService.getDepartmentList());
        model.addAttribute("majors", adminService.getMajorListByDeptId(deptId));
        model.addAttribute("roles", adminService.getRoleList());

    }

}
