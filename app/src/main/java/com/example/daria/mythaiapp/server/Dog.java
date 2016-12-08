package com.example.daria.mythaiapp.server;

import java.util.Date;

/**
 * Created by daria on 26.11.16.
 */

public class Dog {

    int id;
    String date;
    //как хранить фото? а похуй, пока никак
    int sex;
    String colour;
    String coatType;
    String category;
    String text;

    public Dog() {
    }

    public Dog(int id, String date, int sex, String colour, String coatType, String category, String text) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCoatType() { return coatType; }

    public void setCoatType(String coatType) { this.coatType = coatType; }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
        result = 31 * result + sex;
        result = 31 * result + colour.hashCode();
        result = 31 * result + coatType.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
