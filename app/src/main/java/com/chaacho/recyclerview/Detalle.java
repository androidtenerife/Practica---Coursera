package com.chaacho.recyclerview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Defino los textViews
        TextView tvTelefono = findViewById(R.id.tvTel);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvMail = findViewById(R.id.tvMail);

        // Recibo los parámetros
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono= parametros.getString("telefono");
        String email=parametros.getString("email");
        int foto = parametros.getInt("foto");
        //Seteo los valores que vienen en parametros.
        tvTelefono.setText(telefono);
        tvNombre.setText(nombre);
        tvMail.setText(email);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
