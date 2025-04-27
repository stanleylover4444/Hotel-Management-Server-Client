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

public class EmployeeClient implements IEmployee {
    private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    @SuppressWarnings("resource")
    public EmployeeClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }

    @Override
    public List<Employee> getAll() {
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_all_employees");
            in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (List<Employee>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("add_employee");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(obj);
            out.flush();
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee obj) {
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("update_employee");
            out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
            out.writeObject(obj);
            out.flush();
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try {
            writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("delete_employee");
            writer.println(id);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> getListEmpQuit() {
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpQuit'");
    }

    @Override
    public List<Employee> getListEmpStay() {
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpStay'");
    }

    @Override
    public List<Employee> getListEmpGender(String gender) {
        throw new UnsupportedOperationException("Unimplemented method 'getListEmpGender'");
    }

    @Override
    public List<Employee> getAllEmpType(String idType) {
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmpType'");
    }

    @Override
    public Employee findEmpCCCD(String cccd) {
        throw new UnsupportedOperationException("Unimplemented method 'findEmpCCCD'");
    }
}
