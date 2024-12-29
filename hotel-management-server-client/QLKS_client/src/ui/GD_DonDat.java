package ui;

import entity.BookRoom;
import entity.Customer;
import entity.Employee;
import entity.Order;
import entity.Room;
import entity.RoomStatusType;
import socket.implement.BookRoomClient;
import socket.implement.CustomerClient;
import socket.implement.CustomerTypeClient;
import socket.implement.EmployeeClient;
import socket.implement.OrderClient;
import socket.implement.RoomClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class GD_DonDat extends javax.swing.JInternalFrame implements Runnable{
    private Thread thread = new Thread((Runnable) this);
    private String username;
    RoomClient roomDAO;
    socket.implement.RoomStatusType roomStatusTypeDAO;
    JButton lblRoom;
    String nameRoom;
    private String idroom;
    ButtonGroup group;
    //List
    List<Room> listRoomDoi;
    List<Room> listRoomDoiLon;
    List<Room> listRoomDon;
    List<BookRoom> listBookRooms;
    private final CustomerClient cDAO=new CustomerClient();
    private final CustomerTypeClient ctDAO=new CustomerTypeClient();
    private final BookRoomClient brDAO=new BookRoomClient();
    private final RoomClient rDAO=new RoomClient();
    private final EmployeeClient eDAO=new EmployeeClient();
    private DefaultTableModel dtm;
    private final OrderClient oDAO=new OrderClient();

    public GD_DonDat(String user) {
        username=user;
        thread.start();
        roomDAO=new RoomClient();
        roomStatusTypeDAO =new socket.implement.RoomStatusType();
        
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        dtm=(DefaultTableModel)tblDDP.getModel();
        loadDataToTable();
        this.setFocusable(true);
        
        createRoom();
        
        
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlRoom = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtNgay = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtGio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtPhong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        txtCCCD = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        btnTimKhachHang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        gio = new javax.swing.JSpinner();
        phut = new javax.swing.JSpinner();
        giay = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        txtNgayCheckIn = new com.toedter.calendar.JDateChooser();
        jPanel24 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        btnTaoDonDat = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        btnXoaTrang = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDDP = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnMoPhong = new javax.swing.JButton();
        btnHuyDonDat = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(1015, 756));
        pnlMain.setLayout(new javax.swing.BoxLayout(pnlMain, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        pnlRoom.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách phòng trống"));
        pnlRoom.setMinimumSize(new java.awt.Dimension(400, 623));
        pnlRoom.setPreferredSize(new java.awt.Dimension(500, 823));
        pnlRoom.setLayout(new javax.swing.OverlayLayout(pnlRoom));

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanel.setMaximumSize(new java.awt.Dimension(1500, 1200));
        scrollPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        scrollPanel.setPreferredSize(new java.awt.Dimension(800, 800));
        pnlRoom.add(scrollPanel);

        jPanel2.add(pnlRoom);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(1200, 1400));
        jPanel5.setPreferredSize(new java.awt.Dimension(380, 458));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setMaximumSize(new java.awt.Dimension(700, 400));
        jPanel6.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 90));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jPanel15.setBackground(java.awt.Color.white);
        jPanel15.setMaximumSize(new java.awt.Dimension(800, 70));
        jPanel15.setMinimumSize(new java.awt.Dimension(400, 10));
        jPanel15.setPreferredSize(new java.awt.Dimension(475, 12));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel15);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel11.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel11.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel11);

        txtNgay.setEditable(false);
        txtNgay.setBackground(new java.awt.Color(255, 255, 255));
        txtNgay.setFont(new java.awt.Font("Segoe UI", 1, 30)); 
        txtNgay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgay.setText("15/04/2023");
        txtNgay.setMaximumSize(new java.awt.Dimension(700, 250));
        txtNgay.setMinimumSize(new java.awt.Dimension(150, 50));
        txtNgay.setPreferredSize(new java.awt.Dimension(300, 170));
        jPanel12.add(txtNgay);

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel4.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel4.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel4);

        txtGio.setEditable(false);
        txtGio.setBackground(new java.awt.Color(255, 255, 255));
        txtGio.setFont(new java.awt.Font("Segoe UI", 1, 30));
        txtGio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGio.setText("11:08");
        txtGio.setMaximumSize(new java.awt.Dimension(900, 200));
        txtGio.setMinimumSize(new java.awt.Dimension(100, 30));
        txtGio.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel12.add(txtGio);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel1);

        jPanel6.add(jPanel12);

        jPanel13.setBackground(java.awt.Color.white);
        jPanel13.setMaximumSize(new java.awt.Dimension(800, 70));
        jPanel13.setMinimumSize(new java.awt.Dimension(400, 10));
        jPanel13.setPreferredSize(new java.awt.Dimension(475, 12));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel13);

        jPanel5.add(jPanel6);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phòng"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel25);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new java.awt.GridLayout(10, 2));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel8.setText("Phòng :");
        jPanel23.add(jLabel8);

        txtPhong.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        txtPhong.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPhong.setEnabled(false);
        jPanel23.add(txtPhong);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel1.setText("CCCD :  ");
        jPanel23.add(jLabel1);

        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.X_AXIS));

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        jPanel27.add(txtCCCD);

        jPanel28.setLayout(new java.awt.GridLayout(1, 0));

        btnTimKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnTimKhachHang.setText("Tìm");
        btnTimKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKhachHangActionPerformed(evt);
            }
        });
        jPanel28.add(btnTimKhachHang);

        jPanel27.add(jPanel28);

        jPanel23.add(jPanel27);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel2.setText("Họ tên :");
        jPanel23.add(jLabel2);

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        jPanel23.add(txtHoTen);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel3.setText("Số điện thoại :");
        jPanel23.add(jLabel3);

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        jPanel23.add(txtSDT);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel4.setText("Giới tính :");
        jPanel23.add(jLabel4);

        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        radNam.setBackground(new java.awt.Color(255, 255, 255));
        radNam.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        radNam.setSelected(true);
        radNam.setText("Nam");
        jPanel26.add(radNam);
        group=new ButtonGroup();
        group.add(radNam);
        group.add(radNu);

        radNu.setBackground(new java.awt.Color(255, 255, 255));
        radNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        radNu.setSelected(true);
        radNu.setText("Nữ");
        jPanel26.add(radNu);

        jPanel23.add(jPanel26);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel6.setText("Giờ nhận phòng :");
        jPanel23.add(jLabel6);

        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.LINE_AXIS));

        gio.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        SpinnerNumberModel modelGio = new SpinnerNumberModel(0, 0, 23, 1);
        gio.setModel(modelGio);

        phut.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        jPanel29.add(phut);
        SpinnerNumberModel modelPhut = new SpinnerNumberModel(0, 0, 59, 1);
        phut.setModel(modelPhut);

        giay.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        jPanel29.add(giay);
        SpinnerNumberModel modelGiay = new SpinnerNumberModel(0, 0, 59, 1);
        giay.setModel(modelGiay);

        jPanel23.add(jPanel29);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel5.setText("Ngày nhận phòng :");
        jPanel23.add(jLabel5);

        jPanel30.setLayout(new javax.swing.BoxLayout(jPanel30, javax.swing.BoxLayout.LINE_AXIS));

        txtNgayCheckIn.setDateFormatString("yyyy-MM-dd");
        txtNgayCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        jPanel30.add(txtNgayCheckIn);

        jPanel23.add(jPanel30);

        jPanel3.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel24);

        jPanel5.add(jPanel3);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(1200, 400));
        jPanel10.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel21);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.Y_AXIS));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        btnTaoDonDat.setBackground(new java.awt.Color(0, 102, 102));
        btnTaoDonDat.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnTaoDonDat.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoDonDat.setText("Tạo đơn");
        btnTaoDonDat.setVerifyInputWhenFocusTarget(false);
        btnTaoDonDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDonDatActionPerformed(evt);
            }
        });
        jPanel17.add(btnTaoDonDat);

        jPanel20.add(jPanel17);

        jPanel10.add(jPanel20);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel19);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.Y_AXIS));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

        btnXoaTrang.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnXoaTrang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTrang.setText("Xóa đơn");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });
        jPanel22.add(btnXoaTrang);

        jPanel16.add(jPanel22);

        jPanel10.add(jPanel16);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel18);

        jPanel5.add(jPanel10);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý đơn đặt"));
        jPanel14.setMaximumSize(new java.awt.Dimension(1000, 1200));
        jPanel14.setPreferredSize(new java.awt.Dimension(400, 458));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setText("Tìm kiếm :   ");
        jPanel7.add(jLabel7);

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        txtTim.setCaretColor(new java.awt.Color(255, 255, 255));
        txtTim.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });
        jPanel7.add(txtTim);

        jPanel14.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách đơn đặt phòng"));
        jPanel8.setLayout(new javax.swing.OverlayLayout(jPanel8));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblDDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn", "Phòng", "CCCD khách hàng", "Ngày nhận phòng", "Giờ nhận phòng"
            }
        ));
        tblDDP.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblDDP);

        jPanel8.add(jScrollPane1);

        jPanel14.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(1200, 400));
        jPanel9.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 100));

        btnMoPhong.setBackground(new java.awt.Color(0, 102, 102));
        btnMoPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnMoPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnMoPhong.setText("Duyệt phòng");
        btnMoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoPhongActionPerformed(evt);
            }
        });

        btnHuyDonDat.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyDonDat.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnHuyDonDat.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyDonDat.setText("Hủy đơn");
        btnHuyDonDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonDatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnMoPhong)
                .addGap(94, 94, 94)
                .addComponent(btnHuyDonDat)
                .addContainerGap(566, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoPhong)
                    .addComponent(btnHuyDonDat))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel9);

        jPanel5.add(jPanel14);

        jPanel2.add(jPanel5);

        pnlMain.add(jPanel2);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    } 

    private void btnMoPhongActionPerformed(java.awt.event.ActionEvent evt) {
        
        int index=tblDDP.getSelectedRow();
        if(index==-1){
            JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần duyệt!");
        }else{
            ArrayList<BookRoom> listBr=new ArrayList<>();
            BookRoom br=brDAO.getById(tblDDP.getValueAt(index, 0).toString());
            listBr.add(br);
            Employee e=eDAO.getById(username);
            String status="Chưa thanh toán";
            Order order=new Order(maTuSinhHoaDon(), null, null, listBr, e,status);
            if(oDAO.add(order)){
                Room r=rDAO.getById(br.getRoom().getRoomID());
                RoomStatusType rst= new RoomStatusType();
                r.setRoomStatusType(rst);
                listBr.get(0).setStatus("Đã mở phòng");
                brDAO.update(listBr.get(0));
                loadDataToTable();
                JOptionPane.showMessageDialog(null, "Đặt phòng thành công!");
            }
            
        }
    } 

    private void btnTaoDonDatActionPerformed(java.awt.event.ActionEvent evt) {
        taoDonDat();
        
        
        
        
    } 

    private void btnTimKhachHangActionPerformed(java.awt.event.ActionEvent evt) {
       if(txtCCCD.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Hãy nhập CCCD khách hàng cần tìm kiếm!");
       }else{
           Customer c= cDAO.getCustomerByCCCD(txtCCCD.getText());
        if(c!=null){
            txtHoTen.setText(c.getCustomerName());
            txtSDT.setText(c.getPhone());
            if(c.getGender().equals("Nam")){
                radNam.setSelected(true);
                
            }else{
                radNu.setSelected(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Đây là khách hàng mới, vui lòng nhập đầy đủ thông tin!");
        }
       }
    } 

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) { 
        xoaTrang();
       
    } 

    private void btnHuyDonDatActionPerformed(java.awt.event.ActionEvent evt) { 
        int index=tblDDP.getSelectedRow();
        if(index==-1){
            JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần hủy!");
        }else{
            
            if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy căn phòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                {
                    BookRoom br=brDAO.getById(tblDDP.getValueAt(index, 0).toString());
                    if(brDAO.delete(br.getBookRoomID())){
                           Room room=rDAO.getById(br.getRoom().getRoomID());
                           RoomStatusType rst=new RoomStatusType();
                           room.setRoomStatusType(rst);
                           rDAO.update(room);
                           
                           loadDataToTable();
                           createRoom();
                           JOptionPane.showMessageDialog(null, "Hủy thành công!");
                           
                    }
                }
            } 
        }
    } 

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {
        String s=txtTim.getText();
        filter(s);
    } 
    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(dtm);
        tblDDP.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));

        
    }


// Create list rooms
    private void createRoom() {
        listRoomDoi = roomDAO.findRoomByIDLoaiPhong("LP002");
        listRoomDon = roomDAO.findRoomByIDLoaiPhong("LP001");
        listRoomDoiLon = roomDAO.findRoomByIDLoaiPhong("LP003");

        int soLuongPhong= listRoomDoi.size()+listRoomDoi.size()+listRoomDoiLon.size();
        JLabel lblListNormal;
        // Titile Normal
        lblListNormal = new JLabel("Danh sách phòng đơn");
        lblListNormal.setBounds(20, 20, 300, 30);
        lblListNormal.setFont(new Font("Segoe UI", Font.BOLD, 14));

        
        JPanel pnlListRoom = new JPanel();
        pnlListRoom.removeAll();
        pnlListRoom.setBackground(Color.white);
        pnlListRoom.setLayout(null);
        pnlListRoom.setPreferredSize(new Dimension(600, 2000));
        pnlListRoom.add(lblListNormal);

        JLabel lblListDoi;
        JLabel lblListDoiLon;
        
        int x = 20;
        int y = 60;
        int width = 130;
        int height = 100;
        int countHeight = 0;
        int numberRoomNormal = 1;
        int numberRoomVip1=1;
        int countNumberRoomNormalRemove = 0;
        int numberRoomVip = 1;
        String trangThaiPhong;
        for (Room room : listRoomDon) {
            trangThaiPhong = room.getRoomStatusType().getRoomStatusTypeID().toUpperCase();
            if (trangThaiPhong.equals("LTTP004")) {
                countNumberRoomNormalRemove++;
            }
        }
        for (Room room : listRoomDon) {
            trangThaiPhong = room.getRoomStatusType().getRoomStatusTypeID().toUpperCase();
            if (!trangThaiPhong.equals("LTTP004")) {
                //Room
                pnlRoom = new JPanel();
                pnlRoom.setBackground(Color.white);
                pnlRoom.setLayout(new BorderLayout());
                pnlRoom.setBounds(x, y, width, height);

                if (trangThaiPhong.equals("LTTP001")) {
                    createStatusRoom(trangThaiPhong, new Color(36,89,83), pnlRoom);
                    createNameRoom(room.getRoomID(), pnlRoom, new Color(185,237,221), room);
                }

                pnlListRoom.add(pnlRoom, BorderLayout.CENTER);
                x += width + 20;

                if (numberRoomNormal ==4) {
                    
                }else if(numberRoomNormal % 4 == 0 && listRoomDon.size()% 4 !=0){
                    y += width + 20;
                    x = 20;
                    countHeight = y + 40;
                }
                numberRoomNormal++;
               
                
                
            }
        }
        countHeight+= (height + y+20);
         if ( listRoomDoi.size()>0) {
                    lblListDoi = new JLabel("Danh sách phòng đôi");
                    lblListDoi.setBounds(20, countHeight, 300, 30);
                    lblListDoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
                    pnlListRoom.add(lblListDoi);
        countHeight+=  40;
        x = 20;
        for (Room room : listRoomDoi) {
            trangThaiPhong = room.getRoomStatusType().getRoomStatusTypeID().toUpperCase();
            if (!trangThaiPhong.equals("LTTP004")) {
                //Room
                pnlRoom = new JPanel();
                pnlRoom.setBackground(Color.white);
                pnlRoom.setLayout(new BorderLayout());
                pnlRoom.setBounds(x, countHeight, width, height);

                if (trangThaiPhong.equals("LTTP001")) {
                    createStatusRoom(trangThaiPhong, new Color(36,89,83), pnlRoom);
                    createNameRoom(room.getRoomID(), pnlRoom, new Color(185,237,221), room);
                }
                pnlListRoom.add(pnlRoom);
                x += width + 20;

                if (numberRoomVip ==4) {
                    
                }else if (numberRoomVip % 4 == 0 && listRoomDoi.size()% 4 !=0) {
                    countHeight += width + 20;
                    x = 20;
                }
                numberRoomVip++;
            }
        }
         }
         countHeight+=  height+ 20;
        if (listRoomDoiLon.size()>0) {
                    lblListDoiLon = new JLabel("Danh sách phòng đôi lớn");
                    lblListDoiLon.setBounds(20, countHeight, 300, 30);
                    lblListDoiLon.setFont(new Font("Segoe UI", Font.BOLD, 14));
                    pnlListRoom.add(lblListDoiLon);
                }
        countHeight+=  40;
        x=20;
        for (Room room : listRoomDoiLon) {
            trangThaiPhong = room.getRoomStatusType().getRoomStatusTypeID().toUpperCase();
                //Room
                pnlRoom = new JPanel();
                pnlRoom.setBackground(Color.white);
                pnlRoom.setLayout(new BorderLayout());
                pnlRoom.setBounds(x, countHeight, width, height);

                if (trangThaiPhong.equals("LTTP001")) {
                    createStatusRoom(trangThaiPhong, new Color(36,89,83), pnlRoom);
                    createNameRoom(room.getRoomID(), pnlRoom, new Color(185,237,221), room);
                } 
                pnlListRoom.add(pnlRoom);
                x += width + 20;

                if (numberRoomVip1 % 4 == 0 && listRoomDoi.size()% 4 !=0) {
                    countHeight += width + 20;
                    x = 20;
                }
                numberRoomVip1++;
        }
        pnlListRoom.setPreferredSize(new Dimension(600, countHeight+height+20));
        scrollPanel.setViewportView(pnlListRoom);
    }

// tráº¡ng thÃ¡i phÃ²ng
    private void createStatusRoom(String idTrangThai, Color color, JPanel pnlRom) {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                "asd".toUpperCase());
        titledBorder.setTitleColor(color);
        titledBorder.setTitleFont(new Font("Segoe UI", Font.PLAIN, 10));
        pnlRom.setBorder(titledBorder);
    }
// tÃªn phÃ²ng

    private void createNameRoom(String idPhong, JPanel pnlRom, Color colorBackground, Room room) {
        lblRoom = new JButton();
        lblRoom.setText(roomDAO.getById(idPhong).getRoomName());
        lblRoom.setOpaque(true);
        lblRoom.setBackground(colorBackground);
        lblRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        lblRoom.setForeground(Color.WHITE);
        lblRoom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lblRoom.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                nameRoom = room.getRoomName();
                idroom=room.getRoomID();
                lblRoom.setRequestFocusEnabled(true);
                txtPhong.setText(nameRoom);
            }
        });
        pnlRom.add(lblRoom, BorderLayout.CENTER);
    }
    

    private javax.swing.JButton btnHuyDonDat;
    private javax.swing.JButton btnMoPhong;
    private javax.swing.JButton btnTaoDonDat;
    private javax.swing.JButton btnTimKhachHang;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JSpinner giay;
    private javax.swing.JSpinner gio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner phut;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRoom;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable tblDDP;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtGio;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgay;
    private com.toedter.calendar.JDateChooser txtNgayCheckIn;
    private javax.swing.JTextField txtPhong;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTim;

    private void taoDonDat() {
        if(txtPhong.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần tạo!");
        else
        
        {
            if(txtCCCD.getText().isEmpty() || txtHoTen.getText().isEmpty() || txtSDT.getText().isEmpty() || txtSDT.getText().isEmpty() ||txtNgayCheckIn.getDate().toString().isEmpty())
                JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin!");
            else
              
            {
                if(check()){
                    String ngaydat=txtNgay.getText();
                    
                    if(cDAO.getCustomerByCCCD(txtCCCD.getText())==null){
                        String gt;
                        gt = "";
                        if(radNam.isSelected())
                            gt="Nam";
                        else
                            gt="Nữ";
                        Customer c=new Customer(maTuSinhKhachHang(),txtHoTen.getText(),txtCCCD.getText(), txtSDT.getText(), "", 0,ctDAO.findCusTypeID("LKH001"),gt);
                        cDAO.add(c);
                        Employee e= eDAO.findEmpID(username);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String ngayCheckIn = sdf.format(txtNgayCheckIn.getDate());
                        
                        BookRoom b=new BookRoom(maTuSinhDonDat(), ngaydat, getGioCheckIn(), ngayCheckIn, txtGio.getText(), c, e, rDAO.getById(idroom),"ChÆ°a má»Ÿ phÃ²ng");
                        if(brDAO.add(b)){
                            Room room=rDAO.getById(idroom);
                            RoomStatusType rst=rstDAO.finRoomStatusTypeById("LTTP003");
                            room.setRoomStatusType(rst);
                            rDAO.updateRoom(room);
                            
                            xoaTrang();
                            createRoom();
                            loadDataToTable();
                            Form_DonDat form=new Form_DonDat(b.getBookRoomID());
                            form.setVisible(true);
                            
                        }
                        
                    }else{
                        Employee e= eDAO.findEmpID(username);
                        Customer c=cDAO.getCustomerByCCCD(txtCCCD.getText());
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String ngayCheckIn = sdf.format(txtNgayCheckIn.getDate());
                        BookRoom b=new BookRoom(maTuSinhDonDat(), ngaydat, txtGio.getText(), ngayCheckIn,getGioCheckIn(), c, e, rDAO.getById(idroom),"ChÆ°a má»Ÿ phÃ²ng");
                        
                        if(brDAO.add(b)){
                            Room room=rDAO.getById(idroom);
                            RoomStatusType rst=rstDAO.finRoomStatusTypeById("LTTP003");
                            room.setRoomStatusType(rst);
                            rDAO.updateRoom(room);
                            
                            createRoom();
                            loadDataToTable();
                            
                            xoaTrang();
                            Form_DonDat form=new Form_DonDat(b.getBookRoomID());
                            form.setVisible(true);
                        }
                    }
                }
            }
        }
        
    }
    
    private String maTuSinhKhachHang() {
        String ma = "KH";
        int tachMa;
        int i = 0, j = 1;
        int[] dem = new int[999];
        String id;
        for (Customer c : cDAO.getalltbKhachHang()) {
            id = c.getCustomerID();
            tachMa = Integer.parseInt(id.substring(2, 5));
            dem[i] = tachMa;
            i++;
        }
        i = 0;
        while (j < 999) {
            if (dem[i] < j) {
                if (j <= 9) {
                    ma += "00" + (j);
                } else {
                    ma += "0" + (j);
                }
                break;
            } else if (dem[i] > j) {
                j = dem[i];
            } else {
                i++;
                j++;
            }
        }
        return ma;
    }
    
    private String maTuSinhDonDat() {
        String ma = "DDP";
        int tachMa;
        int i = 0, j = 1;
        int[] dem = new int[999];
        String id;
        for (BookRoom br : brDAO.getAll()) {
            id = br.getBookRoomID();
            tachMa = Integer.parseInt(id.substring(3, 6));
            dem[i] = tachMa;
            i++;
        }
        i = 0;
        while (j < 999) {
            if (dem[i] < j) {
                if (j <= 9) {
                    ma += "00" + (j);
                } else {
                    ma += "0" + (j);
                }
                break;
            } else if (dem[i] > j) {
                j = dem[i];
            } else {
                i++;
                j++;
            }
        }
        return ma;
    }
    private String getGioCheckIn(){
        String s="";
        int g=(int)gio.getValue();
        int p=(int)phut.getValue();
        int gi=(int)giay.getValue();
        
        if(g<10){
            s+="0"+g+":";
        }
        if(p<10){
            s+="0"+p+":";
        }
        if(gi<10){
            s+="0"+gi;
        }
        
        return s;
    }
    
    private String maTuSinhHoaDon() {
        String ma = "HD";
        int tachMa;
        int i = 0, j = 1;
        int[] dem = new int[999];
        String id;
        for (Order order : oDAO.getAlLOrder()) {
            id = order.getOrderID();
            tachMa = Integer.parseInt(id.substring(2, 5));
            dem[i] = tachMa;
            i++;
        }
        i = 0;
        while (j < 999) {
            if (dem[i] < j) {
                if (j <= 9) {
                    ma += "00" + (j);
                } else {
                    ma += "0" + (j);
                }
                break;
            } else if (dem[i] > j) {
                j = dem[i];
            } else {

                i++;
                j++;
            }
        }
        return ma;
    }
    @Override
    public void run() {
        try {
            txtGio = new JTextField();
            txtNgay = new JTextField();
            Date thoiGianHienTai = new Date();
            SimpleDateFormat sdf_Gio = new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat sdf_Ngay = new SimpleDateFormat("yyyy-MM-dd");
            while (true) {
                thoiGianHienTai = new Date(); 
                txtGio.setText(sdf_Gio.format(thoiGianHienTai));
                txtNgay.setText(sdf_Ngay.format(thoiGianHienTai));
                thread.sleep(1000); // cho phÃ©p ngá»§ trong khoáº£ng 1000 mns =1s
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean check() {
        return true;
    }

    
    private void xoaTrang() {
        txtPhong.setText("");
        txtCCCD.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        gio.setValue(0);
        phut.setValue(0);
        giay.setValue(0);
        txtNgayCheckIn.setDate(null);
    }

    private void loadDataToTable() {
        dtm.setRowCount(0);
        listBookRooms=brDAO.getBookRoomsWithStatus();
        if(listBookRooms!=null){
        for (BookRoom bookRoom : listBookRooms) {
            dtm.addRow(new String[]{bookRoom.getBookRoomID(), bookRoom.getRoom().getRoomName(),
                bookRoom.getCustomer().getCCCD(), bookRoom.getCheckInDate(),
                bookRoom.getCheckInTime()});
        }
    }
    }


    
}
