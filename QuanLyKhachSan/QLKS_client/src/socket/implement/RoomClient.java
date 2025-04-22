package socket.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import entity.Room;
import socket.SocketClient;
import socket.interfaces.IRoom;

public class RoomClient implements IRoom{
    private SocketClient socketClient;
    
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public RoomClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }
    @Override
    public List<Room> getAll() {
         try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_all_room");
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            List<Room> rooms = (List<Room>) in.readObject();
            return rooms;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Room getById(String id) {
        System.out.println("client: getRoomById");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_room");
            writer.println(id);
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            Room room = (Room) in.readObject();
            return room;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean add(Room obj) {
        System.out.println("client: add");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("addRoom");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            System.out.println(obj);
            out.writeObject(obj);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(Room obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Room> findRoomByIDLoaiPhong(String IDLoaiPhong) {
        System.out.println("client: findRoomByIDLoaiPhong");
        try{
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("findRoomByIDLoaiPhong");
            writer.println(IDLoaiPhong);
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            List<Room> rooms = (List<Room>) in.readObject();
            return rooms;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'findRoomByIDLoaiPhong'");
    }

    @Override
    public String to_string(int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'to_string'");
    }

    @Override
    public String getMaPhong() {
        System.out.println("client: getMaPhong");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("getMaPhong");
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            String maPhong = reader.readLine();
            System.out.println("client: maPhong: " + maPhong);
            return maPhong;
        } catch ( IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getMaPhong'");
    }

}
