package com.sortiz.datajpa.app.springdatajpa.app.model.entity;

public enum Group {
    AVENGERS(1, "Avengers"),
    XMEN(2, "X-Men");

    private Integer id;
    private String desc;

    Group(){

    }
    Group(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Group getGroup(Integer group){
        if (group == 1) {
            return AVENGERS;
        } else {
            return XMEN;
        }
    }

    public String getGroupName(Integer group) {

        if (1 == group) {

            return AVENGERS.desc;

        } else  {

            return XMEN.desc;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
