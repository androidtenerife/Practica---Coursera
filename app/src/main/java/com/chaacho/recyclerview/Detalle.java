package com.chaacho.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.chaacho.recyclerview.Mail.Contacto;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        // Defino los textViews
        TextView tvLike = findViewById(R.id.tvLike);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvMail = findViewById(R.id.tvMail);
        ImageView ivFotoPerro = findViewById(R.id.ivFotoPerro);

        // Recibo los parámetros
        try {
            // Get String will cause Nullpointer exception.
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
            String like = parametros.getString("Like");
        String email=parametros.getString("email");
        int foto = parametros.getInt("foto");


        //Seteo los valores que vienen en parametros.
            tvLike.setText(like);
        tvNombre.setText(nombre);
        tvMail.setText(email);
            ivFotoPerro.setImageResource(foto);
        }catch (NullPointerException e){

            // A null pointer occurs.
        }



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

}
