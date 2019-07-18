package com.chaacho.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //TODO 1 Agregar un Arraylist de Mascotas
    ArrayList<Mascotas> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO 2 Cargar Arraylist con los datos
        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas("Dog 1", "94219", "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 2", "93213", "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 3", "95216", "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Dog 4", "96215", "dog4@chaacho.com", R.drawable.perroc));


    }
}
