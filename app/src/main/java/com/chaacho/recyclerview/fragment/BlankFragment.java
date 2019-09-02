package com.chaacho.recyclerview.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaacho.recyclerview.R;
import com.chaacho.recyclerview.adapter.FotoAdapter;
import com.chaacho.recyclerview.pojo.Fotos;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private ArrayList<Fotos> fotos;

    private RecyclerView listaFotos;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fotos, container, false);
        listaFotos = (RecyclerView) container.findViewById(R.id.rvMascotas);
        LinearLayoutManager llmm = new LinearLayoutManager(getContext());
        llmm.setOrientation(RecyclerView.VERTICAL);
//        listaFotos.setLayoutManager(new GridLayoutManager(getContext(),3));
        listaFotos.setLayoutManager(llmm);

        inicializarListaFotos();
        inicializarAdaptador();
        // Inflate the layout for this fragment

        return v;
    }

    private void inicializarListaFotos() {
        //DO 2 Cargar Arraylist con los datos
        fotos = new ArrayList<>();
        fotos.add(new Fotos("1", R.drawable.perro));
        fotos.add(new Fotos("2", R.drawable.perroa));
        fotos.add(new Fotos("3", R.drawable.perrob));
        fotos.add(new Fotos("4", R.drawable.perroc));
        fotos.add(new Fotos("10", R.drawable.perro));
        fotos.add(new Fotos("20", R.drawable.perroa));
        fotos.add(new Fotos("30", R.drawable.perrob));
        fotos.add(new Fotos("40", R.drawable.perroc));
        fotos.add(new Fotos("5", R.drawable.perro));
        fotos.add(new Fotos("6", R.drawable.perroa));
        fotos.add(new Fotos("7", R.drawable.perrob));
        fotos.add(new Fotos("8", R.drawable.perroc));

    }

    private void inicializarAdaptador() {
        FotoAdapter adaptador = new FotoAdapter(fotos, getActivity());
        listaFotos.setAdapter(adaptador);


    }
}
