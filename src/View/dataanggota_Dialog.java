/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.AnggotaDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laure
 */
public class dataanggota_Dialog extends javax.swing.JDialog {

    /**
     * Creates new form dataanggota_Dialog
     */
    int xx, xy;
    private String idAnggota;
    private AnggotaDialog anggotaModel;

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public String getEmailAnggota() {
        return emailAnggota;
    }

    public String getTeleponAnggota() {
        return teleponAnggota;
    }
    
    private String namaAnggota;
    private String emailAnggota;
    private String teleponAnggota;
    
    public dataanggota_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        anggotaModel = new AnggotaDialog();
        setTableModel(anggotaModel.getAnggotaTableModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewanggota_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        riwayat_Table = new javax.swing.JTable();
        dataanggota_Label = new javax.swing.JLabel();
        anggota_Label = new javax.swing.JLabel();
        search_Label = new javax.swing.JLabel();
        search_TextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        viewanggota_Panel.setBackground(new java.awt.Color(255, 255, 255));
        viewanggota_Panel.setMaximumSize(new java.awt.Dimension(561, 480));
        viewanggota_Panel.setMinimumSize(new java.awt.Dimension(561, 480));
        viewanggota_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        viewanggota_Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 520, 360));

        dataanggota_Label.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dataanggota_Label.setText("Data Anggota");
        viewanggota_Panel.add(dataanggota_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 11, -1, 35));

        anggota_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lets-icons_group (1).png"))); // NOI18N
        viewanggota_Panel.add(anggota_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 11, -1, -1));

        search_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/material-symbols_search.png"))); // NOI18N
        viewanggota_Panel.add(search_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, 30));

        search_TextField.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        search_TextField.setText("Search");
        search_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_TextFieldKeyReleased(evt);
            }
        });
        viewanggota_Panel.add(search_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 520, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(viewanggota_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(viewanggota_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx , y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void search_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_TextFieldKeyReleased
        // TODO add your handling code here:
        searchData();
    }//GEN-LAST:event_search_TextFieldKeyReleased

    private void riwayat_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayat_TableMouseClicked
        // TODO add your handling code here:
        pilihData();
    }//GEN-LAST:event_riwayat_TableMouseClicked

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
            java.util.logging.Logger.getLogger(dataanggota_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataanggota_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataanggota_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataanggota_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dataanggota_Dialog dialog = new dataanggota_Dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anggota_Label;
    private javax.swing.JLabel dataanggota_Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable riwayat_Table;
    private javax.swing.JLabel search_Label;
    private javax.swing.JTextField search_TextField;
    private javax.swing.JPanel viewanggota_Panel;
    // End of variables declaration//GEN-END:variables

    private void setTableModel(DefaultTableModel model) {
        riwayat_Table.setModel(model);
    }
    
    private void searchData() {
        DefaultTableModel model = anggotaModel.searchAnggota(search_TextField.getText());
        riwayat_Table.setModel(model);
    }
    
    private void pilihData(){
        int row = riwayat_Table.getSelectedRow();
        
        idAnggota = riwayat_Table.getValueAt(row, 0).toString();
        namaAnggota = riwayat_Table.getValueAt(row, 1).toString();
        emailAnggota = riwayat_Table.getValueAt(row, 2).toString();
        teleponAnggota = riwayat_Table.getValueAt(row, 3).toString();
        
        dispose();
    }
}
