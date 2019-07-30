package com.chaacho.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //TODO 1 Agregar un Arraylist de Mascotas
    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        inicializarListaMascotas();

        ArrayList<String> mascotasContacto = new ArrayList<String>();
       // ListView lstContactos = (ListView)findViewById(R.id.lvMascotas);
        //lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.activity_list_item));
        listaMascotas = (RecyclerView) findViewById(R.id.cvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        //listaMascotas.setLayoutManager(llm);




    }

    private void setSupportActionBar(Toolbar myToolbar) {
    }

    public void inicializarListaMascotas(){
        //TODO 2 Cargar Arraylist con los datos
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas("Dog 1", "94219", "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 2", "93213", "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 3", "95216", "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Dog 4", "96215", "dog4@chaacho.com", R.drawable.perroc));

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas
        );
        listaMascotas.setAdapter(adaptador);

    }
}
