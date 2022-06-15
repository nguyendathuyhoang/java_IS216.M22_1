/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import Class.Food;
import java.sql.*;
import javax.swing.AbstractAction.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Kết nối Database bảng đồ ăn
 */
public class FoodDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertFood(Food food)
    {
        try
        {
            String insertFood = "insert into doan(tendoan,giadoan) values ('"+food.getFood_name()+"',"+food.getFood_price()+")";
            stat =conn.prepareStatement(insertFood);
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
    
    public ResultSet getFood()
    {
        try
        {
            String query = "select * from doan";
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
    
    public void updateFood(Food food)
    {
        try
        {
            String updateFood = "update doan set tendoan = '" + food.getFood_name()+"', giadoan = "+food.getFood_price()+" where madoan ='"
                    + food.getFood_id()+"'";
            stat = conn.prepareStatement(updateFood);
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
    
    public void deleteFood(int foodId)
    {
        try
        {
            String deleteFood = "delete from doan where madoan = '"+foodId+"'";
            stat = conn.prepareStatement(deleteFood);
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
