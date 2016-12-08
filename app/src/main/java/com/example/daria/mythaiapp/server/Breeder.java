package com.example.daria.mythaiapp.server;

/**
 * Created by daria on 08.12.16.
 */

public class Breeder {

    int id;
    String name;

    public Breeder() {
    }

    public Breeder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Breeder breeder = (Breeder) o;

        if (id != breeder.id) return false;
        return name.equals(breeder.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}