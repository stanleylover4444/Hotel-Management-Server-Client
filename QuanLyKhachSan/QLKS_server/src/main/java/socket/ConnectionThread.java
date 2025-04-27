package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import dao3.AccountDAO;
import dao3.BookRoomDAO;
import dao3.CustomerDAO;
import dao3.EmployeeDAO;
import dao3.RoomDAO;
import dao3.RoomStatusTypeDAO;
import dao3.RoomTypeDAO;
import entity.Account;
import entity.Customer;
import entity.CustomerDTO;
import entity.Employee;
import entity.Order;
import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entity.Service;
import dao.ServiceDAO;
import dao.OrderDAO;

class ConnectionThread extends Thread {
    private Socket socket;
    private SocketServer socketServer;
    private Connection connection;
    private boolean isRunning;
    private AccountDAO dao_Acc;
    private EmployeeDAO dao_Emp;
    private RoomDAO dao_Room;
    private CustomerDAO dao_Cus;
    private ServiceDAO dao_Service;
    private OrderDAO dao_Order; // Add OrderDAO instance
    private RoomTypeDAO dao_CusType;
    private RoomStatusTypeDAO dao_CusStatusType;

    public ConnectionThread(Socket socket, SocketServer socketServer) {
        this.socket = socket;
        this.socketServer = socketServer;
        connection = new Connection(socket);
        isRunning = true;
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("aaa");

        dao_Acc=new AccountDAO(entityFactory.createEntityManager());
        dao_Emp=new EmployeeDAO(entityFactory.createEntityManager());
        dao_Room=new RoomDAO(entityFactory.createEntityManager());
        dao_Cus = new CustomerDAO(entityFactory.createEntityManager());
        dao_Service = new ServiceDAO();
        dao_Order = new OrderDAO(); // Initialize OrderDAO
        dao_CusType = new RoomTypeDAO(entityFactory.createEntityManager());
        dao_CusStatusType = new RoomStatusTypeDAO(entityFactory.createEntityManager());
        // dao_CusType=new CustomerTypeDAO();
        // dao_RoomStatusType=new RoomStatusTypeDAO();
        // dao_BookRoom=new BookRoomDAO();

    }

    @Override
    public void run() {
        while(isRunning) {
            if (socket.isClosed()) {
                isRunning = false;
                break;
            }
            
            //login:
            String username = null;
            String password = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true, java.nio.charset.StandardCharsets.UTF_8);
                String command = reader.readLine();
                System.out.println("server: command: " + command);
                if (command.equals("findPass")) {
                    System.out.println("server: findPass");
                    username = reader.readLine();
                    password = dao_Acc.findPass(username);
                    System.out.println("server: password: " + password);
                    connection.send(password);
                }

                if (command.equals("get_employee")) {
                    username = reader.readLine();
                    Employee emp = dao_Emp.findEmpID(username);
                    if (emp != null) {
                        connection.sendObject(emp);
                    } else {
                        connection.send("employee_not_found");
                    }
                }

                if (command.equals("get_all_room")) {
                    System.out.println("server: get all room");
                    connection.sendList(dao_Room.getAllRooms());
                }
                
                if (command.equals("findRoomByIDLoaiPhong")){
                    System.out.println("server: findRoomByIDLoaiPhong");
                    String IDLoaiPhong = reader.readLine();
                    System.out.println("server: IDLoaiPhong: " + IDLoaiPhong);
                    connection.sendList(dao_Room.findRoomByIDLoaiPhong(IDLoaiPhong));
                }

                if (command.equals("findRoomByID")){
                    System.out.println("server: findRoomByID");
                    String IDPhong = reader.readLine();
                    connection.sendObject(dao_Room.findRoomById(IDPhong));
                }

                // if (command.equals("finRoomStatusTypeById")){
                //     System.out.println("server: finRoomStatusTypeById");
                //     String ID = reader.readLine();
            
                //     connection.sendObject(dao_RoomStatusType.finRoomStatusTypeById(ID));
                // }

                if (command.equals("getCustomerByCCCD")) {
                    System.out.println("server: getCustomerByCCCD");
                    String cccd = reader.readLine();
                    Customer customer = dao_Cus.getCustomerByCCCD(cccd);
                    connection.sendObject(customer);
                }

                if (command.equals("addCustomer")) {
                    System.out.println("server: addCustomer");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Customer customer = (Customer) in.readObject();
                        boolean result = dao_Cus.add(customer);
                        connection.sendBoolean(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("getalltbKhachHang")) {
                    System.out.println("server: getalltbKhachHang");
                    try {
                        List<Customer> customers = dao_Cus.getAllCustomers();
                        List<CustomerDTO> customerDTOs = customers.stream()
                            .map(c -> new CustomerDTO(
                                c.getCustomerID(),
                                c.getCustomerName(),
                                c.getCCCD(),
                                c.getPhone(),
                                c.getEmail(),
                                c.getPoints(),
                                c.getGender()
                            ))
                            .toList();
                        connection.sendList(customerDTOs); // Gửi danh sách DTO
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendList(new ArrayList<>()); // Gửi danh sách rỗng nếu có lỗi
                    }
                }

                if (command.equals("updateCustomer")) {
                    System.out.println("server: updateCustomer");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Customer customer = (Customer) in.readObject();
                        boolean result = dao_Cus.update(customer);
                        connection.sendBoolean(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("deleteCustomer")) {
                    System.out.println("server: deleteCustomer");
                    String customerId = reader.readLine();
                    Customer customer = dao_Cus.getCustomerByID(customerId);
                    boolean result = dao_Cus.delete(customer);
                    connection.sendBoolean(result);
                }

                // if (command.equals("getCustomerByCCCD")){
                //     System.out.println("server: getCustomerByCCCD");
                //     String CCCD = reader.readLine();
                //     connection.sendObject(dao_Cus.getCustomerByCCCD(CCCD));
                // }

                // if (command.equals("addCustomer")){
                //     System.out.println("server: addCustomer");
                //     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                //     Customer cus = (Customer) in.readObject();
                //     connection.sendBoolean(dao_Cus.add(cus));
                // }

                // if (command.equals("getalltbKhachHang")){
                //     System.out.println("server: getalltbKhachHang");
                //     connection.sendListCustomer(dao_Cus.getalltbKhachHang());
                // }

                // if(command.equals("findCusTypeID")){
                //     System.out.println("server: getCustomerTypeById");
                //     String ID = reader.readLine();
                //     connection.sendObject(dao_CusType.findCusTypeID(ID));
                // }
                
                // if(command.equals("getBookRoomById")){
                //     System.out.println("server: getBookRoomById");
                //     String ID = reader.readLine();
                //     connection.sendObject(dao_BookRoom.getBookRoomByID(ID));
                // }

                // if(command.equals("updateBookRoom")){
                //     System.out.println("server: updateBookRoom");
                //     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                //     connection.sendBoolean(dao_BookRoom.updateBookRoom((entity.BookRoom) in.readObject()));
                // }

                // if(command.equals("getAllBookRoom")){
                //     System.out.println("server: getAllBookRoom");
                //     connection.sendListBookRoom(dao_BookRoom.getAlLBookRooms());
                // }
                
                // if(command.equals("getAlLBookRoomsWithStatus")){
                //     System.out.println("server: getAlLBookRoomsWithStatus");
                //     connection.sendListBookRoom(dao_BookRoom.getAlLBookRoomsWithStatus());
                // }

                if(command.equals("getMaPhong")){
                    System.out.println("server: getMaPhong");
                    connection.send(dao_Room.getMaPhong());
                }

                if (command.equals("add_room")) {
                    System.out.println("server: add_room");
                    try {
                        // Read individual room details
                        String roomID = reader.readLine();
                        String roomName = reader.readLine();
                        String roomTypeID = reader.readLine();
                        String roomStatusTypeID = reader.readLine();
                        String description = reader.readLine();

                        // Fetch related entities from the database
                        RoomType roomType = dao_CusType.findRoomTypeById(roomTypeID == null ? "LP001" : roomTypeID);
                        RoomStatusType roomStatusType = dao_CusStatusType.finRoomStatusTypeById(roomStatusTypeID == null ? "LTTP002" : roomStatusTypeID);

                        // Create Room object
                        Room room = new Room();
                        room.setRoomID(roomID);
                        room.setRoomName(roomName);
                        room.setRoomType(roomType);
                        room.setRoomStatusType(roomStatusType);
                        room.setDescription(description);

                        // Save room to database
                        boolean result = dao_Room.saveRoom(room);
                        connection.sendBoolean(result);
                        System.out.println("server: add room result: " + result);
                    } catch (IOException e) {
                        System.err.println("Error processing add_room command: " + e.getMessage());
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }
                if (command.equals("update_room")) {
                    System.out.println("server: update_room");
                    try {
                        // Read individual room details
                        String roomID = reader.readLine();
                        String roomName = reader.readLine();
                        String roomTypeID = reader.readLine();
                        String roomStatusTypeID = reader.readLine();
                        String description = reader.readLine();

                        // Fetch related entities from the database
                        RoomType roomType = dao_CusType.findRoomTypeById(roomTypeID == null ? "LP001" : roomTypeID);
                        RoomStatusType roomStatusType = dao_CusStatusType.finRoomStatusTypeById(roomStatusTypeID == null ? "LTTP002" : roomStatusTypeID);

                        // Find the existing Room object
                        Room room = dao_Room.findRoomById(roomID);
                        if (room != null) {
                            // Update Room object details
                            room.setRoomName(roomName);
                            room.setRoomType(roomType);
                            room.setRoomStatusType(roomStatusType);
                            room.setDescription(description);

                            // Update the room in the database
                            dao_Room.updateRoom(room);
                            connection.sendBoolean(true); // Notify the client of success
                            System.out.println("Room updated successfully.");
                        } else {
                            connection.sendBoolean(false); // Notify the client if room not found
                            System.out.println("Room not found.");
                        }
                    } catch (IOException e) {
                        System.err.println("Error processing update_room command: " + e.getMessage());
                        e.printStackTrace();
                        connection.sendBoolean(false); // Notify the client of failure
                    }
                }
                
                if (command.equals("delete_room")) {
                    System.out.println("server: delete_room");
                    try {
                        String roomId = reader.readLine(); // Read the room ID to delete
                        System.out.println("Deleting room with ID: " + roomId);
                
                        dao_Room.deleteRoom(roomId); // Delete the room from the database
                        connection.sendBoolean(true); // Notify the client of success
                        System.out.println("Room deleted successfully.");
                    } catch (IOException e) {
                        System.err.println("Error processing delete_room command: " + e.getMessage());
                        e.printStackTrace();
                        connection.sendBoolean(false); // Notify the client of failure
                    }
                }

                if (command.equals("search_rooms")) {
                    System.out.println("server: search_rooms");
                    try {
                        String roomId = reader.readLine();
                        String roomType = reader.readLine();
                        String roomStatus = reader.readLine();

                        if (roomType.isEmpty()) roomType = null;
                        if (roomStatus.isEmpty()) roomStatus = null;

                        List<Room> filteredRooms = dao_Room.searchRooms(roomId, roomType, roomStatus);
                        connection.sendList(filteredRooms);
                    } catch (IOException e) {
                        System.err.println("Error processing search_rooms command: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

                if (command.equals("get_all_employees")) {
                    System.out.println("server: get_all_employees");
                    connection.sendList(dao_Emp.getAllList());
                }
                
                if (command.equals("add_employee")) {
                    System.out.println("server: add_employee");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Employee employee = (Employee) in.readObject();
                        boolean result = dao_Emp.add(employee);
                        connection.sendBoolean(result);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }
                
                if (command.equals("update_employee")) {
                    System.out.println("server: update_employee");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Employee employee = (Employee) in.readObject();
                        boolean result = dao_Emp.update(employee);
                        connection.sendBoolean(result);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }
                
                if (command.equals("delete_employee")) {
                    System.out.println("server: delete_employee");
                    try {
                        String employeeId = reader.readLine();
                        boolean result = dao_Emp.delete(dao_Emp.findEmpID(employeeId));
                        connection.sendBoolean(result);
                    } catch (IOException e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("get_all_accounts")) {
                    System.out.println("server: get_all_accounts");
                    connection.sendList(dao_Acc.getAllListAccount());
                }
                
                if (command.equals("delete_account")) {
                    System.out.println("server: delete_account");
                    username = reader.readLine();
                    Account account = dao_Acc.getAccountById(username);
                    boolean result = dao_Acc.delete(account);
                    connection.sendBoolean(result);
                }
                
                if (command.equals("update_account")) {
                    System.out.println("server: update_account");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Account account = (Account) in.readObject();
                        boolean result = dao_Acc.update(account.getPassword(), account.getUserName());
                        connection.sendBoolean(result);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("get_all_services")) {
                    System.out.println("server: get_all_services");
                    connection.sendList(dao_Service.getAllService());
                }

                if (command.equals("add_service")) {
                    System.out.println("server: add_service");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Service service = (Service) in.readObject();
                        boolean result = dao_Service.add(service);
                        connection.sendBoolean(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("update_service")) {
                    System.out.println("server: update_service");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Service service = (Service) in.readObject();
                        boolean result = dao_Service.update(service);
                        connection.sendBoolean(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("delete_service")) {
                    System.out.println("server: delete_service");
                    try {
                        String serviceID = reader.readLine();
                        Service service = dao_Service.findServiceByID(serviceID);
                        boolean result = dao_Service.delete(service);
                        connection.sendBoolean(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }

                if (command.equals("get_all_orders")) {
                    System.out.println("server: get_all_orders");
                    connection.sendList(dao_Order.getAlLOrder());
                }
            
                if (command.equals("get_orders_before_time")) {
                    System.out.println("server: get_orders_before_time");
                    int time = Integer.parseInt(reader.readLine());
                    connection.sendList(dao_Order.getOrderBeforeTime(time));
                }
            
                if (command.equals("get_orders_with_status")) {
                    System.out.println("server: get_orders_with_status");
                    connection.sendList(dao_Order.getAlLOrderWithStatus());
                }
            
                if (command.equals("add_order")) {
                    System.out.println("server: add_order");
                    try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                        Order order = (Order) in.readObject();
                        boolean result = dao_Order.add(order);
                        connection.sendBoolean(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        connection.sendBoolean(false);
                    }
                }
            } catch (Exception e) {
				e.printStackTrace();
			}

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isRunning() {
        return isRunning;
    }
    
    public void stopRunning() {
        isRunning = false;
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}