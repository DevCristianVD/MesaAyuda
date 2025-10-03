package com.mycompany.mesaayuda.servicios;

import com.mycompany.mesaayuda.model.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
