/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import laboclinv01.SqlConector;

/**
 *
 * @author Lenovo
 */
public class Principal100 extends javax.swing.JFrame {
    private HojasResultados300 res;
    private Registrar200 edit;
    private int idSelected;
    private int cantPages;
    private int page = 0;
    private String generalQuery = "SELECT * FROM paciente WHERE PAC_oculto = 0 ORDER BY PAC_ID DESC LIMIT " + page*20 + ",20";
    private String mainQuery = "";
    private String varQuery = "";
    private String pageQuery = "SELECT count(1)/20 FROM paciente WHERE PAC_ID LIKE '%%' AND  "+ varQuery +" PAC_oculto = 0";

    /**
     * Creates new form Init
     */
    public Principal100() {
        initComponents();
        setResizable(false);
        btnAdd.setMnemonic(KeyEvent.VK_A);
        btnDel.setMnemonic(KeyEvent.VK_L);
        btnEdit.setMnemonic(KeyEvent.VK_E);
        btnSearch.setMnemonic(KeyEvent.VK_B);
        mostrar();
        patientsTable.changeSelection(0, 0, false, false);
        idSelected = Integer.parseInt((String) patientsTable.getValueAt(0, 0));
    }

    private void mostrar() {
        
        String query;
        SqlConector.conectar();
        try{
            ResultSet rs =  SqlConector.executeQuery(pageQuery);
            rs.next();
            cantPages = rs.getInt(1) + 1;
            SqlConector.closeConn();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        query = "SELECT * FROM paciente WHERE PAC_oculto = 0 ORDER BY PAC_ID DESC LIMIT " + page*20 + ",20";
        jLabel3.setText("Página: " + (page+1) + "/" + cantPages);
        dataTableHandle("QueryReturnRefreshTable",query,new String[8]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        forwBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        btnSearch1 = new javax.swing.JButton();
        btnRes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laboratorio - LABOCLIN");
        setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        btnAdd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDel.setText("Eliminar");
        btnDel.setMaximumSize(new java.awt.Dimension(71, 23));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Pacientes");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Busqueda");

        patientsTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CI", "Nombres", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento", "Edad", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientsTable.setAutoscrolls(false);
        patientsTable.setRowHeight(19);
        patientsTable.getTableHeader().setReorderingAllowed(false);
        patientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientsTable);
        if (patientsTable.getColumnModel().getColumnCount() > 0) {
            patientsTable.getColumnModel().getColumn(0).setResizable(false);
            patientsTable.getColumnModel().getColumn(0).setPreferredWidth(15);
            patientsTable.getColumnModel().getColumn(1).setResizable(false);
            patientsTable.getColumnModel().getColumn(2).setResizable(false);
            patientsTable.getColumnModel().getColumn(3).setResizable(false);
            patientsTable.getColumnModel().getColumn(4).setResizable(false);
            patientsTable.getColumnModel().getColumn(5).setResizable(false);
            patientsTable.getColumnModel().getColumn(6).setResizable(false);
            patientsTable.getColumnModel().getColumn(7).setResizable(false);
            patientsTable.getColumnModel().getColumn(7).setPreferredWidth(7);
        }

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Pagina: ");
        jLabel3.setInheritsPopupMenu(false);

        forwBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-forward-15.png"))); // NOI18N
        forwBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forwBtn.setBorderPainted(false);
        forwBtn.setFocusPainted(false);
        forwBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwBtnActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-double-right-15.png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setIconTextGap(0);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-back-15.png"))); // NOI18N
        backBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backBtn.setBorderPainted(false);
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-double-left-15.png"))); // NOI18N
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        searchTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CI", "Nombres", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento", "Edad", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setAutoscrolls(false);
        searchTable.setRowHeight(19);
        searchTable.setSurrendersFocusOnKeystroke(true);
        searchTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(searchTable);
        if (searchTable.getColumnModel().getColumnCount() > 0) {
            searchTable.getColumnModel().getColumn(0).setResizable(false);
            searchTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            searchTable.getColumnModel().getColumn(1).setResizable(false);
            searchTable.getColumnModel().getColumn(2).setResizable(false);
            searchTable.getColumnModel().getColumn(3).setResizable(false);
            searchTable.getColumnModel().getColumn(4).setResizable(false);
            searchTable.getColumnModel().getColumn(5).setResizable(false);
            searchTable.getColumnModel().getColumn(6).setResizable(false);
            searchTable.getColumnModel().getColumn(7).setResizable(false);
            searchTable.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        btnSearch1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearch1.setText("Limpiar");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        btnRes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRes.setText("Resultados");
        btnRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(backBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(forwBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(forwBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch1)
                        .addGap(56, 56, 56)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnRes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String[] data = new String[8];
        edit = new Registrar200(data);
        editSetVisibleAtClose();
        this.setVisible(false);
        edit.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void editSetVisibleAtClose() {
        edit.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                setVisible(true);
                mostrar();
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,"Confirma que desea salir?","Salir",JOptionPane.YES_NO_OPTION);
            if(confirm == 0) {
                this.dispose();
            }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        String query = "UPDATE paciente SET PAC_oculto = 1 WHERE PAC_ID = " + idSelected;    
        dataTableHandle("SpecifyQueryDelete",query,new String[8]);
        mostrar();          
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String[] data = new String[8];
        String query = "SELECT PAC_ID, PAC_CI, PAC_ApePat, PAC_ApeMat, PAC_Nombres, PAC_FechaNac, PAC_Edad,"+
        "PAC_Sexo FROM paciente WHERE PAC_ID = " + idSelected;
        dataTableHandle("QueryReturnEdit", query, data);
//        DefaultTableModel def = (DefaultTableModel) patientsTable.getModel();
//        String[] data = new String[8];
//        Connection con = SqlConector.conectar();
//        try{
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            rs.next();
//            for (int i = 1; i < def.getColumnCount()+1; i++) {
//                data[i-1] = rs.getString(i);
//            }
//            con.close();
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
        edit = new Registrar200(data);
        editSetVisibleAtClose();
        this.setVisible(false);
        edit.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String[] dataSearch = new String[8];
        DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
        for(int i = 0; i < 8; i++){
            dataSearch[i] = (String) model.getValueAt(0, i);
            if(dataSearch[i] == null){
                dataSearch[i] = "";
            }
            //System.out.println(dataSearch[i]);
        }
        String query = "SELECT PAC_ID,PAC_CI, PAC_Nombres, PAC_ApePat, PAC_ApeMat ,PAC_FechaNac, PAC_Edad,"+
        "PAC_Sexo FROM paciente WHERE PAC_CI LIKE ? AND PAC_Nombres LIKE ? AND PAC_ApePat LIKE ? AND PAC_ApeMat LIKE ? "+
        " AND PAC_FechaNac LIKE ? AND PAC_Edad LIKE ? AND PAC_Sexo LIKE ? AND PAC_oculto = 0 "+
        "ORDER BY PAC_ID DESC LIMIT " + (page*20) + "20" ;
        
        dataTableHandle("SpecifyQuerySearch", query, dataSearch);
        //String query = "SELECT * FROM paciente WHERE "
    }//GEN-LAST:event_btnSearchActionPerformed

    private void forwBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwBtnActionPerformed
        if(page < cantPages-1)  page++;
        mostrar();
    }//GEN-LAST:event_forwBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        if(page > 0)            page--;
        mostrar();
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        page = 0;
        mostrar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        page = cantPages-1;
        mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) searchTable.getModel();
        for(int i = dtm.getColumnCount()-1; i > 0 ;i--){
            dtm.setValueAt("", 0, i);
        }
        mainQuery = ""+generalQuery;
        mostrar();
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResActionPerformed
        res = new HojasResultados300(idSelected);
        resSetVisbleAtClose();
        this.setVisible(false);
        res.setVisible(true);
    }//GEN-LAST:event_btnResActionPerformed

    
    private void resSetVisbleAtClose(){
        res.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }
    private void patientsTableMouseClicked(MouseEvent me) {
        DefaultTableModel def = (DefaultTableModel) patientsTable.getModel();
        JTable target = (JTable) me.getSource();    
        int row = target.getSelectedRow();
        idSelected = Integer.parseInt( (String) def.getValueAt(row, 0));
    }
    
    private void dataTableHandle(String action, String query, String[] data){
        Connection con = SqlConector.conectar();
        DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
        String message;
        try{
            if(action.contains("SpecifyQuery")){
                PreparedStatement ps = con.prepareStatement(query);    
                if(action.contains("Delete")) {
                    int confirmDel = JOptionPane.showConfirmDialog(this, "Confirmar","Confirmar",JOptionPane.YES_NO_OPTION);
                    if(confirmDel == 0) {
                        ps.executeUpdate();
                    }
                }else if(action.contains("Search")){
                    ps.setString(1, "%" + data[1] + "%");
                    ps.setString(2, "%" + data[2] + "%");
                    ps.setString(3, "%" + data[3] + "%");
                    ps.setString(4, "%" + data[4] + "%");
                    ps.setString(5, "%" + data[5] + "%");
                    ps.setString(6, "%" + data[6] + "%");
                    ps.setString(7, "%" + data[7] + "%");
                    
                    ResultSet rs = ps.executeQuery();
                    
                    while(model.getRowCount() > 0){
                        model.removeRow(0);
                    }
                    while(rs.next()){
                        data = new String[8];
                        for(int i=1;i<model.getColumnCount()+1;i++)
                            data[i-1] = rs.getString(i);
                        model.addRow(data);
                    }
                }
            }
            if(action.contains("QueryReturn")){
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(action.contains("Pages")){
                    rs.next();
                    cantPages = rs.getInt(1) + 1;
                    
                }
                if(action.contains("Edit")){
                    while(rs.next()){
                        for (int i = 1; i < model.getColumnCount()+1; i++) {
                            data[i-1] = rs.getString(i);
                        }
                    }
                }
                if(action.contains("RefreshTable")){
                    while(model.getRowCount() > 0){
                        model.removeRow(0);
                    }
                    while(rs.next()){
                        for(int i = 0; i < 8 ; i++){
                            data[i] = rs.getString(i+1);
                        }
                        data[7] = rs.getString(8);
                        model.addRow(data);
                    }
                }
            }
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal100.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal100().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton forwBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable patientsTable;
    private javax.swing.JTable searchTable;
    // End of variables declaration//GEN-END:variables
}
