package com.chaacho.recyclerview.Mail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.chaacho.recyclerview.Mail.Mail;
import com.chaacho.recyclerview.MainActivity;
import com.chaacho.recyclerview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class Contacto extends AppCompatActivity {
    // TODO 1 - Aquí deberás cambiar por tus datos de Conexion a una cuenta de GMAIL.
    private String user = "**** COLOCA AQUÍ TU CORREO PARA TESTEAR ****";
    private String pass = "*** COLOCA AQUÍ TU CONTRASEÑA PARA TESTEAR ***";
    private String subject = "Coursera App Chaacho";
    private EditText body, recipient, email, nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //this.email = findViewById(R.id.etCorreo);
        this.nombre = findViewById(R.id.etNombre);
        this.body = (EditText) findViewById(R.id.etMensaje);
        this.recipient = (EditText) findViewById(R.id.etCorreo);
        Button enviar = findViewById(R.id.btEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String[] recipients = {recipient.getText().toString()};
        com.chaacho.recyclerview.Mail.SendEmailAsyncTask email = new com.chaacho.recyclerview.Mail.SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail(user, pass);
        email.m.set_from(nombre.getText().toString());
        email.m.setBody(body.getText().toString());
        email.m.set_to(recipients);
        email.m.set_subject(this.nombre.getText().toString() + " " + subject);
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.btEnviar), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
    Mail m;
    Contacto activity;

    public SendEmailAsyncTask() {
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            if (m.send()) {
                activity.displayMessage("Email sent.");
                //Devuelvo la actividad a la home.
                activity.displayMessage("Email sent.");
                activity.displayMessage("Email sent.");
                Intent intent = new Intent(activity.getBaseContext(), MainActivity.class);
                activity.startActivity(intent);
            } else {
                activity.displayMessage("Email failed to send.");
            }

            return true;
        } catch (AuthenticationFailedException e) {
            Log.e(com.chaacho.recyclerview.Mail.SendEmailAsyncTask.class.getName(), "Bad account details");
            e.printStackTrace();
            activity.displayMessage("Authentication failed.");
            return false;
        } catch (MessagingException e) {
            Log.e(com.chaacho.recyclerview.Mail.SendEmailAsyncTask.class.getName(), "Email failed");
            e.printStackTrace();
            activity.displayMessage("Email failed to send.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            activity.displayMessage("Unexpected error occured.");
            return false;
        }
    }


}
