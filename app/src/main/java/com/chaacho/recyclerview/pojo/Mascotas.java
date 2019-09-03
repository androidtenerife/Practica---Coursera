package com.chaacho.recyclerview.pojo;

public class Mascotas {
    private String nombre;
    private String like;
    private String email;
    private int foto;

    public Mascotas(String nombre, String like, String email, int foto) {
        this.nombre = nombre;
        this.like = like;
        this.email = email;
        this.foto = foto;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
