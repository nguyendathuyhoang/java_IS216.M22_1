/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Class.Employee;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author DAT
 */
public class StaffDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertEmployee(Employee emp)
    {
        try 
        {
            String update = "insert into nhanvien values ('" +emp.getEmployee_id()+ "', '" +emp.getEmployee_name() + "', '" +emp.getEmployee_diachi()+ "', '" +emp.getEmployee_sdt()+ "', '" +emp.getEmployee_tendn()+ "', '" + emp.getEmployee_mk()+ "');";
            stat = conn.prepareStatement(update);
            stat.executeUpdate();
        }
        catch(Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại!");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void updateEmployee(Employee emp){
        try {
            String update = "update nhanvien set hoten = '" +emp.getEmployee_name()+ "', diachi = '" +emp.getEmployee_diachi()+ "', sodt = '" +emp.getEmployee_sdt()+ "', tendn = '" +emp.getEmployee_tendn()+ "', matkhau = '" +emp.getEmployee_mk()+ "'where manv = '" +emp.getEmployee_id()+ "';";
            stat = conn.prepareStatement(update);
            stat.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại.");
        }
        finally {
            flushStatementOnly();
        }
    }
    
    public Employee getEmployee(String manv){
        Employee emp = new Employee();
        try{
            String remove = "select * from nhanvien where manv = '" +manv+ "';";
            stat = conn.prepareStatement(remove);
            rs = stat.executeQuery();
            if (rs.next()){
                emp.setEmployee_id(rs.getString("manv"));
                emp.setEmployee_name(rs.getString("hoten"));
                emp.setEmployee_diachi(rs.getString("diachi"));
                emp.setEmployee_sdt(rs.getString("sodt"));
                emp.setEmployee_tendn(rs.getString("tendn"));
                emp.setEmployee_mk(rs.getString("matkhau"));
            }
            else {
                emp.setEmployee_id("null");
                JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên.");
            }
        }
        catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Lấy thông tin thất bại.");
        }
        finally {
            flushStatementOnly();
        }
        return emp;
    }
    
    public void removeEmployee(String manv){
        try{
            String remove = "delete from nhanvien where manv = '" + manv + "'";
            stat = conn.prepareStatement(remove);
            stat.execute();
        }
        catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Xóa nhân viên thất bại.");
        }
        finally {
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
