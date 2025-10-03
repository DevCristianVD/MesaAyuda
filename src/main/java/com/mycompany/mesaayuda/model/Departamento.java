
package com.mycompany.mesaayuda.model;

/**
 *
 * @author demo_
 */
public class Departamento {
     private int id;
    private String nombre;
    private String abreviacion;

    public Departamento(int id, String nombre, String abreviacion) {
        this.id = id;
        this.nombre = nombre;
        this.abreviacion = abreviacion;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getAbreviacion() { return abreviacion; }

    @Override
    public String toString() {
        return nombre; // Lo que se mostrará en el JComboBox
    }
}
