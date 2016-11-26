package com.example.daria.mythaiapp.server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daria on 26.11.16.
 */

public interface DatabaseHandler {

    public void addDog(Dog dog);
    public Dog getDog(int id);
    public List<Dog> getAllDogs();
    public int updateDog(Dog dog);
    public void deleteDog(Dog dog);
    public void deleteAll();

    //public List<Dog> findByColor();
    //public List<Dog> findByCoatType();

    public List<Dog> findbyParametres();
}
