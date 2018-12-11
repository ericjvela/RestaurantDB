/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author itsch
 */
public class RestaurantAddFeatures extends javax.swing.JFrame {

    private final String TAG = "RestaurantAddFeatures";
    /**
     * Creates new form RestaurantAddFeatures
     */
    public RestaurantAddFeatures() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        RemoveButton = new javax.swing.JButton();
        OK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Add Features");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDER_DELIVERY", "ORDER_TAKEOUT", "SERVES_ALCOHOL", "KID_FRIENDLY", "PET_FRIENDLY", "INDOOR, OUTDOOR", "TAKES_RESERVATIONS", "OFFERS_DEALS", "ACCEPTS_CREDIT_CARDS", "GOOD_FOR_KIDS", "GOOD_FOR_GROUPS", "WAITER_SERVICE", "WHEELCHAIR_ACCESSIBLE", "DOGS_ALLOWED", "OFFERS_MILITARY_DISCOUNT", "FULL_BAR, HAPPY_HOUR", "SERVES_BREAKFAST", "SERVES_BRUNCH", "SERVES_LUNCH", "SERVES_DINNER", "SERVES_DESSERT", "HAS_LIVE_MUSIC", "STREET_PARKING", "GARAGE_PARKING", "VALET_PARKING", "PRIVATE_LOT", "FREE_WIFI", "ALLOWS_SMOKING" }));

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDER_DELIVERY", "ORDER_TAKEOUT", "SERVES_ALCOHOL", "KID_FRIENDLY", "PET_FRIENDLY", "INDOOR, OUTDOOR", "TAKES_RESERVATIONS", "OFFERS_DEALS", "ACCEPTS_CREDIT_CARDS", "GOOD_FOR_KIDS", "GOOD_FOR_GROUPS", "WAITER_SERVICE", "WHEELCHAIR_ACCESSIBLE", "DOGS_ALLOWED", "OFFERS_MILITARY_DISCOUNT", "FULL_BAR, HAPPY_HOUR", "SERVES_BREAKFAST", "SERVES_BRUNCH", "SERVES_LUNCH", "SERVES_DINNER", "SERVES_DESSERT", "HAS_LIVE_MUSIC", "STREET_PARKING", "GARAGE_PARKING", "VALET_PARKING", "PRIVATE_LOT", "FREE_WIFI", "ALLOWS_SMOKING" }));

        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jLabel2.setText("Restaurant ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(idField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RemoveButton)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        
        
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Database.url, Database.user, Database.password);
            
            conn.setAutoCommit(false);
            
            PreparedStatement pst = conn.prepareStatement
            ("UPDATE features SET " + jComboBox1.getSelectedItem().toString() +  " = ? WHERE RESTAURANT_ID = ?");
            
            pst.setString(1, "Y");
            pst.setInt(2, Integer.valueOf(idField.getText()));
                    
            System.out.println(TAG + ": " + pst);
            pst.executeUpdate();
            

            conn.commit();
            conn.close();
            JOptionPane.showMessageDialog(null, "Updated Successfully.");
        }
        catch (SQLException se)
        {
            try{
                if(conn != null)
                    conn.rollback();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            JOptionPane.showMessageDialog(null,TAG + se);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,TAG + e);
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        // TODO add your handling code here:
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Database.url, Database.user, Database.password);
            PreparedStatement pst = conn.prepareStatement
            ("UPDATE features SET " + jComboBox2.getSelectedItem().toString() +  " = ? WHERE RESTAURANT_ID = ?");
            
            pst.setString(1, "N");
            pst.setInt(2, Integer.valueOf(idField.getText()));
                    
            System.out.println(TAG + ": " + pst);
            pst.executeUpdate();
            

            conn.close();
            JOptionPane.showMessageDialog(null, "Updated Successfully.");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,TAG + e);
        }
                    

    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_OKActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurantAddFeatures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantAddFeatures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantAddFeatures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantAddFeatures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantAddFeatures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton OK;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField idField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
