package com.example.semester1project;

import android.os.Parcelable;

import static java.lang.Integer.parseInt;

public class Card{
    private int value;
    private String letter;
    private String suit;
    private String image;

    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
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
