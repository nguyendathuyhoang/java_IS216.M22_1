/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.Booking;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author builong
 */
public class BookingDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertBooking(int makh, int maphong, JDateChooser ngden, JDateChooser ngdi)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String ngDen = dateFormat.format(ngden.getDate());
        String ngDi = dateFormat.format(ngdi.getDate());
        
        System.out.println(ngDen);
        System.out.println(ngDi);

        try
        {
            String insertDatPhong = "insert into DATPHONG(makh,maphong,ngden,ngdi)values("
                    + "" + makh + "," + maphong + "," + "'" + ngDen + "'" +","
                    + "'" + ngDi + "'" + ")";
            
            System.out.print(insertDatPhong);
            
            stat =conn.prepareStatement(insertDatPhong);
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
