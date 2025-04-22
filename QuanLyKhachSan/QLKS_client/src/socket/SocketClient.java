package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import entity.BookRoom;
import entity.Employee;
import entity.Order;
import entity.Room;
import entity.RoomStatusType;

public class SocketClient {
    private static final String HOST = "localhost";
    private static final int PORT = 31000;
    private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
    private SocketClient instance = null;
    
    public SocketClient(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public SocketClient getInstance() {
        if (instance == null) {
            instance = new SocketClient(HOST, PORT);
        }
        return instance;
    }
    
    public Socket getSocket() {
        return socket;
    }

    
    public Employee getEmployee(String username) throws ClassNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("get_employee");
            writer.println(username);

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Employee employee = (Employee) in.readObject();
            System.out.println("client: employee: " + employee);
            return employee;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public List<Room> getRooms() throws ClassNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("get_rooms");

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            @SuppressWarnings("unchecked")
            List<Room> rooms = (List<Room>) in.readObject();
            System.out.println("client: rooms: " + rooms);
            return rooms;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    } 

    public BookRoom getBookRoomByID(String id) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("get_book_room_by_id");
            writer.println(id);

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            BookRoom bookRoom = (BookRoom) in.readObject();
            System.out.println("client: bookRoom: " + bookRoom);
            return bookRoom;
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public boolean addOrder(Order order) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("add_book_order");
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(order);
            out.flush();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public Room getRoomByID(String id) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("get_room_by_id");
            writer.println(id);

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Room room = (Room) in.readObject();
            System.out.println("client: room: " + room);
            return room;
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public RoomStatusType finRoomStatusTypeById(String id) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("find_room_status_type_by_id");
            writer.println(id);

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            RoomStatusType roomStatusType = (RoomStatusType) in.readObject();
            System.out.println("client: roomStatusType: " + roomStatusType);
            return roomStatusType;
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void updateBookRoom(BookRoom bookRoom) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("update_book_room");
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(bookRoom);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Room> findRoomByIDLoaiPhong(String idLoaiPhong) throws ClassNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println("find_room_by_id_loai_phong");
            writer.println(idLoaiPhong);

            // Use a separate InputStream for the ObjectInputStream
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            @SuppressWarnings("unchecked")
            List<Room> rooms = (List<Room>) in.readObject();
            System.out.println("client: rooms: " + rooms);
            return rooms;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    /*
     * Ready for use.
     */
    public void close() {
        try {
            // Send a message to tell the server to close the connection.
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);

            if (socket != null && !socket.isClosed())
                socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}