package com.chaacho.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascotas>mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas=mascotas;
        this.activity=activity;
    }
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout y lo pasará al viewholder para que obtenga los views.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    //Asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.tvTel.setText(mascota.getTelefono());
        mascotaViewHolder.tvEmail.setText(mascota.getEmail());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), mascota.getNombre(), Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent (,Detalle.class);
                Intent intent1 = new Intent(view.getContext(), Detalle.class);
                intent1.putExtra("nombre",mascota.getNombre());
                intent1.putExtra("telefono",mascota.getTelefono());
                intent1.putExtra("email",mascota.getEmail());
                intent1.putExtra("foto",mascota.getFoto());
                view.getContext().startActivity(intent1);

            }
        });
    }

    @Override
    public int getItemCount() {

        return mascotas.size();
    }

    //TODO Agregar la Clase Anidada VIewHolder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTel;
        private TextView tvEmail;



        // Todo Crear el constructor de la superclase
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.ivPerro);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEmail = itemView.findViewById(R.id.tvMail);
            tvTel = itemView.findViewById(R.id.tvTel);



        }
    }

}



