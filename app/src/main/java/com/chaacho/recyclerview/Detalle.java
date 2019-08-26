package com.chaacho.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import com.chaacho.recyclerview.pojo.Contacto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar myToolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);
        // Defino los textViews
        TextView tvTelefono = findViewById(R.id.tvTel);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvMail = findViewById(R.id.tvMail);

        // Recibo los parámetros
        try {
            // Get String will cause Nullpointer exception.
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono= parametros.getString("telefono");
        String email=parametros.getString("email");
        int foto = parametros.getInt("foto");


        //Seteo los valores que vienen en parametros.
        tvTelefono.setText(telefono);
        tvNombre.setText(nombre);
        tvMail.setText(email);
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
