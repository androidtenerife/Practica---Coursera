package com.chaacho.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class MascotaAdaptador extends Adapter<MascotaAdaptador.MascotaViewHolder> {


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

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
        private TextView tvTelefono;
        private TextView tvEmail;


        // Todo Crear el constructor de la superclase
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.ivPerro);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            tvEmail = itemView.findViewById(R.id.tvMail);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);



        }
    }

}
