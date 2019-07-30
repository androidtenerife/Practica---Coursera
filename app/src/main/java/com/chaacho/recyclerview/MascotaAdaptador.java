package com.chaacho.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class
MascotaAdaptador extends Adapter<MascotaAdaptador.MascotaViewHolder> {

ArrayList<Mascotas>mascotas;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas) {
        this.mascotas=mascotas;
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
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.tvTel.setText(mascota.getTelefono());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //TODO Agregar la Clase Anidada VIewHolder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvApellido;
        private TextView tvTel;
        private TextView tvEmail;


        // Todo Crear el constructor de la superclase
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.ivPerro);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            tvEmail = itemView.findViewById(R.id.tvMail);
            tvTel = itemView.findViewById(R.id.tvTelefono);



        }
    }

}



