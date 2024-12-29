package socket.implement;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entity.Customer;
import socket.SocketClient;
import socket.interfaces.ICustomer;

public class CustomerClient implements ICustomer{
    private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    @SuppressWarnings("resource")
    public CustomerClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }
    @Override
    public List<Customer> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Customer getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean add(Customer obj) {
        System.out.println("client: addCustomer");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("addCustomer");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(Customer obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Customer getCustomerByCCCD(String cccd) {
        System.out.println("client: getCustomerByCCCD");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("getCustomerByCCCD");
            writer.println(cccd);
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            Customer customer = (Customer) in.readObject();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerByCCCD'");
    }

    @Override
    public ArrayList<Customer> getalltbKhachHang() {
        System.out.println("client: getalltbKhachHang");
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("getalltbKhachHang");
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            ArrayList<Customer> customers = (ArrayList<Customer>) in.readObject();
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getalltbKhachHang'");
    }

    @Override
    public List<Customer> getAllEmpType(String idType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmpType'");
    }

    @Override
    public List<Customer> getListEmpGender(String gender) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpGender'");
    }

}
