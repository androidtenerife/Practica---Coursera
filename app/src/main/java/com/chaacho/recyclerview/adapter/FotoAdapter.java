package com.chaacho.recyclerview.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chaacho.recyclerview.Detalle;
import com.chaacho.recyclerview.R;
import com.chaacho.recyclerview.pojo.Fotos;
import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder> {
    private ArrayList<Fotos> fotos;
    private Activity activity;

    public FotoAdapter(ArrayList<Fotos> fotos, Activity activity) {
        this.fotos = fotos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout y lo pasará al viewholder para que obtenga los views.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_fotos, parent, false);

        return new FotoViewHolder(v);
    }

    @Override
    //Asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull final FotoViewHolder fotoViewHolder, int position) {
        final Fotos foto = fotos.get(position);
        // fotoViewHolder.imgFoto.setImageResource(foto.getFoto());
/*
        fotoViewHolder.ivLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Has dado 1 Like a" + foto.getNumlikes(), Toast.LENGTH_SHORT).show();
            }
        });
*/
    }

    @Override
    public int getItemCount() {

        return fotos.size();
    }

    //DO Agregar la Clase Anidada VIewHolder
    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView numLikes;
        private ImageView ivLikes;

        // do Crear el constructor de la superclase
        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.ivFoto);
            ivLikes = itemView.findViewById(R.id.ivLike);
            numLikes = itemView.findViewById(R.id.tvNumLikes);


        }
    }
}