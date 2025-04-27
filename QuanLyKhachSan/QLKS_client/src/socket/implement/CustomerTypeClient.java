package socket.implement;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import entity.CustomerType;
import socket.SocketClient;
import socket.interfaces.ICustomerType;

public class CustomerTypeClient implements ICustomerType{
 private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    @SuppressWarnings("resource")
    public CustomerTypeClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }
    @Override
    public CustomerType findCusTypeID(String id) {
        System.out.println("client: findCusTypeID");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("findCusTypeID");
            writer.println(id);
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            CustomerType customerType = (CustomerType) in.readObject();
            return customerType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'findCusTypeID'");
    }

    @Override
    public CustomerType findCusByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCusByName'");
    }

}
//checklai