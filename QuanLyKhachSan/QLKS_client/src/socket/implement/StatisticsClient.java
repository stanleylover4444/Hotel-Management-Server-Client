package socket.implement;

import socket.SocketClient;

import java.io.*;
import java.util.List;

public class StatisticsClient {
    private SocketClient socketClient;

    public StatisticsClient() {
        this.socketClient = new SocketClient("localhost", 31000);
    }

    public List<Object> getStatistics(String type, int time) {
        try {
            PrintWriter writer = new PrintWriter(socketClient.getSocket().getOutputStream(), true);
            writer.println("get_statistics");
            writer.println(type);
            writer.println(time);
            ObjectInputStream in = new ObjectInputStream(socketClient.getSocket().getInputStream());
            return (List<Object>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
