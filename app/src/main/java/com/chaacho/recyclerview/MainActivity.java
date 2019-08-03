package com.chaacho.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

import static android.widget.LinearLayout.VERTICAL;


public class MainActivity extends AppCompatActivity {
    //TODO 1 Agregar un Arraylist de Mascotas
    ArrayList<Mascotas> mascotas;
    Activity activity;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   Toolbar myToolbar = findViewById(R.id.miActionBar);
   setSupportActionBar(myToolbar);
        // Menú de opciones


        ArrayList<String> mascotasContacto = new ArrayList<String>();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Debemos ver que es lo que ha pulsado.
        switch (item.getItemId()){
            //Devolverá el id del buton pulsado
            case R.id.acerca:
                Intent intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(this, Contacto.class);
                startActivity(intent1);
                break;
        }


        return super.onOptionsItemSelected(item);
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
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,activity);
        listaMascotas.setAdapter(adaptador);


    }
}
