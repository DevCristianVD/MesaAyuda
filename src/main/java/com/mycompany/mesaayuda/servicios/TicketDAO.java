package com.mycompany.mesaayuda.servicios;

import com.mycompany.mesaayuda.model.MySqlConexion;
import com.mycompany.mesaayuda.model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author demo_
 */
public class TicketDAO {
    
     public boolean registrarTicket(String titulo, int idDepartamento, int idPrioridad, String descripcion, int idUsuario) {
    String sql = "INSERT INTO tb_ticket (titulo, id_departamento, id_prioridad, descripcion, id_usuario) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, titulo);
        ps.setInt(2, idDepartamento);
        ps.setInt(3, idPrioridad);
        ps.setString(4, descripcion);
        ps.setInt(5, idUsuario);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

     
    public Ticket obtenerTicketConEstado(String folio) {
    String sql = "SELECT t.folio, t.titulo, t.descripcion, t.id_departamento, t.id_prioridad, s.nombre AS estado " +
                 "FROM tb_ticket t " +
                 "JOIN tb_estados s ON t.id_status = s.id " +
                 "WHERE t.folio = ?";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, folio);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Ticket t = new Ticket();
                t.setFolio(rs.getString("folio"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEstado(rs.getString("estado"));
                t.setIdDepartamento(rs.getInt("id_departamento"));
                t.setIdPrioridad(rs.getInt("id_prioridad")); // ← esta línea es clave

                return t;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    public int obtenerIdTicketPorFolio(String folio) {
    String sql = "SELECT id FROM tb_ticket WHERE folio = ?";
    
    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, folio);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; // Si no se encuentra
}

    public boolean actualizarTicket(Ticket t) {
    String sql = "UPDATE tb_ticket SET id_prioridad = ?, id_status = ?, tiempo_invertido = ?, asignado = ?, ultima_actualizacion = ? WHERE id = ?";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, t.getIdPrioridad());
        ps.setInt(2, t.getIdStatus());
        ps.setString(3, t.getTiempoInvertido());
        ps.setString(4, t.getAsignado());
        ps.setString(5, t.getUltimaActualizacion());
        ps.setInt(6, t.getId());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean registrarHistorialCambio(int idTicket, String usuario, String descripcion, Ticket t) {
    String sql = "INSERT INTO tb_historial_ticket (id_ticket, fecha, id_prioridad, id_status, tiempo_invertido, asignado, ultima_actualizacion) " +
                 "VALUES (?, NOW(), ?, ?, ?, ?, ?)";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idTicket);
        ps.setInt(2, t.getIdPrioridad());
        ps.setInt(3, t.getIdStatus());
        ps.setString(4, t.getTiempoInvertido());
        ps.setString(5, t.getAsignado());
        ps.setString(6, t.getUltimaActualizacion());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
}
