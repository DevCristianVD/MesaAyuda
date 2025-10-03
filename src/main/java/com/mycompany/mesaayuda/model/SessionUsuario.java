package com.mycompany.mesaayuda.model;

/**
 *
 * @author demo_
 */
public class SessionUsuario {
    private static int idUsuario;
    private static String nombre;

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        SessionUsuario.idUsuario = idUsuario;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        SessionUsuario.nombre = nombre;
    }

    public static void cerrarSesion() {
        idUsuario = 0;
        nombre = null;
    }
}
