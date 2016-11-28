package com.example.daria.mythaiapp.server;

/**
 * Created by daria on 26.11.16.
 */

public class Dog {

    int id;
    //TODO: как хранить дату рождения и фото?
    boolean sex;
    Color color;
    CoatType coatType;
    PriceCategory category;
    String text;

    public Dog() {
    }

    //TODO: конструктор с параметрами пока не доделываю, т.к. параметров будет больше
    /*public Dog(int id, boolean sex, Color color, CoatType coatType, String text) {
        this.id = id;
        this.sex = sex;
        this.color = color;
        this.coatType = coatType;
        this.text = text;
    }*/

    //TODO: геттеры, сеттеры, equals и hashCode пока отсутствуют по той же причине


}
