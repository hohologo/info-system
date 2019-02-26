package com.clive.model;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class User implements UserDetails {

    private String username;
    private String password;
    private String rolename;

    public User() {
    }

    public User(String username, String password, String rolename) {
        this.username = username;
        this.password = password;
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return asList(new SimpleGrantedAuthority(rolename));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        return rolename.equals("Administrator");
    }

    public boolean isTeacher() {
        return rolename.equals("Teacher");
    }

    public boolean isStudent() {
        return rolename.equals("student");
    }

    public String name(String s, String s2) {
        return s+s2;
    }
}
