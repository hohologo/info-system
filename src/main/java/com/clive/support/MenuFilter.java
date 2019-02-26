package com.clive.support;


import com.clive.model.MenuItem;
import com.clive.model.User;
import com.clive.service.MenuService;
import com.clive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MenuFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        User user = userService.getCurrentUser();

        if (user != null) {

            httpServletRequest.setAttribute("menuItems", menuService.getMenuItem(user));
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
