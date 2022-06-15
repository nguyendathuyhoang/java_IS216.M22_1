/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Tạo lớp DataOperation thực hiện các truy vấn đến khách hàng, đặt phòng
 */
public class DataOperation {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
     public ResultSet searchUser(String user) {
        try {
            String query = "select makh,hoten,diachi,email from khachhang where hoten like '%"+user+"%'";
            
            stat = conn.prepareStatement(query);
            rs = stat.executeQuery();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Lỗi search User");
        }
            //System.out.println("fetching something");
        return rs;
    }
    
    public ResultSet searchAnUser(int id)
    {
        try {
            String query = "select * from khachhang where makh="+id;
            
            stat = conn.prepareStatement(query);
            rs = stat.executeQuery();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Lối search An User");
        }
            //System.out.println("fetching something");
        return rs;
    }
    
    public int getCustomerId(UserInfo user)
    { int id = -1;
        try {
            String query = "select makh from khachhang where hoten='"+user.getUser_name()+"' and sodt ='"+user.getUser_phone()+"'";
            
            System.out.println(query +" <<<");
            stat = conn.prepareStatement(query);
            rs = stat.executeQuery();
            //System.out.println(" user id "+ rs.getInt("user_id"));
            
            id = rs.getInt("makh");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning AN user function");
        }
       
        return id;
    }
    
     private void flushStatmentOnly()
    {
        {
                        try
                        {
                            stat.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
    
}
