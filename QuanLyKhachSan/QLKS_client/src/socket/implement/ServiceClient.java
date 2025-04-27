package socket.implement;

import entity.Service;
import socket.SocketClient;

import java.io.*;
import java.util.List;

public class ServiceClient {
    private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ServiceClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }

    public List<Service> getAllServices() {
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
            writer.println("get_all_services");
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (List<Service>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addService(Service service) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
            writer.println("add_service");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(service);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateService(Service service) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
            writer.println("update_service");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(service);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteService(String serviceID) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
            writer.println("delete_service");
            writer.println(serviceID);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
