/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Herrera
 */
public class ConexionBD {
    Connection cn;
    Statement st;
    
    public Connection conexion(){
      try{ 
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","");
        System.out.println("Se hizo la conexion exitosa");
      }catch(Exception e){
          System.out.println(e.getMessage());
      }return cn;
    }    
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }
}
