package com.mycompany.mesaayuda.model;

/**
 *
 * @author demo_
 */
public class Ticket {
    private int id;
    private String folio;
    private String titulo;
    private String descripcion;
    private String registrado;
    private int idDepartamento;
    private int idUsuario;
    private int idStatus;
    private int idPrioridad;
    private String estado;
    
    private int idTicket;
    private String fecha;
    private String tiempoInvertido;
    private String asignado;
    private String ultimaActualizacion;
    
    private String nombrePrioridad;
    
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getTiempoInvertido() {
        return tiempoInvertido;
    }

    public void setTiempoInvertido(String tiempoInvertido) {
        this.tiempoInvertido = tiempoInvertido;
    }

    public String getAsignado() {
        return asignado;
    }

    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }
    
    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(String ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }
    
    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }
}
