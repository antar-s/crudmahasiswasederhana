/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crudmahasiswasederhana.views;

import crudmahasiswasederhana.controller.MahasiswaController;
import crudmahasiswasederhana.interfc.MahasiswaInterface;
import crudmahasiswasederhana.models.Mahasiswa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.lang.Object;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class MahasiswaFrame extends javax.swing.JFrame {

    List<Mahasiswa> record = new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;

    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrame() {
        initComponents();
        mhsServis = new MahasiswaController();

        nimValidasiLabel.setVisible(false);
        namaValidasiLabel.setVisible(false);
        alamatValidasiLabel.setVisible(false);
        mhsServis = new MahasiswaController();
        
        MahasiswaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = MahasiswaTable.getSelectedRow();
                if (row != -1) {
                    isiText();
                }
            }
        });
        this.statusAwal();
    }

    void loadData() {
        try {
            record = mhsServis.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void isiTabel() {
        Object data[][] = new Object[record.size()][3];
        int x = 0;
        for (Mahasiswa mhs : record) {
            data[x][0] = mhs.getNim();
            data[x][1] = mhs.getNama();
            data[x][2] = mhs.getAlamat();
            x++;
        }
        String judul[] = {"nim", "nama", "alamat"};
        MahasiswaTable.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(MahasiswaTable);
    }

    void isiText() {
        Mahasiswa mhs = record.get(row);
        NIMTextField1.setText(mhs.getNim());
        NamaTextField2.setText(mhs.getNama());
        AlamatTextField3.setText(mhs.getAlamat());
    }

    void kosongkanText() {
        NIMTextField1.setText("");
        NamaTextField2.setText("");
        AlamatTextField3.setText("");
    }

    void statusAwal() {
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    void validasiInput(Mahasiswa o){
        if(NIMTextField1.getText().equals("")){
            nimValidasiLabel.setText("NIM-nya diisi mas");
            nimValidasiLabel.setVisible(true);
        }else if(!NIMTextField1.getText().matches("[0-9]*")){
            nimValidasiLabel.setText("NIM-nya harus berisi angka mas");
            nimValidasiLabel.setVisible(true);
        }else if(NIMTextField1.getText().length() < 5){
            nimValidasiLabel.setText("NIM-nya minimal 5 angka mas");
            nimValidasiLabel.setVisible(true);
        }else if(NIMTextField1.getText().length() > 12){
            nimValidasiLabel.setText("NIM-nya maksimal 12 angka mas");
            nimValidasiLabel.setVisible(true);
        }else{
            o.setNim(NIMTextField1.getText());
            nimValidasiLabel.setVisible(false);
        }
        
        if(NamaTextField2.getText().equals("")){
            namaValidasiLabel.setText("Namanya diisi mas");
            namaValidasiLabel.setVisible(true);
        }else{
            o.setNama(NamaTextField2.getText());
            namaValidasiLabel.setVisible(false);
        }
        
        if(AlamatTextField3.getText().equals("")){
            alamatValidasiLabel.setText("Alamatnya diisi mas");
            alamatValidasiLabel.setVisible(true);
        }else{
            o.setAlamat(AlamatTextField3.getText());
            alamatValidasiLabel.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        NIMLabel1 = new javax.swing.JLabel();
        NamaLabel2 = new javax.swing.JLabel();
        AlamatLabel3 = new javax.swing.JLabel();
        NIMTextField1 = new javax.swing.JTextField();
        NamaTextField2 = new javax.swing.JTextField();
        AlamatTextField3 = new javax.swing.JTextField();
        TambahBtn = new javax.swing.JButton();
        UbahBtn = new javax.swing.JButton();
        HapusBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MahasiswaTable = new javax.swing.JTable();
        nimValidasiLabel = new javax.swing.JLabel();
        namaValidasiLabel = new javax.swing.JLabel();
        alamatValidasiLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NIMLabel1.setText("NIM");

        NamaLabel2.setText("Nama");

        AlamatLabel3.setText("Alamat");

        NIMTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIMTextField1ActionPerformed(evt);
            }
        });

        TambahBtn.setText("Tambah");
        TambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahBtnActionPerformed(evt);
            }
        });

        UbahBtn.setText("Ubah");
        UbahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahBtnActionPerformed(evt);
            }
        });

        HapusBtn.setText("Hapus");
        HapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBtnActionPerformed(evt);
            }
        });

        MahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(MahasiswaTable);

        nimValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        nimValidasiLabel.setText("jLabel1");

        namaValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        namaValidasiLabel.setText("jlabel2");

        alamatValidasiLabel.setForeground(new java.awt.Color(255, 0, 0));
        alamatValidasiLabel.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NIMLabel1)
                            .addComponent(NamaLabel2)
                            .addComponent(AlamatLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NIMTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(NamaTextField2)
                                    .addComponent(AlamatTextField3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TambahBtn)
                                    .addComponent(UbahBtn)
                                    .addComponent(HapusBtn))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nimValidasiLabel)
                                    .addComponent(namaValidasiLabel)
                                    .addComponent(alamatValidasiLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIMLabel1)
                    .addComponent(NIMTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nimValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaLabel2)
                    .addComponent(NamaTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UbahBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaValidasiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlamatLabel3)
                    .addComponent(AlamatTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HapusBtn))
                .addGap(1, 1, 1)
                .addComponent(alamatValidasiLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UbahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahBtnActionPerformed
        // TODO add your handling code here:
        try {
            Mahasiswa mhs = new Mahasiswa(null, null, null);
            validasiInput(mhs);
            mhs.setNim(NIMTextField1.getText());
            mhs.setNama(NamaTextField2.getText());
            mhs.setAlamat(AlamatTextField3.getText());
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_UbahBtnActionPerformed

    private void TambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahBtnActionPerformed
        // TODO add your handling code here:
        try {
            Mahasiswa mhs = new Mahasiswa(null, null, null);
            validasiInput(mhs);
            mhs.setNim(NIMTextField1.getText());
            mhs.setNama(NamaTextField2.getText());
            mhs.setAlamat(AlamatTextField3.getText());
            mhsServis.insert(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TambahBtnActionPerformed

    private void HapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBtnActionPerformed
        // TODO add your handling code here:
        try {
            String nim = NIMTextField1.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_HapusBtnActionPerformed

    private void NIMTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIMTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIMTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlamatLabel3;
    private javax.swing.JTextField AlamatTextField3;
    private javax.swing.JButton HapusBtn;
    private javax.swing.JTable MahasiswaTable;
    private javax.swing.JLabel NIMLabel1;
    private javax.swing.JTextField NIMTextField1;
    private javax.swing.JLabel NamaLabel2;
    private javax.swing.JTextField NamaTextField2;
    private javax.swing.JButton TambahBtn;
    private javax.swing.JButton UbahBtn;
    private javax.swing.JLabel alamatValidasiLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namaValidasiLabel;
    private javax.swing.JLabel nimValidasiLabel;
    // End of variables declaration//GEN-END:variables
}
