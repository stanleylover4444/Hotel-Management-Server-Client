package ui;

import entity.Employee;
import socket.SocketServer;

import javax.swing.JOptionPane;

import dao3.AccountDAO;
import dao3.EmployeeDAO;

public class Frm_Login extends javax.swing.JFrame {

    public static void main(String args[]) {
    	SocketServer socketServer = new SocketServer(31000);
    }
}
