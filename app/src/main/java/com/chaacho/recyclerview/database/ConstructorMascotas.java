package com.chaacho.recyclerview.database;

import android.content.ContentValues;
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
        //Ya que tengo una BD ahora no corresponde esta alta manual.
        /*
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
*/
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodosLasMascotas();

    }

    public void insertarTresMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tsuki Ta");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EMAIL, "tenerife.dev@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tsuki Na");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EMAIL, "tenerife.dev2@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perroa);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tsuki Ka");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EMAIL, "tenerife.dev3@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perrob);

        db.insertarMascota(contentValues);
    }
}


