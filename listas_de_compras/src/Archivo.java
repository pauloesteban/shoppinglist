
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisSolorzano
 */
public class Archivo {
    
    public Archivo(){
        
    }
    void muestraContenido(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while( b.readLine()!=null) {
          //System.out.println(cadena);
          cadena=b.readLine();
      }
      b.close();
}
    
    public static String ruta(String nombre){
        File archivo=new File(nombre);
        return archivo.getAbsolutePath();
    }

    public void guardar(String P_ruta,String[] vector) {
         FileWriter salida = null;
    try {
      salida = new FileWriter(P_ruta);
      BufferedWriter escritor = new BufferedWriter(salida);
        for (int i = 0; i < vector.length; i++) {
             escritor.write(vector[i]);
        }
     
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (salida != null) {
        try {
          salida.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
         
 
        
    }
}
