package com.clive.model;

public class MenuItem {

    private String menuName;
    private String nameLink;

    public MenuItem(String menuName, String nameLink) {
        this.menuName = menuName;
        this.nameLink = nameLink;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getNameLink() {
        return nameLink;
    }

    public void setNameLink(String nameLink) {
        this.nameLink = nameLink;
    }
}
