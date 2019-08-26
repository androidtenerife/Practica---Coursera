package com.chaacho.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.chaacho.recyclerview.adapter.MascotaAdaptador;
import com.chaacho.recyclerview.adapter.PageAdapter;
import com.chaacho.recyclerview.fragment.BlankFragment;
import com.chaacho.recyclerview.fragment.RecyclerViewFragment;
import com.chaacho.recyclerview.pojo.Contacto;
import com.chaacho.recyclerview.pojo.Mascotas;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    // Defino los elementos del FrameLayout.
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    //TODO 1 Agregar un Arraylist de Mascotas
    ArrayList<Mascotas> mascotas;
    Activity activity;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           // getSupportActionBar();
        }catch(NullPointerException e){
            System.out.println("Action Bar... Null pointer Exption");
        }
        toolbar = findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Debemos ver que es lo que ha pulsado.
        switch (item.getItemId()) {
            //Devolverá el id del buton pulsado
            case R.id.acerca:
                Intent intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(this, Contacto.class);
                startActivity(intent1);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void setSupportActionBar(Toolbar myToolbar) {
    }

    // Debo cargar los fragments para ponerlos en órbita.
    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new BlankFragment());
        return fragments;
    }

    private void setupViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_stars);
        tabLayout.getTabAt(1).setIcon(R.drawable.hueso);
    }
}
