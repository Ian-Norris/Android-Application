package com.example.myapplication;

public class Posts {
    public String date;
    public String title;
    public double price;
    public String description;
    public String contact;
    public int imageResource;

    public Posts(String date, double price, String title, String description, String contact, int imageResource) {
        this.date = date;
        this.title = title;
        this.price = price;
        this.description = description;
        this.contact = contact;
        this.imageResource = imageResource;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
