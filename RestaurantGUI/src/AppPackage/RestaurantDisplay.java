/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ericv
 */
public class RestaurantDisplay extends javax.swing.JFrame {

    private String statement;
    private Param[] params;
    
    private final String TAG = this.getClass().getSimpleName();
    
    /**
     * Creates new form RestaurantDisplay
     */
    public RestaurantDisplay(String statement, Param[] params) {
        this.statement = statement;
        this.params = params;
        initComponents();
        DisplayTable();
    }
    
    private void DisplayTable() { 
        String url = "jdbc:mysql://DESKTOP-Q1NBULV:3306/restaurant_db?zeroDateTimeBehavior=convertToNull";
        String user = "charlie";
        String password = "myPassword";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(statement);
            for (int i = 1; i <= params.length; ++i)
            {
                //update this if you add more types
                switch(params[i - 1].getType())
                {
                    case Param.STRING:
                        pst.setString(i, params[i - 1].getString());
                        break;
                    case Param.INT:
                        pst.setInt(i, params[i - 1].getInt());
                        break;
                    case Param.DOUBLE:
                        pst.setDouble(i, params[i - 1].getDouble());
                        break;
                    case Param.FLOAT:
                        pst.setFloat(i, params[i - 1].getFloat());
                        break;
                }
             
            }
            
            System.out.println(TAG + ": Query: " + pst.toString());

            ResultSet rs = pst.executeQuery();
            
            RestaurantTable.setModel(DbUtils.resultSetToTableModel(rs));

            conn.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,TAG + e);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        restaurantdbPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("restaurantdbPU").createEntityManager();
        restaurantQuery = java.beans.Beans.isDesignTime() ? null : restaurantdbPUEntityManager.createQuery("SELECT r FROM Restaurant r");
        restaurantList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : restaurantQuery.getResultList();
        restaurantQuery1 = java.beans.Beans.isDesignTime() ? null : restaurantdbPUEntityManager.createQuery("SELECT r FROM Restaurant r");
        restaurantList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : restaurantQuery1.getResultList();
        jScrollPane2 = new javax.swing.JScrollPane();
        RestaurantTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, restaurantList1, RestaurantTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${restaurantId}"));
        columnBinding.setColumnName("Restaurant Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${restaurantName}"));
        columnBinding.setColumnName("Restaurant Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${city}"));
        columnBinding.setColumnName("City");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${state}"));
        columnBinding.setColumnName("State");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${phone}"));
        columnBinding.setColumnName("Phone");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${website}"));
        columnBinding.setColumnName("Website");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numOfReviews}"));
        columnBinding.setColumnName("Num Of Reviews");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${averageReview}"));
        columnBinding.setColumnName("Average Review");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${openHoursPerWeek}"));
        columnBinding.setColumnName("Open Hours Per Week");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceRating}"));
        columnBinding.setColumnName("Price Rating");
        columnBinding.setColumnClass(Short.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${menuId}"));
        columnBinding.setColumnName("Menu Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${reviewsId}"));
        columnBinding.setColumnName("Reviews Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane2.setViewportView(RestaurantTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(494, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        bindingGroup.bind();

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
            java.util.logging.Logger.getLogger(RestaurantDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RestaurantDisplay().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RestaurantTable;
    private javax.swing.JScrollPane jScrollPane2;
    private java.util.List<AppPackage.Restaurant> restaurantList;
    private java.util.List<AppPackage.Restaurant> restaurantList1;
    private javax.persistence.Query restaurantQuery;
    private javax.persistence.Query restaurantQuery1;
    private javax.persistence.EntityManager restaurantdbPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
