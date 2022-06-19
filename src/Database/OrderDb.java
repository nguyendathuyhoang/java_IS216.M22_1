/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;
import javax.swing.AbstractAction.*;
import Class.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Kết nối csdl truy vấn hóa đơn
 */
public class OrderDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertHD (Ordering order)
    {
        try
        {
            String insertOrder = "insert into hoadon(makh, ngayhd) values ("+order.getUser_id()+",'"+order.getDayPayment()+"')";
            stat =conn.prepareStatement(insertOrder);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
        }
        finally
        {
            flushStatementOnly();
        } 
    }
    public void flushAll()
    {
        try
        {
            stat.close();
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println("Closing DataBase!!!");
        }
    }
    private void flushStatementOnly()
    {
        try
        {
            stat.close();
        }
        catch(Exception e)
        {
            System.out.println("Closing DataBase!");
        }
    }
    
    
}
