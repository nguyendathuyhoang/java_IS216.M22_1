/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Hotel_Management;

import Class.*;
import Database.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Form order đồ ăn, thức uống, dịch vụ
 */
public class OrderPanel extends javax.swing.JFrame {

    /**
     * Creates new form OrderPanel
     */
    //DefaultTableModel itemtb;
    //DefaultTableModel model = (DefaultTableModel) itemtb.getModel();
    Ordering order = new Ordering();
    FoodDb fooddb = new FoodDb();
    DrinkDb drinkdb = new DrinkDb();
    ServiceDb servicedb = new ServiceDb();
    OrderDb orderdb = new OrderDb();
    ResultSet rs;
    
    private void orderCreation()
    {
        Ordering order = new Ordering(); // Tạo order
        order.setUser_id(customId.getText()); // Lấy tên makh từ textfield
        order.setDayPayment(dayCheckout.getText()); // Lấy giá order từ textfield
        try {
            //order.setId_order(Integer.parseInt(bookingId.getText()));
        } catch (Exception ex) {
            order.setId_order(-1);
        }
    }
    
    //DefaultTableModel model = (DefaultTableModel) itemtb.getModel();
    /*private void populateAllTable()
    {
        ResultSet rsorder = orderdb.getFood();
        ordFoodtb.setModel(DbUtils.resultSetToTableModel(rsorder));
        
        ResultSet rsdrink = drinkdb.getDrink();
        ordDrinktb.setModel(DbUtils.resultSetToTableModel(rsdrink));
        
        ResultSet rsservice = servicedb.getService();
        ordServicetb.setModel(DbUtils.resultSetToTableModel(rsservice));
        
        //db.flushAll();
    }*/
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel) itemtb.getModel();
        model.addRow(dataRow);
    }
    
    private void emptyField()
    {
        bookingId.setText("");
        customId.setText("");
        customName.setText("");
        roomId.setText("");
        roomType.setText("");
        dayCheckin.setText("");
        dayCheckout.setText("");
    }
    
    private void disableOrdering(){
        btFood.setEnabled(false);
        btDrink.setEnabled(false);
        btService.setEnabled(false);
        itemtb.setEnabled(false);
        btclear.setEnabled(false);
        ordbt.setEnabled(false);
    }
    
    private void enableOrdering(){
        btFood.setEnabled(true);
        btDrink.setEnabled(true);
        btService.setEnabled(true);
        itemtb.setEnabled(true);
        btclear.setEnabled(true);
        ordbt.setEnabled(true);
    }
    
    private void setHiddenColumns(){
        itemtb.getColumnModel().getColumn(2).setWidth(0);
        itemtb.getColumnModel().getColumn(2).setMinWidth(0);
        itemtb.getColumnModel().getColumn(2).setMaxWidth(0);
        itemtb.getColumnModel().getColumn(3).setWidth(0);
        itemtb.getColumnModel().getColumn(3).setMinWidth(0);
        itemtb.getColumnModel().getColumn(3).setMaxWidth(0);
        itemtb.getColumnModel().getColumn(4).setWidth(0);
        itemtb.getColumnModel().getColumn(4).setMinWidth(0);
        itemtb.getColumnModel().getColumn(4).setMaxWidth(0);
        itemtb.getColumnModel().getColumn(5).setWidth(0);
        itemtb.getColumnModel().getColumn(5).setMinWidth(0);
        itemtb.getColumnModel().getColumn(5).setMaxWidth(0);
    }
    
    public OrderPanel() {
        initComponents();
        setHiddenColumns();
        disableOrdering();
        //populateAllTable();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        itemtb = new javax.swing.JTable();
        ordbt = new javax.swing.JButton();
        resetbt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bookingId = new javax.swing.JTextField();
        btFood = new javax.swing.JButton();
        btDrink = new javax.swing.JButton();
        btService = new javax.swing.JButton();
        btclear = new javax.swing.JButton();
        customId = new javax.swing.JLabel();
        customName = new javax.swing.JLabel();
        roomId = new javax.swing.JLabel();
        roomType = new javax.swing.JLabel();
        dayCheckin = new javax.swing.JLabel();
        dayCheckout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order");

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Customer ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Room ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Room Type");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Checkin Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Checkout Date");

        itemtb.setBackground(new java.awt.Color(0, 153, 153));
        itemtb.setForeground(new java.awt.Color(255, 255, 255));
        itemtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Food", "Drink", "Service", "Item ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemtb.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(itemtb);
        if (itemtb.getColumnModel().getColumnCount() > 0) {
            itemtb.getColumnModel().getColumn(2).setResizable(false);
            itemtb.getColumnModel().getColumn(2).setPreferredWidth(0);
            itemtb.getColumnModel().getColumn(3).setResizable(false);
            itemtb.getColumnModel().getColumn(3).setPreferredWidth(0);
            itemtb.getColumnModel().getColumn(4).setResizable(false);
            itemtb.getColumnModel().getColumn(4).setPreferredWidth(0);
            itemtb.getColumnModel().getColumn(5).setResizable(false);
            itemtb.getColumnModel().getColumn(5).setPreferredWidth(0);
        }

        ordbt.setBackground(new java.awt.Color(255, 51, 51));
        ordbt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ordbt.setText("Order");
        ordbt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ordbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordbtActionPerformed(evt);
            }
        });

        resetbt.setBackground(new java.awt.Color(51, 255, 0));
        resetbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-reset-48.png"))); // NOI18N
        resetbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Booking ID");

        bookingId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingIdActionPerformed(evt);
            }
        });

        btFood.setBackground(new java.awt.Color(255, 51, 255));
        btFood.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btFood.setText("Food");
        btFood.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFoodActionPerformed(evt);
            }
        });

        btDrink.setBackground(new java.awt.Color(51, 153, 255));
        btDrink.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btDrink.setText("Drink");
        btDrink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDrinkActionPerformed(evt);
            }
        });

        btService.setBackground(new java.awt.Color(255, 102, 102));
        btService.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btService.setText("Service");
        btService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServiceActionPerformed(evt);
            }
        });

        btclear.setBackground(new java.awt.Color(255, 255, 0));
        btclear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btclear.setText("Remove Choice");
        btclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btclearActionPerformed(evt);
            }
        });

        customId.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        customName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        roomId.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        roomType.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dayCheckin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dayCheckout.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bookingId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(btFood, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(dayCheckout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(dayCheckin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(roomType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(213, 213, 213)
                                        .addComponent(btclear))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(customName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btService))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(ordbt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(resetbt)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(bookingId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(customId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(customName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(roomType, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayCheckin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btFood)
                                        .addGap(18, 18, 18)
                                        .addComponent(btDrink)
                                        .addGap(18, 18, 18)
                                        .addComponent(btService))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(ordbt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btclear)
                        .addGap(88, 88, 88)))
                .addComponent(resetbt)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) itemtb.getModel();
        int allRow = itemtb.getRowCount();
        
        for (int i=allRow-1;i>=0;i--)
        {
            model.removeRow(i);
        }
        emptyField();
        disableOrdering();
    }//GEN-LAST:event_resetbtActionPerformed

    private void btFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFoodActionPerformed
        // TODO add your handling code here:
        OrderFood ordF  = new OrderFood();
        ordF.setVisible(true);
        ordF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Khi tắt frame sau cùng thì frame trc đó vẫn giữ nguyên
    }//GEN-LAST:event_btFoodActionPerformed

    private void btDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDrinkActionPerformed
        // TODO add your handling code here:
        OrderDrink ordD  = new OrderDrink();
        ordD.setVisible(true);
        ordD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Khi tắt frame sau cùng thì frame trc đó vẫn giữ nguyên
    }//GEN-LAST:event_btDrinkActionPerformed

    private void btServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServiceActionPerformed
        // TODO add your handling code here:
        OrderService ordS  = new OrderService();
        ordS.setVisible(true);
        ordS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btServiceActionPerformed

    private void btclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btclearActionPerformed
        // TODO add your handling code here:
        if(itemtb.getSelectedRow() != -1) {
               // remove selected row from the model
               DefaultTableModel model = (DefaultTableModel) itemtb.getModel();
               model.removeRow(itemtb.getSelectedRow());
               //JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }
    }//GEN-LAST:event_btclearActionPerformed

    private void ordbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordbtActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Thực hiện giao dịch thành công!");
        DefaultTableModel model = (DefaultTableModel) itemtb.getModel();
        System.out.println(model.getValueAt(0, 2));
        int rowCount = model.getRowCount();
        java.util.Date today = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int mahoadon = 0;
        
        Connection conn = new DataConnection().Connect();
        try
        {
            String insertOrder = "insert into hoadon(makh, ngayhd) values (?, ?)";
            PreparedStatement stat =conn.prepareStatement(insertOrder);
            stat.setInt(1, Integer.parseInt(customId.getText()));
            stat.setString(2, df.format(today));
            stat.executeUpdate();
            
            String getMaHD = "select mahd from hoadon where makh = ? and ngayhd = ?";
            stat = conn.prepareStatement(getMaHD);
            stat.setInt(1, Integer.parseInt(customId.getText()));
            stat.setString(2, df.format(today));
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                mahoadon = rs.getInt("mahd");
            }
            System.out.println("Got ma hoa don");
            String addChiTiet;
            for (int i = 0; i<rowCount; i++){
                if ((boolean)model.getValueAt(i, 2))
                    addChiTiet = "insert into cthoadon (mahd, madoan) values(?, ?)";
                else if ((boolean)model.getValueAt(i, 3))
                    addChiTiet = "insert into cthoadon (mahd, matu) values(?, ?)";
                else
                    addChiTiet = "insert into cthoadon (mahd, madv) values(?, ?)";
                
                for (int j = 0; j < Integer.parseInt(model.getValueAt(i, 1).toString()); j++){
                    System.out.println("Working on " + j);
                    stat = conn.prepareStatement(addChiTiet);
                    stat.setInt(1, mahoadon);
                    stat.setInt(2, (int)model.getValueAt(i, 5));
                    stat.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Đã đặt đơn hàng");
            model.setRowCount(0);
            itemtb.setModel(model);
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
        }
            
    }//GEN-LAST:event_ordbtActionPerformed

    private void bookingIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingIdActionPerformed
        // TODO add your handling code here:
        try
        {
            String query = "select * from datphong d, khachhang k, phong p where d.makh = k.makh and d.maphong = p.maphong and madat = '"
                    + bookingId.getText()+"'";
            Connection conn = new DataConnection().Connect();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            
            if (rs.next())
            {
                customId.setText(rs.getString("makh"));
                customName.setText(rs.getString("hoten"));
                roomId.setText(rs.getString("maphong"));
                roomType.setText(rs.getString("loaiphong"));
                dayCheckin.setText(rs.getString("ngden"));
                dayCheckout.setText(rs.getString("ngdi"));
                enableOrdering();
            }
            else {
                JOptionPane.showMessageDialog(null, "Mã đặt phòng không tồn tại");
                emptyField();
                disableOrdering();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Truy vấn thất bại!");
        }
    }//GEN-LAST:event_bookingIdActionPerformed

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
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookingId;
    private javax.swing.JButton btDrink;
    private javax.swing.JButton btFood;
    private javax.swing.JButton btService;
    private javax.swing.JButton btclear;
    private javax.swing.JLabel customId;
    private javax.swing.JLabel customName;
    private javax.swing.JLabel dayCheckin;
    private javax.swing.JLabel dayCheckout;
    private static javax.swing.JTable itemtb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton ordbt;
    private javax.swing.JButton resetbt;
    private javax.swing.JLabel roomId;
    private javax.swing.JLabel roomType;
    // End of variables declaration//GEN-END:variables
}
