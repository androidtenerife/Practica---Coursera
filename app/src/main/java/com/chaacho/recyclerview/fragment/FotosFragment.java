package com.chaacho.recyclerview.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaacho.recyclerview.R;
import com.chaacho.recyclerview.adapter.FotoAdapter;
import com.chaacho.recyclerview.pojo.Fotos;

import java.util.ArrayList;

public class FotosFragment extends Fragment {

    private ArrayList<Fotos> fotos;
    private RecyclerView listaFotos;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FotosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FotosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FotosFragment newInstance(String param1, String param2) {
        FotosFragment fragment = new FotosFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fotos, container, false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvFragmentFotos);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaFotos.setLayoutManager(new GridLayoutManager(getContext(), 3));

        inicializarListaFotos();
        inicializarAdaptador();

        // return super.onCreateView(inflater, container, savedInstanceState);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // throw new RuntimeException(context.toString()
            //       + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
