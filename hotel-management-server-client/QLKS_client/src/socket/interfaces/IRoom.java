package socket.interfaces;

import java.util.List;

import entity.Room;

public interface IRoom extends Interfaces<Room, String>{
    List<Room> findRoomByIDLoaiPhong(String IDLoaiPhong);
    String to_string(int x);
    String getMaPhong();
}
