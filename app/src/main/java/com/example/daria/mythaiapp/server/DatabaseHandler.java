package com.example.daria.mythaiapp.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by daria on 26.11.16.
 */

public interface DatabaseHandler {

    public void addDog(Dog dog);
    public Dog getDog(int id);
    public List<Dog> getAllDogs();
    public int updateDog(Dog dog);
    public void deleteDog(Dog dog);
    public void deleteAllDogs();
    public List<Dog> findbyParametres();
}
