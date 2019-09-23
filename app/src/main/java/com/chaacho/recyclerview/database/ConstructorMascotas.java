package com.chaacho.recyclerview.database;

import android.content.Context;

import com.chaacho.recyclerview.R;
import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerMascotas() {
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Jake", 96215, "dog4@chaacho.com", R.drawable.perroc));
        mascotas.add(new Mascotas("Dog 1", 94219, "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 2", 93213, "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 3", 95216, "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Jake", 6215, "dog4@chaacho.com", R.drawable.perroc));
        mascotas.add(new Mascotas("Dog 10", 94219, "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 20", 93213, "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 30", 95216, "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Jake 1", 96215, "dog4@chaacho.com", R.drawable.perroc));
        mascotas.add(new Mascotas("Dog 5", 4219, "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 6", 93213, "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 7", 95216, "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Jake 2", 96215, "dog4@chaacho.com", R.drawable.perroc));

        return mascotas;
    }
}


