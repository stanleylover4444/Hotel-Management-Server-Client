package socket.interfaces;

import java.util.ArrayList;

import entity.BookRoom;

public interface IBookRoom extends Interfaces<BookRoom, String>{
    public ArrayList<BookRoom> getBookRoomsWithStatus();
}
