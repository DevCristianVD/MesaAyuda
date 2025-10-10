package com.mycompany.mesaayuda.servicios;

import com.mycompany.mesaayuda.model.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author demo_
 */
public class PrioridadDAO {
    public void cargarPrioridades(JComboBox<String> comboBox) {
        String sql = "SELECT nombre FROM tb_prioridades ORDER BY valor DESC"; 
        // Ordena de mayor a menor prioridad

        try (Connection conn = MySqlConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            comboBox.removeAllItems(); // Limpia el combo antes de llenarlo

            while (rs.next()) {
                comboBox.addItem(rs.getString("nombre")); // Agrega el nombre de la prioridad
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerIdPorNombre(String nombre) {
    String sql = "SELECT id FROM tb_prioridades WHERE nombre = ?";
    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; // Si no encuentra nada
}

    public String obtenerNombrePorId(int idPrioridad) {
    String nombre = null;
    String sql = "SELECT nombre FROM tb_prioridades WHERE id = ?";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idPrioridad);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                nombre = rs.getString("nombre");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return nombre;
}

}
