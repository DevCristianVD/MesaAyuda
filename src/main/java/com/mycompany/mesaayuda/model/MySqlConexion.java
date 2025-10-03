package com.mycompany.mesaayuda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author demo_
 */
public class MySqlConexion {
    private static final String host="localhost:3306";
    private static final String usuario="root";
    private static final String password="1234";
    private static final String bd="tec";
    
    public static final String CLAVE_ENCRIPTACION = "clave_de_encriptacion";
    
   // private static Connection db = null;
    
    private MySqlConexion(){}
    
    public static Connection getConexion() throws SQLException{
        var cadenaConexion = "jdbc:mysql://" + host + "/" + bd + "?useSSL=false";
        Connection db = DriverManager.getConnection(cadenaConexion,usuario,password);
        return db;
    }
    
    public static boolean isConexionCarrecta(){
        try(Connection db = getConexion()){
            return db.isValid(3);
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
