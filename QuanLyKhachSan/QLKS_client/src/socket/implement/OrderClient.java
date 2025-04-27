package socket.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import socket.SocketClient;
import socket.interfaces.IOrder;

public class OrderClient implements IOrder{

    private SocketClient socketClient;

    public OrderClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }

    @Override
    public List<Order> getAll() {
        try {
            PrintWriter writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_all_orders");
            ObjectInputStream in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (List<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean add(Order obj) {
        try {
            PrintWriter writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("add_order");
            ObjectOutputStream out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(obj);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Order obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<Order> getOrderByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderByStatus'");
    }

    @Override
    public ArrayList<Order> getAlLOrderWithStatus() {
        try {
            PrintWriter writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_orders_with_status");
            ObjectInputStream in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (ArrayList<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Order> getOrderBeforeTime(int time) {
        try {
            PrintWriter writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_orders_before_time");
            writer.println(time);
            ObjectInputStream in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (ArrayList<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
