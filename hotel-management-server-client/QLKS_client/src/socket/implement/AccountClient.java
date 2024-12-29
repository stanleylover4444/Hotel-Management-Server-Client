package socket.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import entity.Account;
import socket.SocketClient;
import socket.interfaces.IAccount;

public class AccountClient implements IAccount{
    private SocketClient socketClient;
    private PrintWriter writer;
    private BufferedReader reader;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    @SuppressWarnings("resource")
    public AccountClient(){
        this.socketClient = new SocketClient("localhost", 31000);
        // try{
        //     this.writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
        //     this.reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
        //     this.out = new ObjectOutputStream(socketClient.getSocket().getOutputStream());
        //     this.in = new ObjectInputStream(socketClient.getSocket().getInputStream());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
    
    @Override
    public List<Account> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Account getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean add(Account obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean update(Account obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean checkLogin(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkLogin'");
    }

    @Override
    public String findPass(String username) {
        System.out.println("client: findPass");
        try {
            writer = new PrintWriter(new OutputStreamWriter(socketClient.getSocket().getOutputStream()), true);
            writer.println("findPass");
            writer.println(username);
            reader = new BufferedReader(new InputStreamReader(socketClient.getSocket().getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Unimplemented method 'findPass'");
    }

}
