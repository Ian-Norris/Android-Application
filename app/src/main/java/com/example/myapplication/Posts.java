package com.example.myapplication;

public class Posts {
    private String title;
    private double price;
    private String description;
    private String contact;

    public Posts(){

    }

    public Posts(String title, double price, String description, String contact) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
