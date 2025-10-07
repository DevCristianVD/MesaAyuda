package com.mycompany.mesaayuda.model;

/**
 *
 * @author demo_
 */
public class DtoUsuario {
   String nombre;
   int id;
   private int idRol;

  
   public int getId() {
        return id;
    }
   
   public int getIdRol() {
    return idRol;
    }

    public void setIdRol(int idRol) {
    this.idRol = idRol;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DtoUsuario{" + "nombre=" + nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", Usuario=" + Usuario + '}';
    }
    String ApellidoPaterno;
    String Usuario;
}
