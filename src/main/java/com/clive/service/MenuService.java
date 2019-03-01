package com.clive.service;


import com.clive.model.MenuItem;
import com.clive.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    public List<MenuItem> getMenuItem(User user) {

        List<MenuItem> menuItems = new ArrayList<>();

        if (user.isAdmin()) {
            menuItems.add(new MenuItem("Show All Users", "/admin/users"));
            menuItems.add(new MenuItem("Add User", "/admin/addUser"));
        }

        if (user.isTeacher()) {
            menuItems.add(new MenuItem("Show All Courses", "/teacher/courses"));
            menuItems.add(new MenuItem("Add New Course", "/teacher/course"));
        }

        if (user.isStudent()) {
            menuItems.add(new MenuItem("Register Course", "/student/registerCourse"));
            menuItems.add(new MenuItem("Show Current Courses", "/student/courses"));
        }
        return menuItems;
    }
}
