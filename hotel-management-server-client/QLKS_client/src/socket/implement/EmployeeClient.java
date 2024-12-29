package socket.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import entity.Employee;
import socket.SocketClient;
import socket.interfaces.IEmployee;

public class EmployeeClient implements IEmployee{
private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    @SuppressWarnings("resource")
    public EmployeeClient() {
        this.socketClient = new SocketClient("localhost", 31000);
        // try{
        //     this.writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
        //     this.reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
        //     this.out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
        //     this.in = new ObjectInputStream(socketClient.getSocket().getInputStream());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
    @Override
    public List<Employee> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Employee getById(String id) {
        System.out.println("client: getEmployeeById");
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
            writer.println("get_employee");
            writer.println(id);
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            Employee employee = (Employee) in.readObject();
            return employee;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean add(Employee obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(Employee obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Employee> getListEmpQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpQuit'");
    }

    @Override
    public List<Employee> getListEmpStay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpStay'");
    }

    @Override
    public List<Employee> getListEmpGender(String gender) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpGender'");
    }

    @Override
    public List<Employee> getAllEmpType(String idType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmpType'");
    }

    @Override
    public Employee findEmpCCCD(String cccd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findEmpCCCD'");
    }

}
