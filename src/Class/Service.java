/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Lớp service
 */
public class Service {
    private int service_id;
    // Mã dịch vụ khách sạn
    private String service_name;
    // Tên dịch vụ khách sạn
    private int service_price;
    // Giá dịch vụ khách sạn

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_price() {
        return service_price;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }
    
    
}
