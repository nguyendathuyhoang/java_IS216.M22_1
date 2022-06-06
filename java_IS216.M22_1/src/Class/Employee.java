/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Đặng Duy Đạt
 * Lớp employee
 */
public class Employee {
    private String emp_id;
    // Mã nhân viên
    private String emp_name;
    // Họ tên nhân viên
    private String emp_diachi;
    // Địa chỉ
    private String emp_sdt;
    // Số điện thoại
    private String emp_tendn;
    // Tên đăng nhập
    private String emp_matkhau;
    // Mật khẩu

    public String getEmployee_id() {
        return emp_id;
    }

    public void setEmployee_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmployee_name() {
        return emp_name;
    }

    public void setEmployee_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmployee_diachi() {
        return emp_diachi;
    }

    public void setEmployee_diachi(String emp_diachi) {
        this.emp_diachi = emp_diachi;
    }
    
    public String getEmployee_tendn() {
        return emp_tendn;
    }

    public void setEmployee_tendn(String emp_tendn) {
        this.emp_tendn = emp_tendn;
    }
    
    public String getEmployee_mk() {
        return emp_matkhau;
    }

    public void setEmployee_mk(String emp_matkhau) {
        this.emp_matkhau = emp_matkhau;
    }
}
