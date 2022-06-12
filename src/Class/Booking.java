/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Lớp booking
 */
public class Booking {
    private UserInfo customer;
    // Khách hàng
    ArrayList<Room> rooms;
    // Danh sách các phòng
    
    private int booking_id;
    // Mã đặt phòng
    private long checkinDate;
    // Ngày check-in
    private long checkoutDate;
    // Ngày check-out
    //private String bookingType;
    // Loại phòng đặt
    private int person;
}
