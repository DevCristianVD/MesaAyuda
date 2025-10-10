package com.mycompany.mesaayuda.servicios;

import com.mycompany.mesaayuda.model.Departamento;
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
public class DepartamentoDAO {
     public void cargarDepartamentos(JComboBox<String> comboBox) {
        String sql = "SELECT nombre FROM tb_departamento";

        try (Connection conn = MySqlConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            comboBox.removeAllItems(); // Limpia el combo antes de llenarlo

            while (rs.next()) {
                comboBox.addItem(rs.getString("nombre")); // Agrega solo el nombre
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public String obtenerNombreDepartamento(int idDepartamento) {
    String nombre = null;
    String sql = "SELECT nombre FROM tb_departamento WHERE id = ?";

    try (Connection conn = MySqlConexion.getConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idDepartamento);

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

     
     public int obtenerIdPorNombre(String nombre) {
    String sql = "SELECT id FROM tb_departamento WHERE nombre = ?";
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
    return -1; // si no encuentra nada
}
     
}


