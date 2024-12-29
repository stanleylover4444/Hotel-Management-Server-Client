
package ui;


import dao.AccountDAO;
import dao.EmployeeDAO;
import entity.Employee;
import socket.SocketServer;

import javax.swing.JOptionPane;

public class Frm_Login extends javax.swing.JFrame {

    public static void main(String args[]) {
    	SocketServer socketServer = new SocketServer(31000);
    }
}
