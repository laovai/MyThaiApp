package com.example.daria.mythaiapp.server;

import java.util.Date;

/**
 * Created by daria on 26.11.16.
 */

public class Dog {

    int id;
    Date date;
    //как хранить фото? а похуй, пока никак
    boolean sex;
    Colour colour;
    CoatType coatType;
    PriceCategory category;
    String text;

    public Dog() {
    }

    public Dog(int id, Date date, boolean sex, Colour colour, CoatType coatType, PriceCategory category, String text) {
        this.id = id;
        this.date = date;
        this.sex = sex;
        this.colour = colour;
        this.coatType = coatType;
        this.category = category;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public CoatType getCoatType() {
        return coatType;
    }

    public void setCoatType(CoatType coatType) {
        this.coatType = coatType;
    }

    public PriceCategory getCategory() {
        return category;
    }

    public void setCategory(PriceCategory category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (id != dog.id) return false;
        if (sex != dog.sex) return false;
        if (!date.equals(dog.date)) return false;
        if (colour != dog.colour) return false;
        if (coatType != dog.coatType) return false;
        if (category != dog.category) return false;
        return text != null ? text.equals(dog.text) : dog.text == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + (sex ? 1 : 0);
        result = 31 * result + colour.hashCode();
        result = 31 * result + coatType.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
