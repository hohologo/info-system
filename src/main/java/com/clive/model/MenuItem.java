package com.clive.model;

public class MenuItem {

    private String menuName;
    private String linkName;

    public MenuItem(String menuName, String nameLink) {
        this.menuName = menuName;
        this.linkName = nameLink;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
