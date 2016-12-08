package com.example.daria.mythaiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.daria.mythaiapp.server.Breeder;
import com.example.daria.mythaiapp.server.DatabaseHandler;
import com.example.daria.mythaiapp.server.DatabaseHandlerClass;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandlerClass db = new DatabaseHandlerClass(this);

        System.out.println("Inserting ..");
        db.addBreeder(new Breeder(1,"Daria Gladskikh"));

        System.out.println("Reading all breeders");
        List<Breeder> breeders = db.getAllBreeders();
        for (Breeder breeder : breeders) {
            String log = "Id: "+breeder.getId()+" ,Name: " + breeder.getName();
            System.out.print("Name: ");
            System.out.println(log);
        }

        db.deleteAllBreeders();
    }




}
