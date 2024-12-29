package socket.interfaces;

import java.util.ArrayList;

import entity.Order;

public interface IOrder extends Interfaces<Order, String>{
    ArrayList<Order> getOrderByStatus(String status);
    ArrayList<Order> getAlLOrderWithStatus();
    ArrayList<Order> getOrderBeforeTime(int time);
}
