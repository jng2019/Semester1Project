package com.example.semester1project;

public class Card {
    private String name;
    private int value;
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


    public String getName() {
        return name;
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
                "name ='" + name + '\'' +
                ", suit ='" + suit + '\'' +
                ", value ='" + value + '\'' +
                '}';
    }
}
