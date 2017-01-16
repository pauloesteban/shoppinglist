/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Image;
import java.awt.List;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Herrera
 */
class Adm_sql {
     Connection cn;
     public String usuario;

    
     public Adm_sql(){
         usuario="";
     }
     
    public void RegistrarCliente(String Nombre, String Apellido,String usuario,String sexo,String fecha,String contraseña,FileInputStream foto,int l,String pregunta,String respuesta){
        try{
            ConexionBD con = new ConexionBD();
            cn=con.conexion();
            
            String sql="INSERT INTO tb_usuario(NOMBRES,APELLIDOS,USUARIO,SEXO,FECHA_NAC,CONTRASEÑA,IMAGEN,PREGUNTA,RESPUESTA) VALUES "+ "(?,?,?,?,?,?,?,?,?);";                    
            
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, Nombre);
                pst.setString(2, Apellido);
                pst.setString(3, usuario);
                pst.setString(4, sexo);
                pst.setString(5, fecha);
                pst.setString(6,contraseña);
                //pst.setBinaryStream(7,foto);
//                pst.setBlob(7, foto,l);
                //pst.setBlob(7, foto, l);
                pst.setBinaryStream (7,foto,l);
                pst.setString(8, pregunta);
                pst.setString(9, respuesta);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "SE HA REGISTRADO UN NUEVO CLIENTE");
                                                                 
            cn.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
   
     
    public void Registrarproducto(int cod, int codigo, String producto,double precio,int cant,FileInputStream foto,int l){
        try{
            ConexionBD con = new ConexionBD();
            cn=con.conexion();
            
            String sql="INSERT INTO tb_productos(CODIGO,PRODUCTO,PRECIO,CANTIDAD,IMAGEN,ID_CAT) VALUES "+ "(?,?,?,?,?,?);";                    
            
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, cod);
                pst.setString(2, producto);
                pst.setDouble(3, precio);
                pst.setInt(4, cant);
                pst.setBinaryStream (5,foto,l);
                pst.setInt(6, codigo);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "SE HA REGISTRADO UN NUEVO PRODUCTO");
                                                                 
            cn.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, " " + ex.getMessage());
        }
    }
    
    public Object[][] llenartabla(String cod){
        
        int filas=0;
        Object[][] datos =null;
        
         try {
              ConexionBD con = new ConexionBD();
            cn=con.conexion();
            String sql= "SELECT * FROM tb_productos WHERE ID_CAT='"+cod+"'";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
                while(res.next()){
                    //u=res.getString("NOMBRES")+"  "+ res.getString("APELLIDOS");
                   filas++;
                   
                }
                while(res.next()){
                    
                   datos = new Object[filas][5];
                for (int i = 0; i <filas; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j==0) {
                            datos[i][j]=res.getString("CODIGO");
                        }
                        if (j==1) {
                            datos[i][j]=res.getString("PRODUCTO");
                        }
                        if (j==2) {
                            datos[i][j]=res.getString("PRECIO");
                        }
                        if (j==3) {
                             datos[i][j]=res.getString("CANTIDAD");
                        }
                        if (j==4) {
                            datos[i][j]="Eliminar";
                        }
                        
                    }
                 
             }
                }
                 cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return datos;
    }
    
    public int consultarlogin(String usuario,String contraseña ){
         
         ConexionBD con = new ConexionBD();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_usuario WHERE USUARIO = '" + usuario + "' AND CONTRASEÑA = '" + contraseña + "'";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            int i = 0;
                while(res.next()){
//                    usu_id = res.getInt("tm_idusuario");
//                    usu_login = res.getString("tm_login");
//                    usu_password = res.getString("tm_password");
//                    data[i][0] = usu_id;
//                    data[i][1] = usu_login;
//                    data[i][2] = usu_password;
                     
                     resultado=1;
                    
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return resultado;
    }
    
    public String consul_usu(String usu){
         ConexionBD con = new ConexionBD();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_usuario WHERE USUARIO = '" + usu + "'";
         String u="";
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            int i = 0;
                while(res.next()){
                   u=res.getString("PREGUNTA")+";"+ res.getString("RESPUESTA");
                     
                     resultado=1;
                    
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return u;
    }
    
    
   public void actua_contraseña(String usu,String contra){
       ConexionBD con = new ConexionBD();
            cn=con.conexion();
         String sSQL = "UPDATE tb_usuario " +"SET CONTRASEÑA = ?" +"WHERE USUARIO = '"+ usu + "'";
          try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, contra);
            int n = pst.executeUpdate();
            if(n > 0)
            {
              JOptionPane.showMessageDialog(null, "Contraseña actualizada con exito");

             }
            else{
                JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña");
            }
            
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
   } 
    
    public String leerusuarios1(String usuario,String contraseña){
         
         ConexionBD con = new ConexionBD();
         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
            String u="";
          String sql= "SELECT * FROM tb_usuario WHERE USUARIO = '" + usuario + "' AND CONTRASEÑA = '" + contraseña + "'";;
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
                while(res.next()){
                    u=res.getString("NOMBRES")+"  "+ res.getString("APELLIDOS")+";"+""+res.getString("USUARIO");
                   
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return u;
    }
    
    
    
     public ArrayList<String> leerusuarios(){
         
         ConexionBD con = new ConexionBD();
         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_usuario";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            //int i = 0;
                while(res.next()){
//                    usu_id = res.getInt("tm_idusuario");
//                    usu_login = res.getString("tm_login");
//                    usu_password = res.getString("tm_password");
//                    data[i][0] = usu_id;
//                    data[i][1] = usu_login;
//                    data[i][2] = usu_password;
                    nombreArrayList.add(res.getString("NOMBRES")+" " +res.getString("APELLIDOS"));
                     //usuario=res.getString("NOMBRES").toString();
                     //resultado=1;
                   
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return nombreArrayList;
    }
     
      public ArrayList<String> leerusuarios12(){
         
         ConexionBD con = new ConexionBD();
         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_usuario";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            //int i = 0;
                while(res.next()){
//                    usu_id = res.getInt("tm_idusuario");
//                    usu_login = res.getString("tm_login");
//                    usu_password = res.getString("tm_password");
//                    data[i][0] = usu_id;
//                    data[i][1] = usu_login;
//                    data[i][2] = usu_password;
                    nombreArrayList.add(res.getString("USUARIO"));
                     //usuario=res.getString("NOMBRES").toString();
                     //resultado=1;
                   
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return nombreArrayList;
    }
     
    public void modproducto(int cant,String codigo,int cat){
        ConexionBD con = new ConexionBD();
            cn=con.conexion();
         String sSQL = "UPDATE tb_productos " +"SET CANTIDAD = ?" +" WHERE CODIGO = '"+ codigo + "' AND ID_CAT = '" + cat + "'";
          try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, cant);
            int n = pst.executeUpdate();
            if(n > 0)
            {
              JOptionPane.showMessageDialog(null, "Producto actualizado con exito");

             }
            else{
                JOptionPane.showMessageDialog(null, "Error al actulizar el producto");
            }
            
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    } 
     
    public String consultarproducto(String codigo,int cate){
        ConexionBD con = new ConexionBD();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_productos WHERE CODIGO = '" + codigo + "' AND ID_CAT = '" + cate + "'";
         String u="";
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            int i = 0;
                while(res.next()){
                   u=res.getString("PRODUCTO")+";"+ res.getString("PRECIO")+";"+res.getString("CANTIDAD");
                     
                     resultado=1;
                    
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return u;
    } 
    
    public ArrayList<String> leerproductos(){
         
         ConexionBD con = new ConexionBD();
         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_productos";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            //int i = 0;
                while(res.next()){
//                    usu_id = res.getInt("tm_idusuario");
//                    usu_login = res.getString("tm_login");
//                    usu_password = res.getString("tm_password");
//                    data[i][0] = usu_id;
//                    data[i][1] = usu_login;
//                    data[i][2] = usu_password;
                    nombreArrayList.add(res.getString("PRODUCTO"));
                     //usuario=res.getString("NOMBRES").toString();
                     //resultado=1;
                   
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return nombreArrayList;
    }
    
     public ArrayList<String> leerproductos2(String cod){
         
         ConexionBD con = new ConexionBD();
         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_productos WHERE ID_CAT = '"+cod+"'";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            //int i = 0;
                while(res.next()){
//                    
                    nombreArrayList.add(res.getString("PRODUCTO")+";"+res.getString("PRECIO")+";"+res.getString("CODIGO"));
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return nombreArrayList;
    }
    
     public String leerproductos3(String cod){
         ConexionBD con = new ConexionBD();
//         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
            String u="";
         String sql= "SELECT * FROM tb_productos WHERE CODIGO = '"+cod+"'";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            //int i = 0;
                while(res.next()){
//                    u=
                    u=res.getString("PRODUCTO")+";"+res.getString("PRECIO")+";"+res.getString("CODIGO");
                    //nombreArrayList.add(res.getString("PRODUCTO")+";"+res.getString("PRECIO")+";"+res.getString("CODIGO"));
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return u;
     }
     
     
    public String leerpro(String cod){
         ConexionBD con = new ConexionBD();
         ArrayList<String> nombreArrayList = new ArrayList<String>();
            cn=con.conexion();
            int resultado=0;
            String p="";
         String sql= "SELECT * FROM tb_productos WHERE ID_CAT = '"+cod+"'";
         
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            //int i = 0;
                while(res.next()){
                    p=res.getString("PRODUCTO")+";"+res.getString("PRECIO")+";"+res.getString("CODIGO");
                    //nombreArrayList.add(res.getString("PRODUCTO")+";"+res.getString("PRECIO")+";"+res.getString("CODIGO"));
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
        return p; 
    } 
     
    public ArrayList<String> consultarlista(String usuario,String fecha){
        ConexionBD con = new ConexionBD();
            cn=con.conexion();
            int resultado=0;
         String sql= "SELECT * FROM tb_listausu WHERE USUARIO = '" + usuario + "' AND FECHA = '" + fecha + "'";
         ArrayList<String>lista=new ArrayList<String>();
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            int i = 0;
                while(res.next()){
                   //u=res.getString("ID_PRODUCT");
                     
                     lista.add(res.getString("ID_PRODUCT"));
                     resultado=1;
                    
                }
                cn.close();
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        finally{
       
        }
         return lista;
    }
    
    public void llenartablalista(String id , int idpro,String fecha){
         try{
            ConexionBD con = new ConexionBD();
            cn=con.conexion();
            
            String sql="INSERT INTO tb_listausu(USUARIO,ID_PRODUCT,FECHA) VALUES "+ "(?,?,?);";                    
            
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setInt(2, idpro);
                pst.setString(3,fecha);
//                pst.setInt(4, cant);
//                pst.setBinaryStream (5,foto,l);
//                pst.setInt(6, codigo);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null, "SE HA REGISTRADO UN NUEVO PRODUCTO");
                                                                 
            cn.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, " " + ex.getMessage());
        }
    }
     private Image data;
    //metodo  que dado un parametro "id" realiza una consulta y devuelve como resultado
// una imagen
  public Image getfoto(String id){         
     ConexionBD con = new ConexionBD();
            cn=con.conexion();
            boolean b1=false;
     try{    
         PreparedStatement pstm = cn.prepareStatement("SELECT " +
            " IMAGEN " +
            " FROM tb_usuario " +
            " where USUARIO = ? ");
         pstm.setString(1, id);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            //se lee la cadena de bytes de la base de datos
            byte[] b = res.getBytes("IMAGEN");
             if (b==null) {
                 b1=true;
                 break;
             }
             else{
                 data = ConvertirImagen(b);
             }
            // esta cadena de bytes sera convertida en una imagen
                        
            i++;
         }
         res.close();
         cn.close();
          } catch (IOException ex) {
           //Logger.getLogger(fotoclass.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException e){
//         System.out.println(e.getMessage());
    }    
     if(b1){
         return null;
     }
     else{
         return data;
     }
         
 }
  
  public ArrayList<Image> leerimagenes(){         
     ConexionBD con = new ConexionBD();
            cn=con.conexion();
      ArrayList<Image>   lista = new ArrayList<Image>();   
     try{    
         PreparedStatement pstm = cn.prepareStatement("SELECT * FROM tb_categoria");
         //pstm.setInt(1, id);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            //se lee la cadena de bytes de la base de datos
            byte[] b = res.getBytes("IMAGEN");
            // esta cadena de bytes sera convertida en una imagen
            lista.add( ConvertirImagen(b));            
            i++;
         }
         res.close();
         cn.close();
          } catch (IOException ex) {
            //Logger.getLogger(fotoclass.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException e){
         System.out.println(e);
    }        
    return lista;     
 }
  
  
  public ArrayList<Image> imagproductos(String id){         
     ConexionBD con = new ConexionBD();
            cn=con.conexion();
      ArrayList<Image>   lista = new ArrayList<Image>();   
     try{    
         String sql= "SELECT * FROM tb_productos WHERE CODIGO = '"+id+"'";
         PreparedStatement pstm = cn.prepareStatement(sql);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            //se lee la cadena de bytes de la base de datos
            byte[] b = res.getBytes("IMAGEN");
            // esta cadena de bytes sera convertida en una imagen
            lista.add( ConvertirImagen(b));            
            i++;
         }
         res.close();
         cn.close();
          } catch (IOException ex) {
            //Logger.getLogger(fotoclass.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException e){
         System.out.println(e);
    }        
    return lista;     
 }
 
 
         private Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis; // File or InputStream
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 } 

//public void ModificarCliente(JTextField Codigo, JTextField Nombre, JTextField Apellido){
//        try{
//            Conexion con = new Conexion();
//            cn=con.conectar();
//            
//            String sql="CALL MODIFICAR_CLIENTE (?,?,?)";                    
//            
//            PreparedStatement pst = cn.prepareCall(sql);                             
//                                                   
//            pst.setString(1, Codigo.getText());                                              
//            pst.setString(2, Nombre.getText());
//            pst.setString(3, Apellido.getText());
//            
//            pst.executeUpdate();
//            JOptionPane.showMessageDialog(null, "SE HA MODIFICADO CORRECTAMENTE");
//                                                                    
//            pst.close();                                                            
//            cn.close();
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
}
