/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Hotel_Management;

import Class.*;
import Database.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Form quản lý phòng
 */
public class RoomPanel extends javax.swing.JFrame {

    /**
     * Creates new form RoomPannel
     */
    
    Room room;
    ResultSet rs;
    RoomDb db = new RoomDb();
    
     
    //Room room = new Room("");
    
    //ResultSet result;
    ArrayList<String> roomClass = new ArrayList<>();
    
    //DatabaseOperation db = new DatabaseOperation();
    //RoomDb roomdb = new RoomDb();
    
    private void ComboRoomType()
    {
        try
        {
            /*String query = "select loaiphong from phong";
            Connection conn = new DataConnection().Connect();
            Statement stat = conn.createStatement();
            rs = stat.executeQuery(query);*/
            ResultSet rs = db.getRoomType();
            
             while(rs.next())
            {   
                roomClass.add(rs.getString("loaiphong"));
                cbType.addItem(rs.getString("loaiphong"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Lỗi");
        }
         
    }
    
    private void roomCreation()
    {
        room = new Room(); // Tạo room
        room.setRoom_price(Integer.parseInt(roomPrice.getText()));
        //room.setRoom_id(roomid.getText()); // Lấy mã room từ textfield
        room.setRoom_type(cbType.getSelectedItem().toString()); // Lấy roomtype từ combo box
     // Lấy giá room từ textfield
        room.setRoom_empty(roomck.isSelected()); // lấy giá trị boolean available từ check box
    }
    
    private void populateRoomTable()
    {
        rs = db.getRoom();
        roomtb.setModel(DbUtils.resultSetToTableModel(rs));
        db.flushAll();
    }
    
    private void displayToTextFields(int row)
    {
        roomId.setText(roomtb.getModel().getValueAt(row, 0)+"");
        roomPrice.setText(roomtb.getModel().getValueAt(row, 1)+"");
        int selectedIndex = getComboSearchIndex(roomtb.getModel().getValueAt(row, 2)+"");  
        // System.out.println(selectedIndex);
        cbType.setSelectedIndex(selectedIndex+1);
        roomck.setSelected((roomtb.getModel().getValueAt(row, 3)+"").equals("true") ? true:false);
    }
    
    private void clearAllFields()
    {
        room = new Room();
        roomPrice.setText("");
        roomId.setText("");

        roomtb.clearSelection();
        roomck.setSelected(false);
        cbType.setSelectedIndex(0);
        roomtb.clearSelection();
        
        roomAdd.setEnabled(true);
        roomEdit.setEnabled(false);
        roomDelete.setEnabled(false);
        
    }
    

    private int getComboSearchIndex(String item)
    {
        for( int i=0;i<roomClass.size() ; i++)
        {
            if(item.equals(roomClass.get(i)))
            {
                return i;
            }
        }
        return -1;
    }

    public RoomPanel() {
        initComponents();
        populateRoomTable();
        //ComboRoomType();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roomId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        roomPrice = new javax.swing.JTextField();
        roomAdd = new javax.swing.JButton();
        roomEdit = new javax.swing.JButton();
        roomDelete = new javax.swing.JButton();
        roomck = new javax.swing.JCheckBox();
        cbType = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomtb = new javax.swing.JTable();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rooms Management");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel5.setBackground(new java.awt.Color(255, 255, 102));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Room_ID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Type");

        roomId.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Price");

        roomAdd.setBackground(new java.awt.Color(51, 255, 204));
        roomAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        roomAdd.setText("Add");
        roomAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomAddActionPerformed(evt);
            }
        });

        roomEdit.setBackground(new java.awt.Color(0, 204, 102));
        roomEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        roomEdit.setText("Edit");
        roomEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomEditActionPerformed(evt);
            }
        });

        roomDelete.setBackground(new java.awt.Color(255, 0, 0));
        roomDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        roomDelete.setText("Delete");
        roomDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomDeleteActionPerformed(evt);
            }
        });

        roomck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roomck.setText("Available");

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomck, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(roomAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(roomEdit)
                                .addGap(28, 28, 28)
                                .addComponent(roomDelete))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbType, javax.swing.GroupLayout.Alignment.LEADING, 0, 144, Short.MAX_VALUE)
                                .addComponent(roomId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roomPrice)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(roomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomck)
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomAdd)
                    .addComponent(roomEdit)
                    .addComponent(roomDelete))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 0, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-reset-48.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        roomtb.setBackground(new java.awt.Color(255, 204, 0));
        roomtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room_ID", "Type", "Price", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        roomtb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomtbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(roomtb);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearAllFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void roomAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomAddActionPerformed
        // TODO add your handling code here:
        try {
//            System.out.println(roomPrice.getText());
            roomCreation();
            db.insertRoom(room);
            populateRoomTable();
            clearAllFields();
        }
        catch(Exception e) {
            System.out.print(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Lỗi");
        }
    }//GEN-LAST:event_roomAddActionPerformed

    private void roomEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomEditActionPerformed
        // TODO add your handling code here:
        roomCreation();
        db.updateRoom(room);
        populateRoomTable();
        clearAllFields();
    }//GEN-LAST:event_roomEditActionPerformed

    private void roomDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomDeleteActionPerformed
        // TODO add your handling code here:
        int roomid = Integer.parseInt(roomId.getText());
        db.deleteRoom(roomid);
        populateRoomTable();
        clearAllFields();
                        
    }//GEN-LAST:event_roomDeleteActionPerformed

    private void roomtbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomtbMouseClicked
        // TODO add your handling code here:
        roomEdit.setEnabled(true);
        roomDelete.setEnabled(true);
        roomAdd.setEnabled(false);
        
        int row = roomtb.getSelectedRow();
        displayToTextFields(row);
        roomCreation();
    }//GEN-LAST:event_roomtbMouseClicked

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTypeActionPerformed

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
            java.util.logging.Logger.getLogger(RoomPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomPanel().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JButton roomAdd;
    private javax.swing.JButton roomDelete;
    private javax.swing.JButton roomEdit;
    private javax.swing.JTextField roomId;
    private javax.swing.JTextField roomPrice;
    private javax.swing.JCheckBox roomck;
    private javax.swing.JTable roomtb;
    // End of variables declaration//GEN-END:variables
}
