package com.zl.bean;

public class Customer {
    private Integer id;
    private String name;
    private String desc;
    private String contact;

    public Customer(){

    }
    public int getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
}
