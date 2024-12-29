package ui;

import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import socket.SocketClient;
import socket.implement.RoomClient;


public class GD_QLPhong extends javax.swing.JInternalFrame {

    private int Rows; 
    private RoomClient roomClient = new RoomClient();
    ArrayList<UI_Phong> ds_UIPhong = null;
    List<Room> ds = null; 
    private static SocketClient socketClient = new SocketClient("localhost", 31000);

    public void loadData() {
        ds = roomClient.getAll();
        System.out.println(ds.size());
        Collections.sort(ds, new Comparator<Room>() {
            @Override
            public int compare(Room room1, Room room2) {
                return room1.getRoomID().compareTo(room2.getRoomID());
            }
        });
        Rows = (ds.size()+4)/5; 
        
        ds_UIPhong = new ArrayList<UI_Phong>(); 
        for( Room r : ds ) 
            ds_UIPhong.add(new UI_Phong(r)); 
        
        jPanel4.removeAll();
        for( UI_Phong ui_p : ds_UIPhong ) {
            jPanel4.add(ui_p); 
            ui_p.addMouseListener(new java.awt.event.MouseAdapter() {
                Color bgr = ui_p.getBGR().getBackground(); 
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    int mg = 30; 
                    ui_p.getBGR().setBackground(new Color(bgr.getRed()-mg, bgr.getGreen()-mg, bgr.getBlue()));
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    ui_p.getBGR().setBackground(bgr);
                    
                    Room room = ui_p.getRoom(); 
                    txtMaPhong.setText(room.getRoomID());
                    txtTenPhong.setText(room.getRoomName()); 
                    String type = room.getRoomType().getRoomTypeID(); 
                    String status = room.getRoomStatusType().getRoomStatusTypeID(); 
                    txtMoTa.setText(room.getDescription());
                    txtGia.setText(room.getRoomType().getPrice() + "");
                    if(type.equals("LP001")){
                        cbbLoaiPhong.setSelectedIndex(0);
                    } else if( type.equals("LP002")) {
                        cbbLoaiPhong.setSelectedIndex(1);
                    } else {
                        cbbLoaiPhong.setSelectedIndex(2);
                    }
                    
                    if( status.equals("LTTP001") ) {
                        cbbTrangThai.setSelectedIndex(0);
                    } else if( status.equals("LTTP002") ) {
                        cbbTrangThai.setSelectedIndex(1);
                    } else if( status.equals("LTTP003") ) {
                        cbbTrangThai.setSelectedIndex(2);
                    } else if( status.equals("LTTP004") ) {
                        cbbTrangThai.setSelectedIndex(3);
                    } else if( status.equals("LTTP005") ) {
                        cbbTrangThai.setSelectedIndex(4);
                    }
                    btnLuu.setText("Cập nhật");
                    btnLuu.setIcon( new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-done-25.png")) );
                }
            }); 
        }
            
        jPanel4.revalidate();
        jPanel4.repaint(); 
        
        int cntTrong = 0, cntDangO = 0, cntDaDAt = 0, cntDonDep = 0, cntBaoTri = 0;  
        for( Room r : ds ) {
            String s = r.getRoomStatusType().getRoomStatusTypeID(); 
            if(s.equals("LTTP001")) cntTrong++; 
            else if(s.equals("LTTP002")) cntDangO++; 
            else if(s.equals("LTTP003")) cntDaDAt++; 
            else if(s.equals("LTTP004")) cntBaoTri++; 
            else cntDonDep++; 
        }
        btnTrong.setText( "Trống" + "("+cntTrong+")" );
        btnDangSuDung.setText( "Đang sử dụng" + "("+cntDangO+")" );
        btnDaDat.setText( "Đã Đặt" + "("+cntDaDAt+")" );
        btnDonDep.setText( "Dọn dẹp" + "("+cntDonDep+")" );
        btnBaoTri.setText( "Bảo trì" + "("+cntBaoTri+")" );
        btnTatCa.setText("Tất cả"+ "("+ ds.size() +")"); 
    }
 
    private boolean checkData() {
        if(txtTenPhong.getText().isBlank() || txtGia.getText().isBlank() ) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin!");
            return false;
        } else {
            String thongBao = ""; 
            if(txtGia.getText().isEmpty() )
                thongBao += "*Giá tiền không hợp lệ\n"; 
            if(thongBao.isEmpty()) 
                return true; 
            JOptionPane.showMessageDialog(this, thongBao);
            return false; 
        }
    }
    
    public GD_QLPhong() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        loadData();       
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTenPhong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtMoTa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtMaPhongTK = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbTrangThaiTK = new javax.swing.JComboBox<>();
        cbbLoaiPhongTK = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        btnTrong = new javax.swing.JButton();
        btnDangSuDung = new javax.swing.JButton();
        btnDaDat = new javax.swing.JButton();
        btnDonDep = new javax.swing.JButton();
        btnBaoTri = new javax.swing.JButton();
        btnXoaPhong = new javax.swing.JButton();
        btnTatCa = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 244, 244));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÊM VÀ CẬP NHẬT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 153, 153)));  
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel2.setText("Tên phòng:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel4.setText("Trạng thái: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel5.setText("Mô tả:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-file-25.png")));  
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton1.setLabel("Thêm ");
        jButton1.setName("btnLuu");  
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnThemMoiMouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 120, 40));

        txtTenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenPhongActionPerformed(evt);
            }
        });
        jPanel1.add(txtTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel6.setText("Mã phòng: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        txtMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        txtMaPhong.setEnabled(false);
        txtMaPhong.setName(""); 
        jPanel1.add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 350, 30));

        cbbLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giường đơn", "Giường đôi", "Giường đôi lớn" }));
        jPanel1.add(cbbLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, 30));

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "Đang sử dụng", "Đã đặt", "Bảo trì", "Dọn dẹp", " " }));
        jPanel1.add(cbbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 120, 30));

        txtMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoTaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 350, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel11.setText("Loại phòng: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        btnLuu.setBackground(new java.awt.Color(0, 102, 102));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-save-25.png")));  
        btnLuu.setText("Lưu");
        btnLuu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnLuu.setName("btnLuu");  
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLuuMouseReleased(evt);
            }
        });
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 120, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel3.setText("Giá tiền:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 70, -1));

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 120, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaPhongTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongTKActionPerformed(evt);
            }
        });
        jPanel2.add(txtMaPhongTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel7.setText("Mã phòng: ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel10.setText("Trạng thái:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        cbbTrangThaiTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trống", "Đang sủ dụng", "Đã đặt", "Bảo trì", "Dọn dẹp" }));
        cbbTrangThaiTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiTKActionPerformed(evt);
            }
        });
        jPanel2.add(cbbTrangThaiTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 130, 30));

        cbbLoaiPhongTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Giường đơn", "Giường đôi", "Giường đôi lớn" }));
        cbbLoaiPhongTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiPhongTKActionPerformed(evt);
            }
        });
        jPanel2.add(cbbLoaiPhongTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel9.setText("Loại phòng: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        btnTimKiem.setBackground(new java.awt.Color(0, 102, 102));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-25.png")));  
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnTimKiem.setName("btnTimKiem");  
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseReleased(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 130, 40));
        btnTimKiem.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 153, 153)));  
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new java.awt.GridLayout(Rows, 5));
        jScrollPane2.setViewportView(jPanel4);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 890, 410));

        btnTrong.setBackground(new java.awt.Color(70, 141, 188));
        btnTrong.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnTrong.setForeground(new java.awt.Color(255, 255, 255));
        btnTrong.setText("Trống");
        btnTrong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnTrong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrong.setName("btnTrong"); 
        btnTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTrongMouseReleased(evt);
            }
        });
        btnTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrongActionPerformed(evt);
            }
        });
        jPanel3.add(btnTrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 40));

        btnDangSuDung.setBackground(new java.awt.Color(219, 51, 60));
        btnDangSuDung.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnDangSuDung.setForeground(new java.awt.Color(255, 255, 255));
        btnDangSuDung.setText("Đang sử dụng");
        btnDangSuDung.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnDangSuDung.setName("btnDangO");  
        btnDangSuDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDangOMouseReleased(evt);
            }
        });
        btnDangSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangSuDungActionPerformed(evt);
            }
        });
        jPanel3.add(btnDangSuDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, 40));

        btnDaDat.setBackground(new java.awt.Color(46, 139, 87));
        btnDaDat.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnDaDat.setForeground(new java.awt.Color(255, 255, 255));
        btnDaDat.setText("Đã đặt");
        btnDaDat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnDaDat.setName("btnDaDat");  
        btnDaDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDaDatMouseReleased(evt);
            }
        });
        btnDaDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaDatActionPerformed(evt);
            }
        });
        jPanel3.add(btnDaDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 120, 40));

        btnDonDep.setBackground(new java.awt.Color(181, 171, 107));
        btnDonDep.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnDonDep.setForeground(new java.awt.Color(255, 255, 255));
        btnDonDep.setText("Dọn dẹp");
        btnDonDep.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnDonDep.setName("btnDonDep");  
        btnDonDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDonDepMouseReleased(evt);
            }
        });
        btnDonDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonDepActionPerformed(evt);
            }
        });
        jPanel3.add(btnDonDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 120, 40));

        btnBaoTri.setBackground(new java.awt.Color(240, 119, 37));
        btnBaoTri.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnBaoTri.setForeground(new java.awt.Color(255, 255, 255));
        btnBaoTri.setText("Bảo trì");
        btnBaoTri.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnBaoTri.setName("btnBaoTri");  
        btnBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBaoTriMouseReleased(evt);
            }
        });
        btnBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoTriActionPerformed(evt);
            }
        });
        jPanel3.add(btnBaoTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 40));

        btnXoaPhong.setBackground(new java.awt.Color(0, 102, 102));
        btnXoaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnXoaPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-25.png")));  
        btnXoaPhong.setText("Xóa");
        btnXoaPhong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnXoaPhong.setName("bntXoa");  
        btnXoaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnXoaPhongMouseReleased(evt);
            }
        });
        btnXoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhongActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 110, 40));

        btnTatCa.setBackground(new java.awt.Color(0, 102, 102));
        btnTatCa.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnTatCa.setForeground(new java.awt.Color(255, 255, 255));
        btnTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-select-all-25.png"))); 
        btnTatCa.setText("Tất cả");
        btnTatCa.setToolTipText("");
        btnTatCa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnTatCa.setName("btnXemTatCa");  
        btnTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTatCaMouseReleased(evt);
            }
        });
        jPanel3.add(btnTatCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleParent(jPanel3);
    } 

    private void jButton1ActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnTimKiemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtMaPhongTKActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnBaoTriActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnTrongActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnDangSuDungActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnDaDatActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnDonDepActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void txtMoTaActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void txtTenPhongActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void cbbTrangThaiTKActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void cbbLoaiPhongTKActionPerformed(ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnTrongMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jPanel4.removeAll();
        
        for( UI_Phong u : ds_UIPhong ) {
            if(u.getRoom().getRoomStatusType().getRoomStatusTypeID().equals("LTTP001")) 
                jPanel4.add(u); 
        }
        jPanel4.revalidate();  
        jPanel4.repaint();  
    } 

    private void btnDangOMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jPanel4.removeAll();
        for( UI_Phong u : ds_UIPhong ) {
            if(u.getRoom().getRoomStatusType().getRoomStatusTypeID().equals("LTTP002")) 
                jPanel4.add(u); 
        }
        jPanel4.revalidate(); 
        jPanel4.repaint(); 
    } 

    private void btnDaDatMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jPanel4.removeAll();
        for( UI_Phong u : ds_UIPhong ) {
            if(u.getRoom().getRoomStatusType().getRoomStatusTypeID().equals("LTTP003")) 
                jPanel4.add(u); 
        }
        jPanel4.revalidate();  
        jPanel4.repaint();  
    } 

    private void btnDonDepMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jPanel4.removeAll();
        for( UI_Phong u : ds_UIPhong ) {
            if(u.getRoom().getRoomStatusType().getRoomStatusTypeID().equals("LTTP005")) 
                jPanel4.add(u); 
        }
        jPanel4.revalidate(); 
        jPanel4.repaint();  
    } 

    private void btnBaoTriMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jPanel4.removeAll();
        for( UI_Phong u : ds_UIPhong ) {
            
            if(u.getRoom().getRoomStatusType().getRoomStatusTypeID().equals("LTTP004")) 
                jPanel4.add(u); 
        }
        jPanel4.revalidate();  
        jPanel4.repaint();  
    } 
    
    
    private void btnTatCaMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jPanel4.removeAll();
        for( UI_Phong u : ds_UIPhong ) {
            jPanel4.add(u); 
        }
        jPanel4.revalidate();  
        jPanel4.repaint();  
    } 

    private void btnXoaPhongMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        ArrayList<Room> roomSelects = new ArrayList<Room>(); 
        for( UI_Phong u : ds_UIPhong ) {
            if( u.isSelect() ) 
                roomSelects.add(u.getRoom()); 
        }
        if( roomSelects.isEmpty() ) {
            JOptionPane.showMessageDialog(rootPane, "Chọn phòng để xóa!");
            return; 
        }

        int luaChon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa?", "", JOptionPane.YES_NO_OPTION);
        if(luaChon==0) {
            for( UI_Phong u : ds_UIPhong ) {
                if( u.isSelect() ) 
                    new RoomClient().delete(u.getRoom().getRoomID());
            }
        }
        loadData();
    }

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnThemMoiMouseReleased(java.awt.event.MouseEvent evt) {
        txtMaPhong.setText(new RoomClient().getMaPhong()); 
        cbbTrangThai.setSelectedItem("Bảo trì");
        txtTenPhong.setText( "Phòng "+ txtMaPhong.getText()); 
        btnLuu.setText("Lưu");
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-save-25.png")));
    }

    private void btnTimKiemMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        if( txtMaPhongTK.getText().isBlank() ){
            String status = (String) cbbTrangThaiTK.getSelectedItem();
            String type = (String) cbbLoaiPhongTK.getSelectedItem(); 
            
            jPanel4.removeAll();
            for( UI_Phong u : ds_UIPhong ) {
                String roomType = u.getRoom().getRoomType().getRoomTypeName(); 
                String roomStatus = u.getRoom().getRoomStatusType().getRoomStatusTypeName();  
                if( (type.equalsIgnoreCase(roomType) || type.equalsIgnoreCase("Tất cả")) 
                     && (status.equalsIgnoreCase(roomStatus) || status.equalsIgnoreCase("Tất cả")) )
                    jPanel4.add(u); 
            }
            jPanel4.revalidate();  
            jPanel4.repaint(); 
        } 
        
         
        else {
            cbbTrangThaiTK.setSelectedIndex(0);
            cbbLoaiPhongTK.setSelectedIndex(0);
            jPanel4.removeAll();
            for( UI_Phong u : ds_UIPhong ) {
                if( u.getRoom().getRoomID().equals(txtMaPhongTK.getText()) ){
                    jPanel4.add(u); 
                    break; 
                } 
            }
            jPanel4.revalidate();  
            jPanel4.repaint();  
        }
        
        
    } 

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 


    
    private void btnLuuMouseReleased(java.awt.event.MouseEvent evt) { 
        
        if(checkData()) {
            try {
                Room phong = new Room(); 
                phong.setRoomID(txtMaPhong.getText());
                phong.setRoomName(txtTenPhong.getText());
                phong.setDescription(txtMoTa.getText());

                String type = cbbLoaiPhong.getSelectedItem()+""; 
                String status = cbbTrangThai.getSelectedItem()+""; 

                String IDtype="", IDstatus = ""; 
                if(type.equals("Giường đơn")) IDtype = "LP001";
                else if(type.equals("Giường đôi")) IDtype = "LP002";
                else if(type.equals("Giường đôi lớn")) IDtype = "LP003";

                if(status.equals("Trống")) IDstatus = "LTTP001"; 
                else if(status.equals("Đang sử dụng")) IDstatus = "LTTP002"; 
                else if(status.equals("Đã đặt")) IDstatus = "LTTP003"; 
                else if(status.equals("Bảo trì")) IDstatus = "LTTP004"; 
                else if(status.equals("Dọn dẹp")) IDstatus = "LTTP005"; 


                double price = Double.parseDouble(txtGia.getText()); 

                phong.setRoomStatusType(new RoomStatusType(IDstatus, status));
                phong.setRoomType(new RoomType(IDtype, type, price));

                if(btnLuu.getText().equals("Lưu"))
                    new RoomClient().add(phong); 
                else 
                    new RoomClient().update(phong); 

                txtMaPhong.setText("");
                txtTenPhong.setText("");
                txtGia.setText("");
                cbbLoaiPhong.setSelectedIndex(0);
                cbbTrangThai.setSelectedIndex(0);
                loadData(); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    } 

    private void btnXoaPhongActionPerformed(java.awt.event.ActionEvent evt) { 
   
    } 
    
    private javax.swing.JButton btnBaoTri;
    private javax.swing.JButton btnDaDat;
    private javax.swing.JButton btnDangSuDung;
    private javax.swing.JButton btnDonDep;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTrong;
    private javax.swing.JButton btnXoaPhong;
    private javax.swing.JComboBox<String> cbbLoaiPhong;
    private javax.swing.JComboBox<String> cbbLoaiPhongTK;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThaiTK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMaPhongTK;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenPhong;

}
