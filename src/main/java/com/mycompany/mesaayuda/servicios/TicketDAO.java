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
    
     public boolean registrarTicket(String titulo, int idDepartamento, int idPrioridad, String descripcion) {
        String sql = "INSERT INTO tb_ticket (titulo, id_departamento, id_prioridad, descripcion) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySqlConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setInt(2, idDepartamento);
            ps.setInt(3, idPrioridad);
            ps.setString(4, descripcion);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
    public Ticket obtenerTicketConEstado(String folio) {
    String sql = "SELECT t.folio, t.titulo, t.descripcion, s.nombre AS estado " +
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
                t.setEstado(rs.getString("estado")); // nombre del estado
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


}
