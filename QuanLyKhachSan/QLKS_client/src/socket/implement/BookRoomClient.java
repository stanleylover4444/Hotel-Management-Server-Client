package socket.implement;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entity.BookRoom;
import socket.SocketClient;
import socket.interfaces.IBookRoom;

public class BookRoomClient implements IBookRoom{
    private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    @SuppressWarnings("resource")
    public BookRoomClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }

    @Override
    public List<BookRoom> getAll() {
        System.out.println("client: getAllBookRoom");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("getAllBookRoom");
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            List<BookRoom> bookRooms = (List<BookRoom>) in.readObject();
            return bookRooms;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public BookRoom getById(String id) {
        System.out.println("client: getBookRoomById");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("getBookRoomById");
            writer.println(id);
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            BookRoom bookRoom = (BookRoom) in.readObject();
            return bookRoom;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean add(BookRoom obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(BookRoom obj) {
        System.out.println("client: updateBookRoom");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("updateBookRoom");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<BookRoom> getBookRoomsWithStatus() {
        System.out.println("client: getBookRoomsWithStatus");
        try{
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("getAlLBookRoomsWithStatus");
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            ArrayList<BookRoom> bookRooms = (ArrayList<BookRoom>) in.readObject();
            return bookRooms;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getBookRoomsWithStatus'");
    }

}
