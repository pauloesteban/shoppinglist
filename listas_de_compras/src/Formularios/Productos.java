/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author LuisSolòrzano
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    
    Adm_sql sql;
     int longitud;
     private FileInputStream fis;
     int codigo,num=0,canttotal=0,n1=0;
     boolean mod=false;
//     int n=0;
        public Image geticonimage()
    {
     Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("nuevas imagenes/pp.jpg"));
    return retValue;
    }

    public Productos() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        setTitle("iMarket - Agregar Productos");
        txtcodigo.setEditable(false);
        jPanel2.setVisible(false);
        
        InputMap map = new InputMap();
 
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
 
        btnregistrar1.setInputMap(0, map);
        
        
        
        sql=new Adm_sql();
  
        //setSize(905, 685);
        ArrayList<Image>   lista=sql.leerimagenes();
        foto(lblfoto1,lista.get(0));
        foto(lblfoto2,lista.get(1));
        foto(lblfoto3,lista.get(2));
        foto(lblfoto4,lista.get(3));
        foto(lblfoto6,lista.get(4));
        foto(lblfoto7,lista.get(5));
        setJTexFieldChanged(this.txtproducto);
        //txtcodigo.setEnabled(false);
        
    }
    
    private void foto(JLabel l,Image foto){
        Icon ico=new ImageIcon(foto.getScaledInstance(l.getWidth(),  l.getHeight(), Image.SCALE_DEFAULT));
            l.setIcon(ico);
            l.updateUI();
    }
    
    public void llenartabla(String cod){
      sql= new Adm_sql();
     ArrayList<String>lista=sql.buscar(cod);
     DefaultTableModel aModel = new DefaultTableModel();
        
       
        String[] columnNames = {"COdigo", "Producto", "Precio","Cantida","Eliminar"};
        aModel.setColumnIdentifiers(columnNames);
        Object[] temp = new Object[5];
        String[] cadena;
        //System.out.println(" "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
           //System.out.println(" "+lista.get(i));
            cadena=lista.get(i).split(";");
//            
             aModel.addRow(cadena);
       }
//       
        tablita.setModel(aModel);
        
        Action delete = new AbstractAction()
       {
            public void actionPerformed(ActionEvent e)
            {
               JTable table = (JTable)e.getSource();
               int modelRow = Integer.valueOf( e.getActionCommand() );
               System.out.print(modelRow );
                if (modelRow>=0) {
                    for (int i = 0; i < tablita.getModel().getColumnCount(); i++) {
                        if (!tablita.getModel().getColumnClass(i).equals(JButton.class)) {
                            //sb.append("\n").append(tablita.getModel().getColumnName(i)).append(": ").append(tablita.getModel().getValueAt(modelRow, i));
                        }
                    }
                    
                    int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    if (resp==0) {
                        DefaultTableModel tm = (DefaultTableModel) tablita.getModel();
                        String dato=String.valueOf(tm.getValueAt(tablita.getSelectedRow(),1));
                       String cod=String.valueOf(tm.getValueAt(tablita.getSelectedRow(),0));
                        System.out.println(dato);
//                        int n= sql.eliminar(cod);
//                        if (n>0) {
//                             
////                              int eli=sql.eliminarfecha(cod);
//                            ((DefaultTableModel)table.getModel()).removeRow(modelRow);
//                              llenartabla();
//                              
//                        }
                    }
                } else {
                    
                }
               
                
                
                
             }
           
       };
        ButtonColumn buttonColumn = new ButtonColumn(tablita, delete, 4);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
   
  }
  
    private void setJTexFieldChanged(JTextField txt){
        DocumentListener documentListener = new DocumentListener() {
 
        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent,txt);
        }
 
        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent,txt);
        }
 
        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent,txt);
        }
        };
        txt.getDocument().addDocumentListener(documentListener);
 
    }
    private void printIt(DocumentEvent documentEvent,JTextField txt ) {
        DocumentEvent.EventType type = documentEvent.getType();
 
        if (type.equals(DocumentEvent.EventType.CHANGE))
        {
 
        }
        else if (type.equals(DocumentEvent.EventType.INSERT))
        {
            txtEjemploJTextFieldChanged(txt);
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE))
        {
            txtEjemploJTextFieldChanged(txt);
        }
    }
    private void txtEjemploJTextFieldChanged(JTextField txt){
        
        cambiar(txt);
    }
    public void cambiar(JTextField txt){
//        txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
        try {
//            int n=generarcodigo();
//             txtcodigo.setText(" "+n); 
//        String cadena=sql.consultarproducto(txt.getText(),num);
//        String[] vector=cadena.split(";");
//        if (null!=cadena) {
//            mod=true;
//            //canttotal=Integer.valueOf(vector[2])+Integer.valueOf(txtcantidad.getText());
//            btnregistrar1.setText("Modificar");
//            txtproducto.setEditable(false);
//            txtprecio.setEditable(false);
//            txtproducto.setText(vector[0]);
//            txtprecio.setText(vector[1]);
//            n1=Integer.parseInt(vector[2]);
//            txtcantidad.setText(" "+n1);
//           
////            JOptionPane.showMessageDialog(null, " "+canttotal);
//            
//        }
//        else{
//            mod=false;
//            btnregistrar1.setText("Registrar");
//            canttotal=0;
//            txtproducto.setEditable(true);
//            txtprecio.setEditable(true);
//            txtproducto.setText("");
//            txtprecio.setText("");
//            txtcantidad.setText("");
//        }
          
        } catch (Exception e) {
        }
        
        
        
    }
 

    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btncancelar = new javax.swing.JButton();
        btnregistrar1 = new javax.swing.JButton();
        lblmensaje = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtprecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        lbltitulo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblfoto7 = new javax.swing.JLabel();
        lblfoto1 = new javax.swing.JLabel();
        lblfoto2 = new javax.swing.JLabel();
        lblfoto3 = new javax.swing.JLabel();
        lblfoto4 = new javax.swing.JLabel();
        lblfoto6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncancelar.setText("Cancelar");
        btncancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 90, 20));

        btnregistrar1.setText("Registrar");
        btnregistrar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnregistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrar1ActionPerformed(evt);
            }
        });
        btnregistrar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnregistrar1KeyPressed(evt);
            }
        });
        jPanel2.add(btnregistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 20));
        jPanel2.add(lblmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, 10));

        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 250, -1));

        jLabel10.setText("Cantidad:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 10));

        jButton1.setText("buscar foto");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 80, 20));

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });
        jPanel2.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, -1));

        jLabel9.setText("Precio:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductoActionPerformed(evt);
            }
        });
        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtproductoKeyTyped(evt);
            }
        });
        jPanel2.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 30));

        jLabel8.setText("Producto:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblfoto.setText("          Foto");
        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 80, 70));

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });
        jPanel2.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        jLabel12.setText("Código:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        jLabel6.setText("Agregar Productos");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 130, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 290, 290));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 90, 30));

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel7.setText("Categorías");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 70, 30));

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablita);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 530, 530));

        lbltitulo.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        getContentPane().add(lbltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 180, 20));

        jButton3.setText("Tecnologia");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 160, 40));

        jButton4.setText("Ferreteria");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 160, 40));

        jButton5.setText("Carnes & Embutidos");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, 40));

        jButton6.setText("Frutas & Verduras");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, 40));

        jButton7.setText("Bebidas");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 160, 40));

        jButton8.setText("Jugueteria");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 160, 40));

        lblfoto7.setText("  foto");
        lblfoto7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblfoto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 40, 40));

        lblfoto1.setText("  foto");
        lblfoto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblfoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 40, 40));

        lblfoto2.setText("  foto");
        lblfoto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblfoto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 40, 40));

        lblfoto3.setText("  foto");
        lblfoto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblfoto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 40, 40));

        lblfoto4.setText("  foto");
        lblfoto4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblfoto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 40, 40));

        lblfoto6.setText("  foto");
        lblfoto6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblfoto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 40, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 480, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel3);

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 290, 350));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Regresar");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 80, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 680));

        jButton9.setText("jButton9");
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        
    }//GEN-LAST:event_txtprecioActionPerformed
    
    private void setTabla(JTable jTable1,String cod) {
//        Calendar c1 = GregorianCalendar.getInstance();
//        c1.set(1980, 11, 23);
//        Date fecha1 = c1.getTime();
//        c1.set(1987, 07, 11);
//        Date fecha2 = c1.getTime();
//        c1.set(1971, 02, 01);
//        Date fecha3 = c1.getTime();

        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{
            "Código",
            "Producto",
            "Precio",
            "Cantidad",
            "Eliminar"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            
//            Date.class,
            //int.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };
        //sql=new Adm_sql();
        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        //Object[][] datos = sql.llenartabla(cod);
        
        Object[][] datos = new Object[][]{
            {"hola", "Víctor", "Su casa","jjj", new JButton("Clic aquí")},
            //{false, "Fernanda", "calle sin nombre #501", fecha2, 0, new JButton("Clic aquí")},
            //{true, "Julian", "Orilla del rio #014", fecha3, 0, new JButton("Clic aquí")}
        };

        
       //Object [] datos = new Object[4];
//       DefaultTableModel datos = new DefaultTableModel();
        // Defino el TableModel y le indico los datos y nombres de columnas
        jTable1.setModel(new javax.swing.table.DefaultTableModel(datos,columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        jTable1.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         * Noten que estamos capturando el clic sobre JTable, no el clic sobre el JButton. Esto también implica que en 
         * lugar de poner un botón en la celda, simplemente pudimos definir un CellRenderer que hiciera parecer que la 
         * celda contiene un botón. Es posible capturar el clic del botón, pero a mi parecer el efecto es el mismo y 
         * hacerlo de esta forma es más "simple"
         */
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTable1.rowAtPoint(e.getPoint());
                int columna = jTable1.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (jTable1.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                        if (!jTable1.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(jTable1.getModel().getColumnName(i)).append(": ").append(jTable1.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                }
            }
        });
    }


    
    private void btnregistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrar1ActionPerformed
        sql=new Adm_sql();
        
        if (mod) {
            String sq=txtcantidad.getText();
            int m=Integer.parseInt(sq.trim(),16);
            canttotal=m+n1;
            sql.modproducto(canttotal, txtcodigo.getText(), num);
            limpiar();
        }
        else{
             int n=Integer.parseInt(txtcodigo.getText().trim(),16);
             try {
            
             if (num==1111) {
                 
            sql.Registrarproducto(n,1111, txtproducto.getText(),Double.valueOf(txtprecio.getText()), Integer.valueOf(txtcantidad.getText()) , fis, longitud);
            limpiar();
        }
        else {
            if (num==2222){
                  sql.Registrarproducto(n,2222, txtproducto.getText(),Double.valueOf(txtprecio.getText()), Integer.valueOf(txtcantidad.getText()) , fis, longitud);
                  limpiar();
            }
            else{
                if (num==3333){
                  sql.Registrarproducto(n,3333, txtproducto.getText(),Double.valueOf(txtprecio.getText()), Integer.valueOf(txtcantidad.getText()) , fis, longitud);
                  limpiar();
                }
                else{
                    if (num==4444){
                       sql.Registrarproducto(n,4444, txtproducto.getText(),Double.valueOf(txtprecio.getText()), Integer.valueOf(txtcantidad.getText()) , fis, longitud);
                       limpiar();
                    }
                    else{
                        if (num==5555){
                           sql.Registrarproducto(n,5555, txtproducto.getText(),Double.valueOf(txtprecio.getText()), Integer.valueOf(txtcantidad.getText()) , fis, longitud);
                           limpiar();
                       }
                        else{
                            if (num==6666) {
                                sql.Registrarproducto(n,6666, txtproducto.getText(),Double.valueOf(txtprecio.getText()), Integer.valueOf(txtcantidad.getText()) , fis, longitud);
                                limpiar();
                            }
                            else{
                                 JOptionPane.showMessageDialog(null, "Selecciona una categoria");
                            }
                        }
                    }
                }
            }
        }
        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " " + e.getMessage());
        }
       
        }
       
          
    }//GEN-LAST:event_btnregistrar1ActionPerformed
    
    int generarcodigo (){
        int codigo=0;
        sql=new Adm_sql();
//        ArrayList<String> lista=  sql.codigos();
//        System.out.println(lista.size());
//        if(lista.size()==0)
//        {
//           codigo=1;   
//        }
//        else{
//             codigo=Integer.parseInt(lista.get(lista.size()-1));
             codigo+=1;
//              int n=Integer.parseInt(txtcodigo.getText().trim(),16);
              System.out.println(codigo);
//        }
//        codigo=Integer.parseInt(lista.get(lista.size()-1).trim())+1;
        try {
            Random rdm=new Random();
        codigo=rdm.nextInt(100);
        int n=0;
        
        ArrayList<String> lista=  sql.codigos();
        for (int i = 0; i < lista.size(); i++) {
            n=Integer.parseInt(lista.get(i));
            if (codigo==n) {
               codigo=Integer.parseInt(lista.get(lista.size()-1).trim())+1;
            }
            
        }
        } catch (Exception e) {
        }
        
        
        return codigo;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int resultado;
        
        Cargarfoto foto=new Cargarfoto();
        FileNameExtensionFilter filtro = 
              new FileNameExtensionFilter("JPG y PNG","jpg","png");
        foto.jfchcargarfoto.setFileFilter(filtro);
        resultado= foto.jfchcargarfoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            
           
            try{
                  fis = new FileInputStream(foto.jfchcargarfoto.getSelectedFile());
                  longitud= (int)foto.jfchcargarfoto.getSelectedFile().length();
                  
                  Image icono=ImageIO.read(foto.jfchcargarfoto.getSelectedFile()).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
                  lblfoto.setIcon(new ImageIcon(icono));
                  lblfoto.updateUI();

            }catch(Exception ex){
               JOptionPane.showMessageDialog(null, 
                "Error abriendo la imagen "+ ex);
           }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Agregar_productos hola=new Agregar_productos();       
      hola.show();
      this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        num=6666;
        btnregistrar1.setText("Registrar");
        lbltitulo.setText("Teconologia");
        //txtcodigo.setText("6666");
        jPanel2.setVisible(true);
        txtcodigo.setText("");
           txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
             int n=generarcodigo();
             txtcodigo.setText(" "+n); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           num=1111;
           llenartabla("1111");
           btnregistrar1.setText("Registrar");
           lbltitulo.setText("Ferreteria");
           jPanel2.setVisible(true);
           txtcodigo.setText("");
           txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
             int n=generarcodigo();
             txtcodigo.setText(""+n); 
          // setTabla(jTable1,"1111");
           //txtcodigo.setText("1111");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          num=2222;
          llenartabla("2222");
          btnregistrar1.setText("Registrar");
          lbltitulo.setText("Carnes y enbutidos");
          jPanel2.setVisible(true);
          txtcodigo.setText("");
           txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
          //txtcodigo.setText("2222");
           int n=generarcodigo();
             txtcodigo.setText(" "+n); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          num=3333;
          llenartabla("3333");
          btnregistrar1.setText("Registrar");
          lbltitulo.setText("Frutas y verduras");
          jPanel2.setVisible(true);
          //txtcodigo.setText("3333");
          txtcodigo.setText("");
           txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
             int n=generarcodigo();
             txtcodigo.setText(" "+n); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        num=4444;
        llenartabla("4444");
        btnregistrar1.setText("Registrar");
        lbltitulo.setText("Bebidas");
        jPanel2.setVisible(true);
        txtcodigo.setText("");
           txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
        //txtcodigo.setText("4444");
         int n=generarcodigo();
             txtcodigo.setText(" "+n); 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        num=5555;
        llenartabla("5555");
        btnregistrar1.setText("Registrar");
        lbltitulo.setText("Jugueteria");
        jPanel2.setVisible(true);
        txtcodigo.setText("");
           txtproducto.setText("");
            txtprecio.setText("");
            txtcantidad.setText("");
        //txtcodigo.setText("5555");
         int n=generarcodigo();
             txtcodigo.setText(" "+n); 
    }//GEN-LAST:event_jButton8ActionPerformed
    
    private void solonumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
    
         if(((c < '0') || (c > '9')) && (c!= KeyEvent.VK_BACK_SPACE) && (c !='.'))
          {
             evt.consume();
          } 
    }
    
    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed

    }//GEN-LAST:event_txtcodigoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        solonumeros(evt);
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyTyped
        sololetras(evt);
    }//GEN-LAST:event_txtproductoKeyTyped

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        solonumeros(evt);
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        solonumeros(evt);
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void btnregistrar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnregistrar1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              btnregistrar1ActionPerformed(null);
          }
    }//GEN-LAST:event_btnregistrar1KeyPressed

    private void txtproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductoActionPerformed
    
    private void sololetras(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
    
         if((c<'a' || c>'z') && (c<'A' || c>'Z')&& (c!=(char)KeyEvent.VK_SPACE))
          {
             evt.consume();
           } 
    }
    
    public void limpiar(){
        try {
            txtcodigo.setText("");
        txtproducto.setText("");
        txtprecio.setText("");
        txtcantidad.setText("");
        
        lblfoto.setIcon(null);

    // **IMPORTANT** to call revalidate() to cause JLabel to resize and be repainted.
      lblfoto.revalidate();
        
        } catch (Exception e) {
        }
        
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnregistrar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblfoto1;
    private javax.swing.JLabel lblfoto2;
    private javax.swing.JLabel lblfoto3;
    private javax.swing.JLabel lblfoto4;
    private javax.swing.JLabel lblfoto6;
    private javax.swing.JLabel lblfoto7;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTable tablita;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables
}
