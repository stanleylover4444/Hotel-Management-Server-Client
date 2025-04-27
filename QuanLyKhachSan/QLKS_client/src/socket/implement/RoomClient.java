package socket.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
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
    public boolean update(Room obj) {
        System.out.println("client: update room");
        try {
            // Send "update_room" command to server
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream(), "UTF-8"), true);
            writer.println("update_room");

            // Send individual room details
            writer.println(obj.getRoomID() != null ? obj.getRoomID() : "");
            writer.println(obj.getRoomName() != null ? obj.getRoomName() : "");
            writer.println(obj.getRoomType() != null ? obj.getRoomType().getRoomTypeID() : "");
            writer.println(obj.getRoomStatusType() != null ? obj.getRoomStatusType().getRoomStatusTypeID() : "");
            writer.println(obj.getDescription() != null ? obj.getDescription() : "");

            // Read response from server
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream(), "UTF-8"));
            boolean result = Boolean.parseBoolean(reader.readLine());
            System.out.println("client: update result: " + result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("client: delete room");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("delete_room"); // Command to indicate delete operation
            writer.println(id); // Send the ID of the room to delete
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            boolean result = Boolean.parseBoolean(reader.readLine());
            System.out.println("client: delete result: " + result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Room> findRoomByIDLoaiPhong(String IDLoaiPhong) {
        System.out.println("client: findRoomByIDLoaiPhong");
        try{
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true, java.nio.charset.StandardCharsets.UTF_8);
            writer.println("findRoomByIDLoaiPhong");
            writer.println(IDLoaiPhong);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream(), "UTF-8"));            List<Room> rooms = (List<Room>) in.readObject();
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
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream(), "UTF-8"), true);
            writer.println("getMaPhong");
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream(), "UTF-8"));            String maPhong = reader.readLine();
            System.out.println("client: maPhong: " + maPhong);
            return maPhong;
        } catch ( IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getMaPhong'");
    }
    @Override
    public boolean add(Room obj) {
        System.out.println("client: add room");
        try {
            // Send "add_room" command to server
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream(), "UTF-8"), true);
            writer.println("add_room");

            // Send individual room details
            writer.println(obj.getRoomID() != null ? obj.getRoomID() : "");
            writer.println(obj.getRoomName() != null ? obj.getRoomName() : "");
            writer.println(obj.getRoomType() != null ? obj.getRoomType().getRoomTypeID() : "");
            writer.println(obj.getRoomStatusType() != null ? obj.getRoomStatusType().getRoomStatusTypeID() : "");
            writer.println(obj.getDescription() != null ? obj.getDescription() : "");

            // Read response from server
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream(), "UTF-8"));
            boolean result = Boolean.parseBoolean(reader.readLine());
            System.out.println("client: add result: " + result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Room> searchRooms(String roomId, String roomType, String roomStatus) {
        System.out.println("client: search rooms (" + roomId + ", " + roomType + ", " + roomStatus + ")");
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream(), java.nio.charset.StandardCharsets.UTF_8), true);
            writer.println("search_rooms");
            writer.println(roomId != null ? roomId : "");
            writer.println(roomType != null ? roomType : "");
            writer.println(roomStatus != null ? roomStatus : "");

            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (List<Room>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'searchRooms'");
    }

}
