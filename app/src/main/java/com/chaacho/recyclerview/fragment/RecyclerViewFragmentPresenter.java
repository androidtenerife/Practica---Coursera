package com.chaacho.recyclerview.fragment;

import android.content.Context;

import com.chaacho.recyclerview.adapter.MascotaAdaptador;
import com.chaacho.recyclerview.database.ConstructorMascotas;
import com.chaacho.recyclerview.pojo.Mascotas;
import com.chaacho.recyclerview.presentador.IRecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasBaseDatosRV();


    }

    @Override
    public void mostrarMascotasBaseDatosRV() {
        iRecyclerViewFragment.inicializarAdaptador(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
