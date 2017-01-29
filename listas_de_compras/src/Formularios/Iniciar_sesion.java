package Formularios;

import Formularios.Registrar;
import help.Help;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Iniciar_sesion extends javax.swing.JFrame 
{
    Adm_sql sql;
    String usuario="admin";
    String contraseña="admin";
    public Iniciar_sesion(boolean v) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        setTitle("iMarket");
              
        if(v){
            lblr.setText("Datos ingresados correctamente");
        }
        else{
          lblr.setText("");  
        }
    }
    
    
      public Image geticonimage()
    {
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("nuevas imagenes/pp.jpg"));
    return retValue;
    }


    public Iniciar_sesion() 
    {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        setTitle("iMarket - Inicio de Sesión");
        jButton5.setVisible(false);
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        lblmensage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblr = new javax.swing.JLabel();
        txtcon = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevas imagenes/mar.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(geticonimage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("¿Has olvidado tu contraseña?");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 220, -1));

        lblmensage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmensage.setForeground(new java.awt.Color(255, 51, 51));
        lblmensage.setToolTipText("");
        getContentPane().add(lblmensage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 160, 20));

        jLabel1.setBackground(java.awt.Color.red);
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 30));

        jLabel2.setBackground(new java.awt.Color(0, 204, 0));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 204, 0));
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        txtusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuActionPerformed(evt);
            }
        });
        txtusu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuKeyTyped(evt);
            }
        });
        getContentPane().add(txtusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Iniciar sesión");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 130, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Registrarse");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 100, 30));
        getContentPane().add(lblr, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 55, -1, -1));

        txtcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconActionPerformed(evt);
            }
        });
        getContentPane().add(txtcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 280, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevas imagenes/hh.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 90, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevas imagenes/hh.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 70, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevas imagenes/Sin título-1.jpg"))); // NOI18N
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 50, 50));

        jLabel7.setText("Ayuda");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 40, 30));

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevas imagenes/new.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Registrar hola=new Registrar();
        hola.show();
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void txtusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int n;
        if (!"".equals(txtusu.getText())&&!"".equals(txtcon.getText())) {
            sql=new Adm_sql();
        if ((txtusu.getText() == null ? usuario == null : txtusu.getText().equals(usuario)) && (txtcon.getText() == null ? contraseña == null : txtcon.getText().equals(contraseña))) {
            Agregar_productos hola=new Agregar_productos(); 
            hola.show();
            this.setVisible(false);
        }
        else{
            Principal_productos p=new Principal_productos();
            String[]vector=null;
            try {
                 
              n = sql.consultarlogin(txtusu.getText(), txtcon.getText());
              if (n==1) {
            String u=sql.leerusuarios1(txtusu.getText(), txtcon.getText());
            
            
            Image foto=sql.getfoto(txtusu.getText());
                  if (foto==null) {
//                      p.jLabel7.setIcon(null);
//                      p.jLabel7.updateUI();
               System.out.println("hola");
                       vector=u.split(";");
                      p.id=vector[1];
                     p.lblusuario.setText(vector[0]);
                     p.show();
                     this.setVisible(false);
                      
                  }
                  else{
                      
                      Icon ico=new ImageIcon(foto.getScaledInstance(p.jLabel7.getWidth(),  p.jLabel7.getHeight(), Image.SCALE_DEFAULT));
                      p.jLabel7.setIcon(ico);
                      p.jLabel7.updateUI();
            
                       vector=u.split(";");
                      p.id=vector[1];
                     p.lblusuario.setText(vector[0]);
                     p.show();
                     this.setVisible(false);
                  }
            
             } else {
            lblmensage.setText("Datos incorrectos");
            jButton5.setVisible(true);
           }
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
              
              
          }
        }
        else {
            lblmensage.setText("Ingresa los datos");
           }
      
      //String usu=sql.usuario;
      
  
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Help help = new Help();
        help.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String pre="";
        if (!"".equals(txtusu.getText())) {
            
            pre=sql.consul_usu(txtusu.getText());
            if (null==pre) {
                JOptionPane.showMessageDialog(null, "El usuario que ingresaste no existe");
            }
            else{
                String[]vector=pre.split(";");
                String name = JOptionPane.showInputDialog(this, vector[0]);
               if (name == null ? vector[1] == null : name.equals(vector[1])) {
                Recuperar_contraseña hola=new Recuperar_contraseña();
                hola.usu=txtusu.getText();
                hola.show();
       
              }
               else{
//                 name = JOptionPane.showInputDialog(this, vector[0]);
              }
            }
            
            
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtusuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuKeyTyped
        sololetrasnumeros (evt);// TODO add your handling code here:
    }//GEN-LAST:event_txtusuKeyTyped

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
         Help help = new Help();
        help.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked
    private void sololetrasnumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
    
         if((c<'a' || c>'z') && (c<'A' || c>'Z')&& (c< '0' || c> '9') &&  (c!=(char)KeyEvent.VK_SPACE))
          {
             evt.consume();
           } 
    }
    
      public static ArrayList<String> leerarchivo(String archivo) {
      String cadena;
      ArrayList<String> preguntas=new ArrayList<String>();
          try {
               FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
//          System.out.println(cadena);
            preguntas.add(cadena);
      }
      b.close();
          } catch (Exception e) {
          }
     
      return preguntas;
   } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Iniciar_sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Iniciar_sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Iniciar_sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Iniciar_sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Iniciar_sesion().setVisible(true);
            }
        
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblmensage;
    private javax.swing.JLabel lblr;
    private javax.swing.JPasswordField txtcon;
    private javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables
}
