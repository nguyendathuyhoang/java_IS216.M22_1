/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.UserInfo;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Kết nối Database với bảng khachhang
 */
public class CustomerDb {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public CustomerDb()
    {
        conn = DataConnection.Connect();
    }
      public void insertCustomer(UserInfo user)  {
        try {
            String insertQuery = "insert into khachhang"
                    + "(hoten,diachi,sodt,email)"
                    + " values('"
                    + user.getUser_name()
                    + "','" + user.getUser_address() + "'"
                    + ",'" + user.getUser_phone() + "'"
                    + ",'" + user.getUser_email() + "'"
                    + ")";

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Thêm khách hàng thất bại");
        }
        finally
        {
            flushStatementOnly();
        }
        
        
    }
    
    public void updateCustomer(UserInfo user) {
        // update userInfo set name = 'faysal' ,address = 'dhaka' where user_id = 3
        try {
            String updateQuery = "update khachhang set hoten = '"
                    + user.getUser_name() + "',"
                    + "diachi = '" + user.getUser_address() + "',"
                    + "sodt = '" + user.getUser_phone() + "',"
                    + "email = '" + user.getUser_email() + "' where makh = '"
                    + user.getUser_id() + "'";

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Cập nhật khách hàng thất bại!");
        }
        
        finally
        {
            flushStatementOnly();
        }

    }

    public void deleteCustomer(int userId) throws SQLException {
        try {
            String deleteQuery = "delete from khachhang where makh ='" + userId + "'";
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa khách hàng!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Xóa khách hàng thất bại!");
        }
        finally
        {
            flushStatementOnly();
        }

    }

    public ResultSet getAllCustomer() {
        try {
            String query = "select * from khachhang";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all customer DB Operation");
        }
        

        return result;
    }
     private void flushStatementOnly()
    {
        {
                        try
                        {
                            statement.close();
                            //conn.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
     public void flushAll()
    {
        {
                        try
                        {
                            statement.close();
                            result.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }

    
}
