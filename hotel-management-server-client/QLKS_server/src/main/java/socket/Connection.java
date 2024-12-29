package socket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entity.Customer;
import entity.Employee;
import entity.Room;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Connection {
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void send(String message) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //send boolean to client 
    public void sendBoolean(boolean bool) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            writer.println(bool);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendObject(Object object) {
        try {
            System.out.println("sendObject: " + object.toString());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            
            out.writeObject(object);
            out.flush(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendList(List<Room> list) throws IOException {
        System.out.println("sendList: " + list.toString());
        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(list);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendListCustomer(List<Customer> list) throws IOException {
        System.out.println("sendList: " + list.toString());
        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(list);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendListBookRoom(ArrayList<entity.BookRoom> list) throws IOException {
        System.out.println("sendList: " + list.toString());
        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(list);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}