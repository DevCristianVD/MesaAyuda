package com.mycompany.mesaayuda.servicios;

import com.mycompany.mesaayuda.model.MySqlConexion;
import com.mycompany.mesaayuda.model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public boolean registrarHistorialCambio(int idTicket, int idUsuario, String descripcion, Ticket t) {
    // YA NO NECESITAMOS BUSCAR EL ID, ¡lo recibimos directamente!
    // La llamada a obtenerIdUsuarioPorNombre() se elimina.

    String sql = "INSERT INTO tb_historial_ticket (id_ticket, id_usuario, descripcion, fecha, id_prioridad, id_status, tiempo_invertido, asignado, ultima_actualizacion) " +
                 "VALUES (?, ?, ?, NOW(), ?, ?, ?, ?, ?)";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idTicket);
        ps.setInt(2, idUsuario); // Usamos el ID de usuario que recibimos
        ps.setString(3, descripcion);
        ps.setInt(4, t.getIdPrioridad());
        ps.setInt(5, t.getIdStatus());
        ps.setString(6, t.getTiempoInvertido());
        ps.setString(7, t.getAsignado());
        ps.setString(8, t.getUltimaActualizacion());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    public int obtenerIdUsuarioPorNombre(String nombreUsuario) {
    // CAMBIO AQUÍ: Usamos el nombre correcto de la columna (ej. id_usuario)
    String sql = "SELECT id_usuario FROM tb_usuario WHERE nombre_usuario = ?"; 
    
    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, nombreUsuario);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Y CAMBIO AQUÍ también para que coincida
                return rs.getInt("id_usuario");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; // Retorna -1 si no se encuentra el usuario
}

    public List<Ticket> obtenerHistorialPorTicketId(int idTicket) {
    List<Ticket> historial = new ArrayList<>();
    
    // La consulta une las tablas para obtener los nombres de prioridad y estado
    String sql = "SELECT h.fecha, p.nombre AS prioridad_nombre, e.nombre AS estado_nombre, " +
                 "h.tiempo_invertido, h.asignado, h.ultima_actualizacion, h.descripcion " +
                 "FROM tb_historial_ticket h " +
                 "JOIN tb_prioridades p ON h.id_prioridad = p.id " +
                 "JOIN tb_estados e ON h.id_status = e.id " +
                 "WHERE h.id_ticket = ? " +
                 "ORDER BY h.fecha DESC";

    try (Connection conn = com.mycompany.mesaayuda.model.MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idTicket);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ticket registro = new Ticket();
                
                registro.setFecha(rs.getString("fecha"));
                registro.setNombrePrioridad(rs.getString("prioridad_nombre"));
                registro.setEstado(rs.getString("estado_nombre"));
                registro.setTiempoInvertido(rs.getString("tiempo_invertido"));
                registro.setAsignado(rs.getString("asignado"));
                registro.setUltimaActualizacion(rs.getString("ultima_actualizacion"));
                registro.setDescripcion(rs.getString("descripcion"));

                historial.add(registro);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return historial;
}
}
