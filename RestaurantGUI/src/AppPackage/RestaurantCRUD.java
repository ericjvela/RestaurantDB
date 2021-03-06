/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ericv
 */
public class RestaurantCRUD extends javax.swing.JFrame {
    private final String TAG = this.getClass().getSimpleName();
    /**
     * Creates new form RestaurantCRUD
     */
    public RestaurantCRUD() {
        initComponents();
        DisplayTable();
    }
    
    private void DisplayTable() { 
    
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Database.url, Database.user, Database.password);
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM restaurant");

            ResultSet rs = pst.executeQuery();
            
            RestaurantTable.setModel(DbUtils.resultSetToTableModel(rs));
           

            conn.close();
        }
        catch (Exception e)
        {
            Logger.append(e);

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RestaurantTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenuBar = new javax.swing.JMenu();
        ExportAsCSVMenuItem = new javax.swing.JMenuItem();
        EditMenuBar = new javax.swing.JMenu();
        AddRestaurantMenuItem = new javax.swing.JMenuItem();
        UpdateItemsMenuItem = new javax.swing.JMenuItem();
        DeleteRestaurantMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Restaurant Information");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, restaurantList, RestaurantTable);
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

        jScrollPane1.setViewportView(RestaurantTable);

        FileMenuBar.setText("File");

        ExportAsCSVMenuItem.setText("Export Table as CSV");
        FileMenuBar.add(ExportAsCSVMenuItem);

        jMenuBar1.add(FileMenuBar);

        EditMenuBar.setText("Edit");

        AddRestaurantMenuItem.setText("Add Restaurant");
        AddRestaurantMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRestaurantMenuItemActionPerformed(evt);
            }
        });
        EditMenuBar.add(AddRestaurantMenuItem);

        UpdateItemsMenuItem.setText("Update Items");
        EditMenuBar.add(UpdateItemsMenuItem);

        DeleteRestaurantMenuItem.setText("Delete Restaurant");
        EditMenuBar.add(DeleteRestaurantMenuItem);

        jMenuBar1.add(EditMenuBar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel1)
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddRestaurantMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRestaurantMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddRestaurantMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurantCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddRestaurantMenuItem;
    private javax.swing.JMenuItem DeleteRestaurantMenuItem;
    private javax.swing.JMenu EditMenuBar;
    private javax.swing.JMenuItem ExportAsCSVMenuItem;
    private javax.swing.JMenu FileMenuBar;
    private javax.swing.JTable RestaurantTable;
    private javax.swing.JMenuItem UpdateItemsMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<AppPackage.Restaurant> restaurantList;
    private javax.persistence.Query restaurantQuery;
    private javax.persistence.EntityManager restaurantdbPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
