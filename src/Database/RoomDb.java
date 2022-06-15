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
 *  Kết nối bảng Db với bảng Room
 * 
 */
public class RoomDb {
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertRoom(Room room)
    {
        try
        {
            String insertRoom = "insert into phong(giaphong, loaiphong, available) values("+room.getRoom_price()+
                    ",'"+room.getRoom_type()+"',"+room.isRoom_empty()+")";
            stat = conn.prepareStatement(insertRoom);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Thêm phòng thành công!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi! Thêm phòng thất bại!!!");
            
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public ResultSet getRoom()
    {
        try
        {
            String query = "select * from phong";
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
    
    public ResultSet getRoomType() {
        try {
            String query = "select distinct loaiphong from phong";
            stat = conn.prepareStatement(query);
            rs = stat.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room Type DB Operation");
        }

        return rs;
    }
    
    public void updateRoom(Room room)
    {
        try {
            String updateQuery ="update phong set giaphong = '"
                    +room.getRoom_price()+"', loaiphong ="
                    +room.getRoom_type()+" available= '"
                    +boolToString(room.isRoom_empty())
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            stat = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            stat.execute();

            JOptionPane.showMessageDialog(null, "successfully updated a room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void deleteRoom(int roomId)
    {
        try
        {
            String deleteRoom = "delete from phong where maphong = '"+roomId+"'";
            stat = conn.prepareStatement(deleteRoom);
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
    public String boolToString(boolean value) {
        return value ? "true" : "false";
    }
}
