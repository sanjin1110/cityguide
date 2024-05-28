/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.*;
import model.Hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Hotel;


/**
 *
 * @author user
 */
public class OtherHotel extends javax.swing.JFrame {

    /**
     * Creates new form OtherHeritage
     */
    public OtherHotel() {
        initComponents();
        show_hot();
        setResizable(false);
        setTitle("Other Hotels");
        setDefaultCloseOperation(OtherHotel.DISPOSE_ON_CLOSE);

    }
    public ArrayList<Hotel> resList(){
         ArrayList<Hotel> resList = new ArrayList<>();
         try {
//            
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cityguide";
//            // create the connection object
            
            Connection con = DriverManager.getConnection(url,username,password);
            
            String query1 = "SELECT * FROM sanjin_hotel";
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Hotel detailhot;
            while(rs.next()){
                detailhot = new Hotel(rs.getInt("rID"),rs.getString("rName"),rs.getString("rLocation"),rs.getString("rPhone"),rs.getString("rEmail"),rs.getString("openTime"));
                resList.add(detailhot);
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
         return resList;
    }
    public void show_hot(){
        ArrayList<Hotel> list = resList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Rest.getModel();
        Object[] row = new Object[6];
        for(int i =0; i<list.size();i++){
            row[0] = list.get(i).getrID();
            row[1] = list.get(i).getrName();
            row[2] = list.get(i).getrLocation();
            row[3] = list.get(i).getrPhone();
            row[4] = list.get(i).getrEmail();
            row[5] = list.get(i).getopenTime();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Rest = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Display_Rest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "location", "phone", "email", "opentime"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display_Rest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(OtherHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OtherHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OtherHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OtherHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtherHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Rest;
    // End of variables declaration//GEN-END:variables
}
