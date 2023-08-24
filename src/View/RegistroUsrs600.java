/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import laboclinv01.CustomRenderJList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import laboclinv01.SqlConector;
import laboclinv01.JTextFieldControl;

/**
 *
 * @author Lenovo
 */
public class RegistroUsrs600 extends javax.swing.JFrame {

    int ID = -1; 
    ArrayList<String[]> perms = new ArrayList<>();
    ArrayList<String[]> permsAccept = new ArrayList<>();
    DefaultListModel modelPerms = new DefaultListModel();
    DefaultListModel modelAccept = new DefaultListModel();
    
    
    /**
     * Creates new form RegistroUsrs600
     * @param id
     */
    
    public RegistroUsrs600(int id){
        initComponents();
        ID = id;
        initUI();
        fillData();
    }
    
    public RegistroUsrs600() {
        initComponents();
        initUI();
    }

    private void initUI(){
        recoverPermsDB();
        printPerms();
    }
    
    private void fillData(){
        String query = "SELECT * FROM usuario WHERE USR_ID = " + ID;
        SqlConector.conectar();
        try{
            ResultSet rs = SqlConector.executeQuery(query);
            rs.next();
            txtID.setText(rs.getString(1));
            txtNombres.setText(rs.getString(6));
            txtApePat.setText(rs.getString(7));
            txtApeMat.setText(rs.getString(8));
            txtLogin.setText(rs.getString(2));
            txtPass.setText(rs.getString(3));
            chckState.setSelected(rs.getString(4).equals("0"));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }
    
    private void printPerms(){
        modelPerms = new DefaultListModel();
        modelAccept = new DefaultListModel();
        for (String[] a : perms) {
            modelPerms.addElement(a[1]);
        }
        jList1.setModel(modelPerms);
        for (String[] a : permsAccept) {
            modelAccept.addElement(a[1]);
        }
        jList2.setModel(modelAccept);
        
    }
    
    private void recoverPermsDB(){
        String query;
        if(ID != -1){
            query = "SELECT p.PER_ID, p.PER_Nombre FROM permisos_usuario pu, permiso p WHERE "+
                "pu.PER_ID = p.PER_ID AND pu.PU_Valor = 0 AND USR_ID = " + ID;
        }else{
            query = "SELECT * FROM permiso";
        }
        
        ResultSet rs;
        SqlConector.conectar();
        try{
            rs = SqlConector.executeQuery(query);
            while(rs.next()){
                String[] aux = new String[2];
                for(int i=0;i<2;i++)
                    aux[i] = rs.getString(i+1);
                perms.add(aux);
            }
            if(ID != -1){
                query = "SELECT * FROM permiso WHERE PER_ID not in (SELECT pu.PER_ID FROM permisos_usuario pu, permiso p WHERE p.PER_ID = pu.PER_ID AND pu.USR_ID = 3)";
                rs = SqlConector.executeQuery(query);
                while(rs.next()){
                    String[] aux = new String[2];
                    for(int i=0;i<2;i++){
                        aux[i] = rs.getString(i+1);
                    }
                    perms.add(aux);
                }
                
                query = "SELECT p.PER_ID, p.PER_Nombre FROM permisos_usuario pu, permiso p WHERE "+
                "pu.PER_ID = p.PER_ID AND pu.PU_Valor = 1 AND USR_ID = " + ID;
                rs = SqlConector.executeQuery(query);
                while(rs.next()){
                    String[] aux = new String[2];
                    for(int i=0;i<2;i++){
                        aux[i] = rs.getString(i+1);
                    }
                    permsAccept.add(aux);
                }
            }
            SqlConector.closeConn();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        btnGiveAllPerm = new javax.swing.JButton();
        btnGivePerm = new javax.swing.JButton();
        btnTakePerm = new javax.swing.JButton();
        btnTakeAllPer = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        chckState = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApePat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApeMat = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Usuarios");

        txtLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLoginKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Login:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Password:");

        txtPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jList2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList2);

        btnGiveAllPerm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGiveAllPerm.setText(">>");
        btnGiveAllPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveAllPermActionPerformed(evt);
            }
        });

        btnGivePerm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGivePerm.setText(">");
        btnGivePerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGivePermActionPerformed(evt);
            }
        });

        btnTakePerm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTakePerm.setText("<");
        btnTakePerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakePermActionPerformed(evt);
            }
        });

        btnTakeAllPer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTakeAllPer.setText("<<");
        btnTakeAllPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeAllPerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("ID:");

        txtID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtID.setEnabled(false);

        chckState.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chckState.setSelected(true);
        chckState.setText("Activo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Permisos");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Apellido Paterno:");

        txtApePat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApePat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApePatKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Apellido Materno:");

        txtApeMat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApeMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeMatKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chckState, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGiveAllPerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTakeAllPer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGivePerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTakePerm, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chckState)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGiveAllPerm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGivePerm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTakePerm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTakeAllPer)
                        .addGap(61, 61, 61))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addGap(81, 81, 81))
        );

        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Correct/Save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setHideActionText(true);
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Correct/Close.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setHideActionText(true);
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnGiveAllPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveAllPermActionPerformed
        for(String[] data:perms){
            permsAccept.add(data);
        }
        perms.clear();
        
        printPerms();
    }//GEN-LAST:event_btnGiveAllPermActionPerformed

    private void btnTakeAllPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeAllPerActionPerformed
        for(String[] data:permsAccept){
            perms.add(data);
        }
        permsAccept.clear();
        
        printPerms();
    }//GEN-LAST:event_btnTakeAllPerActionPerformed

    private void btnGivePermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGivePermActionPerformed
        int sel = jList1.getSelectedIndex();
        permsAccept.add(perms.remove(sel));
        printPerms();
    }//GEN-LAST:event_btnGivePermActionPerformed

    private void btnTakePermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakePermActionPerformed
        int sel = jList2.getSelectedIndex();
        perms.add(permsAccept.remove(sel));
        printPerms();
    }//GEN-LAST:event_btnTakePermActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String query;
        Connection con = SqlConector.conectar();
        if(txtID.getText().isEmpty()){
            try{
                query = "INSERT INTO usuario VALUES(0,?,?,?,1,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, txtLogin.getText());
                ps.setString(2, txtPass.getText());
                ps.setInt(3, 0);
                ps.executeUpdate();

                while(!perms.isEmpty()){
                    String data[] = perms.remove(0);
                    String id = data[0];
                    query = "INSERT INTO permisos_usuario VALUES((select USR_ID from "+
                            "usuario ORDER BY USR_ID DESC LIMIT 1), "+id+", NOW(),0)";
                    SqlConector.executeQuery(query);
                }
                while(!permsAccept.isEmpty()){
                    String data[] = permsAccept.remove(0);
                    String id = data[0];
                    query = "INSERT INTO permisos_usuario VALUES((select USR_ID from "+
                            "usuario ORDER BY USR_ID DESC LIMIT 1), "+id+", NOW(),1)";
                    SqlConector.executeQuery(query);
                }
                SqlConector.closeConn();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }else{
            query = "UPDATE usuario SET USR_Nombres = ?, USR_ApePat = ? ,USR_ApeMat = ?,"+
                    "USR_Login = ?, USR_Password = ?, USR_Estado = ? WHERE USR_ID = " + txtID.getText();
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, txtNombres.getText());
                ps.setString(2, txtApePat.getText());
                ps.setString(3, txtApeMat.getText());
                ps.setString(4, txtLogin.getText());
                ps.setString(5, txtPass.getText());
                ps.setInt(6, chckState.isSelected()? 0:1);
                ps.executeUpdate();
                
                String[] aux; 
                while(!perms.isEmpty()){
                    aux = perms.remove(0);
                    query = "UPDATE permisos_usuario SET PU_Valor = 0 WHERE USR_ID "+
                            "= "+ID+" AND PER_ID ="+aux[0]+" AND PU_Valor = 1";
                    ps = con.prepareStatement(query);
                    int res = ps.executeUpdate();
                    System.out.println(res);
                }
                while(!permsAccept.isEmpty()){
                    aux = permsAccept.remove(0);
                    query = "UPDATE permisos_usuario SET PU_Valor = 1 WHERE USR_ID "+
                            "= "+ID+" AND PER_ID ="+aux[0]+" AND PU_Valor = 0";
                    ps = con.prepareStatement(query);
                    ps.executeUpdate();
                }
                SqlConector.closeConn();
                JOptionPane.showMessageDialog(this, "Registro Actualizado");
                this.dispose();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        JTextFieldControl.limitarCaracteres(evt, txtNombres, 50);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApePatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePatKeyTyped
        JTextFieldControl.limitarCaracteres(evt, txtApePat, 35);
    }//GEN-LAST:event_txtApePatKeyTyped

    private void txtApeMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMatKeyTyped
        JTextFieldControl.limitarCaracteres(evt, txtApeMat, 35);
    }//GEN-LAST:event_txtApeMatKeyTyped

    private void txtLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyTyped
        JTextFieldControl.limitarCaracteres(evt, txtLogin, 50);
    }//GEN-LAST:event_txtLoginKeyTyped

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        JTextFieldControl.limitarCaracteres(evt, txtPass, 50);
    }//GEN-LAST:event_txtPassKeyTyped

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
            java.util.logging.Logger.getLogger(RegistroUsrs600.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsrs600.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsrs600.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsrs600.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsrs600().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGiveAllPerm;
    private javax.swing.JButton btnGivePerm;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTakeAllPer;
    private javax.swing.JButton btnTakePerm;
    private javax.swing.JCheckBox chckState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
