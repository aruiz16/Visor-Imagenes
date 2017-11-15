/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.nio.file.Path;

/**
 *
 * @author Alejandro RG
 */
public class Imagen {
    private int id;
    private String titulo;
    private String ruta;

    public Imagen(int id, String titulo, String ruta) {
        this.id = id;
        this.titulo = titulo;
        this.ruta = ruta;
    }

    
    
    public Imagen(){
        this(0,"","");
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
   
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", titulo=" + titulo + ", ruta=" + ruta + '}';
    }

    
}
