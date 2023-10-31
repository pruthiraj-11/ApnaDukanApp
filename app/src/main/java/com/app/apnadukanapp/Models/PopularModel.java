package com.app.apnadukanapp.Models;

import java.io.Serializable;

public class PopularModel implements Serializable {
    private String title;
    private String description;
    private String picURL;
    private int review;
    private double score;
    private int numberInCart;
    private double price;

    public PopularModel(String title, String description, String picURL, int review, double score, int numberInCart, double price) {
        this.title = title;
        this.description = description;
        this.picURL = picURL;
        this.review = review;
        this.score = score;
        this.numberInCart = numberInCart;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
