package com.chaacho.recyclerview.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.chaacho.recyclerview.Mail.Contacto;
import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Aqui va la estructura de la bbdd

        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_TELEFONO + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_EMAIL + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER " + ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER , " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";
        //db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);

    }

    //Metodo para consultas a la base de datos.
    public ArrayList<Mascotas> obtenerTodosLasMascotas() {
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        //Ejecucion del Query
        String query = "SELECT * FROM " + ConstantesBaseDatos.DATABASE_NAME + "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            //mascotaActual.setTelefono(registros.getString(2));
            mascotaActual.setEmail(registros.getString(3));
            //mascotaActual.setFoto(registros.getInt(4));
            // mascotaActual.setLike(registros.getInt(5));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.DATABASE_NAME, null, contentValues);
        db.close();
    }
}
