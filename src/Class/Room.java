/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Nguyễn Đạt Huy Hoàng
 * Lớp Room
 */
public class Room {
    private int room_id;
    private String room_type;
    private long room_price;
    private boolean room_empty;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public long getRoom_price() {
        return room_price;
    }

    public void setRoom_price(long room_price) {
        this.room_price = room_price;
    }

    public boolean isRoom_empty() {
        return room_empty;
    }

    public void setRoom_empty(boolean room_empty) {
        this.room_empty = room_empty;
    }

    
    
}
