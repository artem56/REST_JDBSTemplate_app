package com.example.application_dev.Entity;

public class DeviceEntity {
    public long id;
    private String name, img;
    private int price, rating;
    public DeviceEntity() {

    }
    public DeviceEntity(long id, String name, String img, int price, int rating) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


