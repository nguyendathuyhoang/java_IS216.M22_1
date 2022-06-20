/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Hotel_Management;

import Database.DataConnection;
import com.lowagie.text.pdf.PdfWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import java.awt.Font;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author DAT
 */
public class PaymentPanel extends javax.swing.JFrame {
    Pattern gmail = Pattern.compile("@gmail.com$", Pattern.CASE_INSENSITIVE);
    String sdt = "\\d+";
    ArrayList<Integer> mahoadon = new ArrayList<Integer>();
    int makhachhang = 0;
    int giaPhong = 0;
    int tongTien = 0;

    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    /**
     * Creates new form PaymentPanel
     */
    public PaymentPanel() {
        initComponents();
        checkoutSDT.setDocument(new JTextFieldLimit(14));
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkoutEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        checkoutSDT = new javax.swing.JTextField();
        hoadonBTN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hoadonTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tienPhong = new javax.swing.JLabel();
        tongCong = new javax.swing.JLabel();
        thanhtoanBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Checkout and Payment");

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CHECKOUT");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số điện thoại");

        checkoutSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutSDTActionPerformed(evt);
            }
        });

        hoadonBTN.setBackground(new java.awt.Color(255, 255, 51));
        hoadonBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hoadonBTN.setText("Tạo hóa đơn");
        hoadonBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hoadonBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoadonBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkoutSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkoutEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73)
                .addComponent(hoadonBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkoutEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkoutSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hoadonBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Các dịch vụ, sản phẩm đã sử dụng:");

        hoadonTable.setBackground(new java.awt.Color(102, 102, 255));
        hoadonTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hoadonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sàn phẩm, dịch vụ", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hoadonTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiền phòng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền:");

        tienPhong.setBackground(new java.awt.Color(255, 255, 255));
        tienPhong.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tongCong.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        thanhtoanBTN.setBackground(new java.awt.Color(0, 255, 51));
        thanhtoanBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        thanhtoanBTN.setText("Thanh toán");
        thanhtoanBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        thanhtoanBTN.setEnabled(false);
        thanhtoanBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhtoanBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tongCong, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)
                                .addComponent(thanhtoanBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(thanhtoanBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tongCong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(301, 301, 301)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class JTextFieldLimit extends PlainDocument {
        private int limit;
        JTextFieldLimit(int limit) {
           super();
           this.limit = limit;
        }
        JTextFieldLimit(int limit, boolean upper) {
           super();
           this.limit = limit;
        }
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
           if (str == null)
              return;
           if ((getLength() + str.length()) <= limit) {
              super.insertString(offset, str, attr);
           }
        }
    }
    
    public static String formatNumber(int value){
        String pattern = "###,###,###,###";
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(value);
    }
    
    private void checkoutSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkoutSDTActionPerformed

    private void loadChiTietHoaDon(){
        DefaultTableModel cthd_model = (DefaultTableModel)hoadonTable.getModel();
        cthd_model.setRowCount(0);
        mahoadon.removeAll(mahoadon);
        try {
            java.util.Date ngayDen = new java.util.Date();
            java.util.Date ngayDi = new java.util.Date();
            java.util.Date Today = new java.util.Date();
            giaPhong = 0;
            tongTien = 0;

            String query = "select makh from khachhang where email = ? and sodt = ?;";
            stat = conn.prepareStatement(query);
            stat.setString(1, checkoutEmail.getText());
            stat.setString(2, checkoutSDT.getText());
            rs = stat.executeQuery();

            if (rs.next()){
                makhachhang = rs.getInt("makh");
                query = "select * from datphong dp join phong p on dp.maphong = p.maphong where makh = ?";
                stat = conn.prepareStatement(query);
                stat.setInt(1, makhachhang);
                rs = stat.executeQuery();
                if (rs.next()){
                    ngayDen = new java.util.Date(rs.getDate("NGDEN").getTime());
                    ngayDi = new java.util.Date(rs.getDate("NGDI").getTime());
                    giaPhong = rs.getInt("GIAPHONG");
                    query = "select mahd, ngayhd from hoadon where makh = ?;";
                    stat = conn.prepareStatement(query);
                    stat.setString(1, String.valueOf(makhachhang));
                    ResultSet rs2 = stat.executeQuery();

                    while (rs2.next()) {
                        java.util.Date ngayhoadon = new java.util.Date(rs2.getDate("ngayhd").getTime());
                        if (!ngayDen.after(ngayhoadon) && !ngayDi.before(ngayhoadon))
                            mahoadon.add(rs2.getInt("mahd"));
                    }
                    String query3 = null;
                    PreparedStatement PS3 = null;
                    ResultSet rs3 = null;
                    for (int i = 0; i < mahoadon.size(); i++) {
                        query3 = "SELECT MAHD, CT.MADOAN, TENDOAN, GIADOAN, COUNT(CT.MADOAN) AS SOLUONG FROM CTHOADON AS CT JOIN DOAN AS DA ON CT.MADOAN = DA.MADOAN WHERE MAHD = ? GROUP BY CT.MADOAN;";
                        PS3 = conn.prepareStatement(query3);
                        PS3.setInt(1, mahoadon.get(i));
                        rs3 = PS3.executeQuery();
                        while (rs3.next()) {
                            cthd_model.addRow(new Object[] {rs3.getString("TENDOAN"), rs3.getInt("SOLUONG"), formatNumber(rs3.getInt("GIADOAN")*rs3.getInt("SOLUONG"))});
                        }

                        query3 = "SELECT MAHD, CT.MATU, TENTU, GIATU, COUNT(CT.MATU) SOLUONG FROM CTHOADON CT JOIN THUCUONG T ON CT.MATU = T.MATU WHERE MAHD = ? GROUP BY CT.MATU;";
                        PS3 = conn.prepareStatement(query3);
                        PS3.setInt(1, mahoadon.get(i));
                        rs3 = PS3.executeQuery();
                        while (rs3.next()) {
                            cthd_model.addRow(new Object[] {rs3.getString("TENTU"), rs3.getInt("SOLUONG"), formatNumber(rs3.getInt("GIATU")*rs3.getInt("SOLUONG"))});
                        }

                        query3 = "SELECT MAHD, CT.MADV, TENDV, GIADV, COUNT(CT.MADV) SOLUONG FROM CTHOADON CT JOIN DICHVU DV ON CT.MADV = DV.MADV WHERE MAHD = ? GROUP BY CT.MADV;";
                        PS3 = conn.prepareStatement(query3);
                        PS3.setInt(1, mahoadon.get(i));
                        rs3 = PS3.executeQuery();
                        while (rs3.next()) {
                            cthd_model.addRow(new Object[] {rs3.getString("TENDV"), rs3.getInt("SOLUONG"), formatNumber(rs3.getInt("GIADV")*rs3.getInt("SOLUONG"))});
                        }
                    }
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    LocalDate dateDen = LocalDate.parse(df.format(ngayDen), DateTimeFormatter.ISO_LOCAL_DATE);
                    LocalDate dateDi = null;
                    if (ngayDi.after(Today)){
                        dateDi = LocalDate.parse(df.format(Today), DateTimeFormatter.ISO_LOCAL_DATE);
                    }
                    else dateDi = LocalDate.parse(df.format(ngayDi), DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration diff = Duration.between(dateDen.atStartOfDay(), dateDi.atStartOfDay());
                    long diffDays = diff.toDays();
                    giaPhong = ((int)diffDays + 1) * giaPhong;
                    tienPhong.setText(formatNumber(giaPhong) + " VNĐ");

                    for (int i=0; i<hoadonTable.getRowCount(); i++){
                        tongTien = tongTien + Integer.parseInt((hoadonTable.getValueAt(i, 2).toString()).replace(",", ""));
                    }
                    tongTien = tongTien + giaPhong;
                    tongCong.setText(formatNumber(tongTien) + " VNĐ");
                    thanhtoanBTN.setEnabled(true);
                }
                else JOptionPane.showMessageDialog(null, "Không thể tạo hóa đơn\nKhách hàng chưa đặt phòng");
            }
            else JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
        }
        catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Lỗi");
        }

    }

    private void clearForm(){
        thanhtoanBTN.setEnabled(false);
        DefaultTableModel dtm = (DefaultTableModel)hoadonTable.getModel();
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
        hoadonTable.setModel(dtm);
        tienPhong.setText("");
        tongCong.setText("");
    }

    private void hoadonBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoadonBTNActionPerformed
        // TODO add your handling code here:
        if (((checkoutEmail.getText().trim()).equals("")) || ((checkoutSDT.getText().trim()).equals(""))){
            JOptionPane.showMessageDialog(null,"Thông tin còn thiếu");
            clearForm();
        }
        else if (!gmail.matcher(checkoutEmail.getText()).find()){
            JOptionPane.showMessageDialog(null,"E-mail không đúng định dạng");
            clearForm();
        }
        else if (checkoutEmail.getText().length() < 14) {
            JOptionPane.showMessageDialog(null,"E-mail không đúng định dạng");
            clearForm();
        }
        else if (!checkoutSDT.getText().matches(sdt)){
            JOptionPane.showMessageDialog(null,"Số điện thoại không đúng định dạng");
            clearForm();
        }
        else if (checkoutSDT.getText().length() < 5) {
            JOptionPane.showMessageDialog(null,"Số điện thoại không đúng định dạng");
            clearForm();
        }
        else {
            loadChiTietHoaDon();
        }
    }//GEN-LAST:event_hoadonBTNActionPerformed

    private void thanhtoanBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhtoanBTNActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat codeformat = new SimpleDateFormat("ssmmHHddMMyyyy");
        java.util.Date now = new java.util.Date();
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "/hoadon" + codeformat.format(now) + makhachhang + ".pdf"));
            doc.open();
            doc.add(new Paragraph("RECEIPT"));
            doc.add(new Paragraph("Customer ID: " + makhachhang));
            doc.add(new Paragraph("Date: " + formatter.format(now)));
            PdfPTable tbl = new PdfPTable(3);
            tbl.setSpacingBefore(11f);
            tbl.setSpacingAfter(11f);
            tbl.addCell("Product (service) names");
            tbl.addCell("Amount");
            tbl.addCell("Cash");

            for (int i = 0; i < hoadonTable.getRowCount(); i++){
                String name = hoadonTable.getModel().getValueAt(i, 0).toString();
                String soluong = hoadonTable.getModel().getValueAt(i, 1).toString();
                String thanhtien = hoadonTable.getModel().getValueAt(i, 2).toString() + " VND";

                tbl.addCell(name);
                tbl.addCell(soluong);
                tbl.addCell(thanhtien);
            }
            doc.add(tbl);
            doc.add(new Paragraph("Room fee: " + formatNumber(giaPhong) + "VND"));
            doc.add(new Paragraph("Total: " + formatNumber(tongTien) + "VND"));

            String query = "delete from datphong where makh = ?";
            stat = conn.prepareStatement(query);
            stat.setInt(1, makhachhang);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã thanh toán hóa đơn");
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi in hóa đơn");
        }
        doc.close();
        clearForm();
    }//GEN-LAST:event_thanhtoanBTNActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkoutEmail;
    private javax.swing.JTextField checkoutSDT;
    private javax.swing.JButton hoadonBTN;
    private javax.swing.JTable hoadonTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton thanhtoanBTN;
    private javax.swing.JLabel tienPhong;
    private javax.swing.JLabel tongCong;
    // End of variables declaration//GEN-END:variables
}
