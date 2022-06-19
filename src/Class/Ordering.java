/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Lớp odder
 */
public class Ordering {
    private int id_order; // Mã hóa đơn
    private String user_id; // Mã khách hàng
    private String dayPayment; // Ngày hóa đơn

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDayPayment() {
        return dayPayment;
    }

    public void setDayPayment(String dayPayment) {
        this.dayPayment = dayPayment;
    }
    
    
    
}
