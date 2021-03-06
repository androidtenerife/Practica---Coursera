package com.chaacho.recyclerview.pojo;

public class Mascotas {
    private String nombre;
    private int like;
    private String email;
    private int foto;
    private int id;

    public Mascotas(int id, String nombre, int like, String email, int foto) {
        this.nombre = nombre;
        this.like = like;
        this.email = email;
        this.foto = foto;
        this.id = id;
    }

    public Mascotas() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId(int id) {
        this.id = id;
        return id;
    }


}
