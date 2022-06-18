/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.Drink;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Kết nối DataBase với bảng thức uống
 */
public class DrinkDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertDrink(Drink drink)
    {
        try
        {
            String insertDrink = "insert into thucuong(tentu,giatu) values ('"+drink.getDrink_name()+"',"+drink.getDrink_price()+")";
            stat =conn.prepareStatement(insertDrink);
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
    
    public ResultSet getDrink()
    {
        try
        {
            String query = "select * from thucuong";
            stat = conn.prepareStatement(query);
            rs = stat.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi!");
        }
        return rs;
    }
    
    public void updateDrink(Drink drink)
    {
        try
        {
            String updateDrink = "update thucuong set tentu = '" + drink.getDrink_name()+"', giatu = "+drink.getDrink_price()+" where matu ='"
                    + drink.getDrink_id()+"'";
            stat = conn.prepareStatement(updateDrink);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Cập nhất thất bại!!!");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void deleteDrink(int drinkId)
    {
        try
        {
            String deleteDrink = "delete from thucuong where matu = '"+drinkId+"'";
            stat = conn.prepareStatement(deleteDrink);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Xóa thất bại!!!");
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
