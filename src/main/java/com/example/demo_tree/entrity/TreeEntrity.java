package com.example.demo_tree.entrity;

import java.util.ArrayList;
import java.util.List;

public class TreeEntrity {
    private int id;
    private int pid;
    private String name;
    private List<TreeEntrity> children=new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeEntrity> getChildren() {
        return children;
    }

    public void setChildren(List<TreeEntrity> children) {
        this.children = children;
    }
}
