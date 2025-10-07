package com.mycompany.mesaayuda.model;

/**
 *
 * @author demo_
 */
public class SessionUsuario {
    private static int idUsuario;
    private static String nombreUsuario;
    private static int idRol; // ← antes era String rol

    public static void iniciarSesion(int id, String nombre, int rolId) {
        idUsuario = id;
        nombreUsuario = nombre;
        idRol = rolId;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static int getIdRol() {
        return idRol;
    }

    public static void cerrarSesion() {
        idUsuario = 0;
        nombreUsuario = null;
        idRol = 0;
    }
}
