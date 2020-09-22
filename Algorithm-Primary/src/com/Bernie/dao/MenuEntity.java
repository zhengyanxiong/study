package com.Bernie.dao;

import java.util.List;

/**
 * @Author Bernie
 * @Date 2020/4/21 21:34
 */
public class MenuEntity {
    private int id;
    private String name;
    private int parentID;
    private String parentName;
    private List<MenuEntity> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<MenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEntity> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", parentID:" + parentID +
                ", parentName:'" + parentName + '\'' +
                ", children:" + children +
                '}';
    }
}
