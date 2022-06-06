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
    
    public void insertEmployee()
    {
        try 
        {
            
        }
        catch(Exception e){
            System.out.print(e);
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
