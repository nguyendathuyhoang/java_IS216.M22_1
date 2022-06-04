/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.Service;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Kết nối DataBase với bảng dịch vụ
 */
public class ServiceDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertService(Service service)
    {
        try
        {
            String insertService = "insert into dichvu(madv,tendv,giadv) values ('"+service.getService_id()+"','"+service.getService_name()+"',"+service.getService_price()+")";
            stat =conn.prepareStatement(insertService);
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
    
    public ResultSet getService()
    {
        try
        {
            String query = "select * from dichvu";
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
    
    public void updateService(Service service)
    {
        try
        {
            String updateService = "update dichvu set tendv = '" + service.getService_name()+"', giadv = "+service.getService_price()+" where madv ='"
                    + service.getService_id()+"'";
            stat = conn.prepareStatement(updateService);
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
    
    public void deleteService(String serviceId)
    {
        try
        {
            String deleteService = "delete from dichvu where madv = '"+serviceId+"'";
            stat = conn.prepareStatement(deleteService);
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
