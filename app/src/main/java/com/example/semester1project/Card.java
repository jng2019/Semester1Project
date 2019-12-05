package com.example.semester1project;

import static java.lang.Integer.parseInt;

public class Card {
    private int value;
    private String letter;
    private String suit;
    private String image;

    public Card(){

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumber() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return
                "suit ='" + suit + '\'' +
                ", value ='" + value + '\'' +
                '}';
    }
}
