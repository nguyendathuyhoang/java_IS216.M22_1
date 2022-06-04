/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class DataConnection {
     private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //Khai báo tên db cần làm việc
    private final static String DATABASE_LINK = "jdbc:mysql://localhost:3306/quan_ly_khach_san";
    
    /**
     * Hàm kết nối đến db trong MySQL cần làm việc
     * @return 
     */
    public static Connection Connect()
    {
        //Khai báo đối tượng kết nối
        //Connection conn = null;
            
        try {
 
            //Nạp driver của mysql vào để sử dụng
            Class.forName(JDBC_DRIVER);
            
            //Thực hiện kết nối đến db
            Connection conn = DriverManager.getConnection(DATABASE_LINK, "root", "123456789");
            System.out.println("Kết nối thành công");
            return conn;
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Không tìm thấy driver. Chi tiết: " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.err.println("Không kết nối được đến MySQL. Chi tiết: " + ex.getMessage());
            return null;
        }
        
        //Trả về kết nối
        //return conn;
    }
    
    
}
