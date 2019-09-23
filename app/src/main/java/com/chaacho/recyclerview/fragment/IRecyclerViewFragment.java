package com.chaacho.recyclerview.fragment;

import com.chaacho.recyclerview.adapter.MascotaAdaptador;
import com.chaacho.recyclerview.pojo.Mascotas;

import java.util.ArrayList;

public interface IRecyclerViewFragment {

    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptador();

    public void generarLinearLayoutVertical();
}
