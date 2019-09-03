package com.chaacho.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chaacho.recyclerview.R;
import com.chaacho.recyclerview.adapter.MascotaAdaptador;
import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Mascotas> mascotas;

    private RecyclerView listaMascotas;


    //do Creo sobrescribo onCreateView.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        //listaMascotas.setLayoutManager(new GridLayoutManager(getContext(), 3));

        inicializarListaMascotas();
        inicializarAdaptador();

        // return super.onCreateView(inflater, container, savedInstanceState);

        return v;
    }



    public void inicializarListaMascotas() {
        //DO 2 Cargar Arraylist con los datos
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Jake", "96215", "dog4@chaacho.com", R.drawable.perroc));
        mascotas.add(new Mascotas("Dog 1", "94219", "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 2", "93213", "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 3", "95216", "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Jake", "96215", "dog4@chaacho.com", R.drawable.perroc));
        mascotas.add(new Mascotas("Dog 10", "94219", "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 20", "93213", "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 30", "95216", "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Jake 1", "96215", "dog4@chaacho.com", R.drawable.perroc));
        mascotas.add(new Mascotas("Dog 5", "94219", "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 6", "93213", "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 7", "95216", "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Jake 2", "96215", "dog4@chaacho.com", R.drawable.perroc));

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);


    }
}
