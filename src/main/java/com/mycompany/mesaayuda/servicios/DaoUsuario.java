package com.mycompany.mesaayuda.servicios;

import com.mycompany.mesaayuda.model.DtoUsuario;
import com.mycompany.mesaayuda.model.MySqlConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class DaoUsuario {
    
    public DtoUsuario login(String usuario, String pass){
        DtoUsuario dtoUsuario = null;
        var sql = "SELECT nombre, apellido_paterno, usuario FROM tb_usuario WHERE usuario=? AND password_usuario = aes_encrypt(?,?)";
        
        try(Connection db = MySqlConexion.getConexion();
                PreparedStatement ps = db.prepareStatement(sql)){
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            ps.setString(3, MySqlConexion.CLAVE_ENCRIPTACION);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                dtoUsuario = new DtoUsuario();
                dtoUsuario.setNombre(rs.getString("nombre"));
                dtoUsuario.setApellidoPaterno(rs.getString ("apellido_paterno"));
                dtoUsuario.setUsuario(rs.getString("usuario"));               
                
            }
            }
            
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return dtoUsuario;
    }
}

    
