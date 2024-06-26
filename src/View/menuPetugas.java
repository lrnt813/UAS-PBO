/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Config.Koneksi;
import Controller.BukuController;
import Controller.PetugasController;
import Model.Buku;
import Model.Petugas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


/**
 *
 * @author laure
 */
public class menuPetugas extends javax.swing.JPanel {

    /**
     * Creates new form menuDashboard
     */
    private PetugasController controller;

    public menuPetugas() {
        initComponents();
        
        Petugas model = new Petugas();
        controller = new PetugasController(model);
        setTableModel(controller.getPetugasTableModel());
        
        delete_Button.setVisible(false);
        cancel_Button.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewpetugas_mainPanel = new javax.swing.JPanel();
        viewpetugas_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        riwayat_Table = new javax.swing.JTable();
        datapetugas_Label = new javax.swing.JLabel();
        menupetugas_Label = new javax.swing.JLabel();
        petugas_Label = new javax.swing.JLabel();
        add_Label = new javax.swing.JLabel();
        add_Button = new javax.swing.JButton();
        delete_Label = new javax.swing.JLabel();
        delete_Button = new javax.swing.JButton();
        cancel_Label = new javax.swing.JLabel();
        cancel_Button = new javax.swing.JButton();
        search_Label = new javax.swing.JLabel();
        search_TextField = new javax.swing.JTextField();
        viewpetugas_addPanel = new javax.swing.JPanel();
        datapetugas_Label1 = new javax.swing.JLabel();
        menupetugas_Label2 = new javax.swing.JLabel();
        petugas_Label1 = new javax.swing.JLabel();
        save_Label = new javax.swing.JLabel();
        save_Button = new javax.swing.JButton();
        batal_Label = new javax.swing.JLabel();
        batal_Button = new javax.swing.JButton();
        id_Label = new javax.swing.JLabel();
        id_TextField = new javax.swing.JTextField();
        nama_Label = new javax.swing.JLabel();
        nama_TextField = new javax.swing.JTextField();
        email_Label = new javax.swing.JLabel();
        email_TextField1 = new javax.swing.JTextField();
        username_Label = new javax.swing.JLabel();
        username_TextField = new javax.swing.JTextField();
        pass_Label = new javax.swing.JLabel();
        pass_PasswordField = new javax.swing.JPasswordField();
        level_Label = new javax.swing.JLabel();
        level_ComboBox = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(561, 480));
        setLayout(new java.awt.CardLayout());

        viewpetugas_mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewpetugas_mainPanel.setMaximumSize(new java.awt.Dimension(561, 480));
        viewpetugas_mainPanel.setMinimumSize(new java.awt.Dimension(561, 480));
        viewpetugas_mainPanel.setLayout(new java.awt.CardLayout());

        viewpetugas_Panel.setBackground(new java.awt.Color(255, 255, 255));
        viewpetugas_Panel.setMaximumSize(new java.awt.Dimension(561, 480));
        viewpetugas_Panel.setMinimumSize(new java.awt.Dimension(561, 480));
        viewpetugas_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        riwayat_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        riwayat_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayat_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(riwayat_Table);

        viewpetugas_Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 520, 310));

        datapetugas_Label.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        datapetugas_Label.setText("Data Petugas");
        viewpetugas_Panel.add(datapetugas_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 11, -1, 35));

        menupetugas_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        menupetugas_Label.setText("Petugas");
        viewpetugas_Panel.add(menupetugas_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        petugas_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gravity-ui_person.png"))); // NOI18N
        viewpetugas_Panel.add(petugas_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 11, -1, -1));

        add_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-park-outline_add.png"))); // NOI18N
        viewpetugas_Panel.add(add_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        add_Button.setBackground(new java.awt.Color(0, 0, 0));
        add_Button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        add_Button.setForeground(new java.awt.Color(255, 255, 255));
        add_Button.setText("       Tambah");
        add_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add_Button.setPreferredSize(new java.awt.Dimension(60, 26));
        add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButtonActionPerformed(evt);
            }
        });
        viewpetugas_Panel.add(add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        delete_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/material-symbols_delete-outline.png"))); // NOI18N
        viewpetugas_Panel.add(delete_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, 30));

        delete_Button.setBackground(new java.awt.Color(255, 0, 0));
        delete_Button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        delete_Button.setForeground(new java.awt.Color(255, 255, 255));
        delete_Button.setText("       Hapus");
        delete_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete_Button.setPreferredSize(new java.awt.Dimension(60, 26));
        delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_ButtonActionPerformed(evt);
            }
        });
        viewpetugas_Panel.add(delete_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, 30));

        cancel_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tabler_clock-cancel.png"))); // NOI18N
        viewpetugas_Panel.add(cancel_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, 30));

        cancel_Button.setBackground(new java.awt.Color(255, 102, 0));
        cancel_Button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        cancel_Button.setForeground(new java.awt.Color(255, 255, 255));
        cancel_Button.setText("       Cancel");
        cancel_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancel_Button.setPreferredSize(new java.awt.Dimension(60, 26));
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });
        viewpetugas_Panel.add(cancel_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 100, 30));

        search_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/material-symbols_search.png"))); // NOI18N
        viewpetugas_Panel.add(search_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, 30));

        search_TextField.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        search_TextField.setText("Search");
        search_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_TextFieldKeyTyped(evt);
            }
        });
        viewpetugas_Panel.add(search_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 520, 30));

        viewpetugas_mainPanel.add(viewpetugas_Panel, "card3");

        viewpetugas_addPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewpetugas_addPanel.setMaximumSize(new java.awt.Dimension(561, 480));
        viewpetugas_addPanel.setMinimumSize(new java.awt.Dimension(561, 480));
        viewpetugas_addPanel.setPreferredSize(new java.awt.Dimension(561, 480));
        viewpetugas_addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datapetugas_Label1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        datapetugas_Label1.setText("Tambah Data Petugas");
        viewpetugas_addPanel.add(datapetugas_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 11, -1, 35));

        menupetugas_Label2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        menupetugas_Label2.setText("Petugas");
        viewpetugas_addPanel.add(menupetugas_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        petugas_Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gravity-ui_person.png"))); // NOI18N
        viewpetugas_addPanel.add(petugas_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 11, -1, -1));

        save_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tdesign_save.png"))); // NOI18N
        viewpetugas_addPanel.add(save_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        save_Button.setBackground(new java.awt.Color(0, 51, 255));
        save_Button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        save_Button.setForeground(new java.awt.Color(255, 255, 255));
        save_Button.setText("       Simpan");
        save_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        save_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save_Button.setPreferredSize(new java.awt.Dimension(60, 26));
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });
        viewpetugas_addPanel.add(save_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 30));

        batal_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tabler_clock-cancel.png"))); // NOI18N
        viewpetugas_addPanel.add(batal_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, 30));

        batal_Button.setBackground(new java.awt.Color(255, 102, 0));
        batal_Button.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        batal_Button.setForeground(new java.awt.Color(255, 255, 255));
        batal_Button.setText("       Batal");
        batal_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        batal_Button.setPreferredSize(new java.awt.Dimension(60, 26));
        batal_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_ButtonActionPerformed(evt);
            }
        });
        viewpetugas_addPanel.add(batal_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 30));

        id_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        id_Label.setText("ID");
        viewpetugas_addPanel.add(id_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        id_TextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        id_TextField.setForeground(new java.awt.Color(102, 102, 102));
        id_TextField.setText("ID Anggota");
        viewpetugas_addPanel.add(id_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 30));

        nama_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        nama_Label.setText("Nama");
        viewpetugas_addPanel.add(nama_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        nama_TextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nama_TextField.setForeground(new java.awt.Color(102, 102, 102));
        nama_TextField.setText("Nama Anggota");
        viewpetugas_addPanel.add(nama_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 240, 30));

        email_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        email_Label.setText("Email");
        viewpetugas_addPanel.add(email_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        email_TextField1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        email_TextField1.setForeground(new java.awt.Color(102, 102, 102));
        email_TextField1.setText("Email");
        viewpetugas_addPanel.add(email_TextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 240, 30));

        username_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        username_Label.setText("Username");
        viewpetugas_addPanel.add(username_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        username_TextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        username_TextField.setForeground(new java.awt.Color(102, 102, 102));
        username_TextField.setText("Username");
        viewpetugas_addPanel.add(username_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 240, 30));

        pass_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        pass_Label.setText("Password");
        viewpetugas_addPanel.add(pass_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        pass_PasswordField.setText("jPasswordField1");
        viewpetugas_addPanel.add(pass_PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 240, 30));

        level_Label.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        level_Label.setText("Level");
        viewpetugas_addPanel.add(level_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        level_ComboBox.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        level_ComboBox.setForeground(new java.awt.Color(102, 102, 102));
        level_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Level", "Admin", "User" }));
        viewpetugas_addPanel.add(level_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 240, 30));

        viewpetugas_mainPanel.add(viewpetugas_addPanel, "card3");

        add(viewpetugas_mainPanel, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        // TODO add your handling code here:
        id_TextField.setEnabled(false);
        viewpetugas_mainPanel.removeAll();
        viewpetugas_mainPanel.add(viewpetugas_addPanel);
        viewpetugas_mainPanel.repaint();
        viewpetugas_mainPanel.revalidate();
        
        id_TextField.setText(controller.generateIDPetugas());
        if(add_Button.getText().equals("      Perbarui")){
            dataTabel();
            save_Button.setText("      Perbarui");
        }
    }//GEN-LAST:event_add_ButtonActionPerformed

    private void delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_ButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = riwayat_Table.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah yakin ingin menghapus data ini ?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            String id = riwayat_Table.getValueAt(selectedRow, 0).toString();
            if (controller.deletePetugas(id)) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
            }
        }
        resetForm();
        delete_Button.setVisible(false);
        cancel_Button.setVisible(false);
        showPanel();
    }//GEN-LAST:event_delete_ButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        // TODO add your handling code here:
        showPanel();
        delete_Button.setVisible(false);
        cancel_Button.setVisible(false);
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        // TODO add your handling code here:
        if (save_Button.getText() == "Tambah") {
            save_Button.setText("       Simpan");
        } else if (save_Button.getText() == "       Simpan") {
            insertData();
        } else if (save_Button.getText() == "      Perbarui") {
            updateData();
        }
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void batal_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_ButtonActionPerformed
        // TODO add your handling code here:
        viewpetugas_mainPanel.removeAll();
        viewpetugas_mainPanel.add(viewpetugas_Panel);
        viewpetugas_mainPanel.repaint();
        viewpetugas_mainPanel.revalidate();
        resetForm();
    }//GEN-LAST:event_batal_ButtonActionPerformed

    private void riwayat_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayat_TableMouseClicked
        // TODO add your handling code here:
        if (add_Button.getText().equals("       Tambah")){
            add_Button.setText("      Perbarui");
            delete_Button.setVisible(true);
            cancel_Button.setVisible(true);
        }    
    }//GEN-LAST:event_riwayat_TableMouseClicked

    private void search_TextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_TextFieldKeyTyped
        // TODO add your handling code here:
        searchData();
    }//GEN-LAST:event_search_TextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_Button;
    private javax.swing.JLabel add_Label;
    private javax.swing.JButton batal_Button;
    private javax.swing.JLabel batal_Label;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JLabel cancel_Label;
    private javax.swing.JLabel datapetugas_Label;
    private javax.swing.JLabel datapetugas_Label1;
    private javax.swing.JButton delete_Button;
    private javax.swing.JLabel delete_Label;
    private javax.swing.JLabel email_Label;
    private javax.swing.JTextField email_TextField1;
    private javax.swing.JLabel id_Label;
    private javax.swing.JTextField id_TextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> level_ComboBox;
    private javax.swing.JLabel level_Label;
    private javax.swing.JLabel menupetugas_Label;
    private javax.swing.JLabel menupetugas_Label2;
    private javax.swing.JLabel nama_Label;
    private javax.swing.JTextField nama_TextField;
    private javax.swing.JLabel pass_Label;
    private javax.swing.JPasswordField pass_PasswordField;
    private javax.swing.JLabel petugas_Label;
    private javax.swing.JLabel petugas_Label1;
    private javax.swing.JTable riwayat_Table;
    private javax.swing.JButton save_Button;
    private javax.swing.JLabel save_Label;
    private javax.swing.JLabel search_Label;
    private javax.swing.JTextField search_TextField;
    private javax.swing.JLabel username_Label;
    private javax.swing.JTextField username_TextField;
    private javax.swing.JPanel viewpetugas_Panel;
    private javax.swing.JPanel viewpetugas_addPanel;
    private javax.swing.JPanel viewpetugas_mainPanel;
    // End of variables declaration//GEN-END:variables

    private void setTableModel(DefaultTableModel model) {
        riwayat_Table.setModel(model);
    }

    private void resetForm() {
        nama_TextField.setText("Nama Anggota");
        username_TextField.setText("Username");
        email_TextField1.setText("Email");
        level_ComboBox.setSelectedItem("Pilih Level");
        pass_PasswordField.setText("");
    }
    
    private void showPanel(){
        viewpetugas_mainPanel.removeAll();
        viewpetugas_mainPanel.add(new menuPetugas());
        viewpetugas_mainPanel.repaint();
        viewpetugas_mainPanel.revalidate();
    }
    
    private void insertData() {
        String idUser = id_TextField.getText();
        String namaUser = nama_TextField.getText();
        String usernameUser = username_TextField.getText();
        String emailUser = email_TextField1.getText();
        String levelUser = level_ComboBox.getSelectedItem().toString();
        String passUser = pass_PasswordField.getText();

        if (idUser.isEmpty() || namaUser.isEmpty() || usernameUser.isEmpty() || emailUser.isEmpty() || level_ComboBox.getSelectedItem().toString().equals("Pilih Level") || passUser.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua Kolom harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (controller.addPetugas(idUser, namaUser, usernameUser, emailUser, levelUser, passUser)) {
            JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
            resetForm();
            delete_Button.setVisible(false);
            cancel_Button.setVisible(false);
            showPanel();
        }
    }

    private void dataTabel() {
        viewpetugas_Panel.setVisible(false);
        viewpetugas_addPanel.setVisible(true);
        
        int row = riwayat_Table.getSelectedRow();
        datapetugas_Label1.setText("Perbarui Data Petugas");
        
        id_TextField.setEnabled(false);
        pass_Label.setVisible(false);
        pass_PasswordField.setVisible(false);
        
        id_TextField.setText(riwayat_Table.getValueAt(row, 0).toString());
        nama_TextField.setText(riwayat_Table.getValueAt(row, 1).toString());
        username_TextField.setText(riwayat_Table.getValueAt(row, 2).toString());
        email_TextField1.setText(riwayat_Table.getValueAt(row, 3).toString());  
        level_ComboBox.setSelectedItem(riwayat_Table.getValueAt(row, 4).toString());
    }

    private void updateData() {
        System.out.println("Metode updateData() dipanggil");
        String idUser = id_TextField.getText();
        String namaUser = nama_TextField.getText();
        String usernameUser = username_TextField.getText();
        String emailUser = email_TextField1.getText();
        String levelUser = level_ComboBox.getSelectedItem().toString();

        if (idUser.isEmpty() || namaUser.isEmpty() || usernameUser.isEmpty() || emailUser.isEmpty() || level_ComboBox.getSelectedItem().toString().equals("Pilih Level")) {
            JOptionPane.showMessageDialog(this, "Semua Kolom harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (controller.updatePetugas(idUser, namaUser, usernameUser, emailUser, levelUser)) {
            JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui");
            resetForm();
            delete_Button.setVisible(false);
            cancel_Button.setVisible(false);
            showPanel();
        }
    }

    private void searchData() {
        DefaultTableModel model = controller.searchPetugas(search_TextField.getText());
        riwayat_Table.setModel(model);
    }
}
