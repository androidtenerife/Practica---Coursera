package com.chaacho.recyclerview.pojo;

import android.widget.ImageView;

public class Fotos {
    private String numlikes;
    private int foto;


    public String getNumlikes() {
        return numlikes;
    }

    public void setNumLikes(String numLikes) {
        this.numlikes = numLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public Fotos(String likes, Integer foto) {
        this.numlikes = likes;
        this.foto = foto;
    }

}
