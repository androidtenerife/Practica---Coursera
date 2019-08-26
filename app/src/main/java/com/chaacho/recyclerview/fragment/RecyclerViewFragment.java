package com.chaacho.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chaacho.recyclerview.R;
import com.chaacho.recyclerview.adapter.MascotaAdaptador;
import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Mascotas> mascotas;

    private RecyclerView listaMascotas;



    //Todo Creo sobrescribo onCreateView.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        // return super.onCreateView(inflater, container, savedInstanceState);

        return v;
    }



    public void inicializarListaMascotas() {
        //TODO 2 Cargar Arraylist con los datos
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Dog 1", "94219", "dog1@chaacho.com", R.drawable.perro));
        mascotas.add(new Mascotas("Dog 2", "93213", "dog2@chaacho.com", R.drawable.perroa));
        mascotas.add(new Mascotas("Dog 3", "95216", "dog3@chaacho.com", R.drawable.perrob));
        mascotas.add(new Mascotas("Dog 4", "96215", "dog4@chaacho.com", R.drawable.perroc));

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);


    }
}
