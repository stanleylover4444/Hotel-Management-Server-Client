CREATE TABLE `taikhoan` (
  `tenNV` varchar(50) DEFAULT NULL,
  `taiKhoan` varchar(50) NOT NULL,
  `matKhau` varchar(60) DEFAULT NULL,
  `vaiTro` varchar(50) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `taikhoan` (`tenNV`, `taiKhoan`, `matKhau`, `vaiTro`, `trangThai`, `SDT`) VALUES
('Admin', 'admin', '$2a$12$Y87zSnx.tpFvieylSeXuo.agjb7swi3UVnoo6KVMY9xP5STj4zJhm', 'Admin', 1, '0795528073'),
('Nguyễn Trương Thành Danh', 'thanhdanh', '$2a$12$Y87zSnx.tpFvieylSeXuo.agjb7swi3UVnoo6KVMY9xP5STj4zJhm', 'Nhân viên lễ tân', 1, '0795528073');
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`taiKhoan`);

CREATE TABLE `DichVu` (
  `maDichVu` varchar(50) NOT NULL,
  `tenDichVu` varchar(100) DEFAULT NULL,
  `soLuong` int(11) NOT NULL DEFAULT 0,
  `gia` double NOT NULL DEFAULT 0

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `DichVu` (`maDichVu`, `tenDichVu`, `soLuong`, `gia`) VALUES
('DV1', 'Nước ngọt Coca-Cola 330ml', 36, 10.000),
('DV2', 'Bánh mì thịt nướng', 50, 20000),
('DV3', 'Cà phê đen sữa đá', 20, 25000),
('DV4', 'Combo bắp rang Coca-Cola', 30, 50000),
('DV5', 'Nước cam ép lạnh', 15, 15000),
('DV6', 'Bánh pizza hải sản', 8, 120000),
('DV7', 'Combo bắp rang và nước ngọt', 25, 45000),
('DV8', 'Cà phê sữa đá', 40, 20000),
('DV9', 'Sinh tố trái cây tươi', 12, 30000),
('DV10', 'Hamburger gà cay', 10, 35000);

ALTER TABLE `DichVu`
  ADD PRIMARY KEY (`maDichVu`);
 
 
 
 CREATE TABLE `KhachHang` (
  `maKhachHang` varchar(50) NOT NULL,
  `tenKhachHang` varchar(50) DEFAULT NULL,
  `soDienThoai` varchar(50) DEFAULT NULL,
  `chungMinhThu` varchar(150) DEFAULT Null,
   `diaChi` varchar(50) DEFAULT Null,
  `gioiTinh` BOOLEAN DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



INSERT INTO `KhachHang` (`maKhachHang`, `tenKhachHang`, `soDienThoai`, `chungMinhThu`, `diaChi`, `gioiTinh`)
VALUES 
    ('KH4', 'Nguyễn Văn A', '0123456789', '987654321', '123 Đường ABC, Quận XYZ', TRUE),
    ('KH5', 'Trần Thị B', '0987654321', '654321987', '456 Đường DEF, Quận UVW', FALSE),
    ('KH6', 'Lê Văn C', '0369852147', '159263487', '789 Đường GHI, Quận RST', TRUE),
    -- Thêm 27 hàng nữa ở đây với dữ liệu ngẫu nhiên
    ('KH7', 'Phạm Thị D', '0867539512', '258147369', '101 Đường JKL, Quận MNO', FALSE),
    ('KH8', 'Hoàng Văn E', '0657391824', '369852147', '202 Đường PQR, Quận STU', TRUE);




CREATE TABLE PhieuDatPhong (
    tongtiendichvu DOUBLE DEFAULT NULL,
    loaiPhong VARCHAR(255) DEFAULT NULL,
    taiKhoan VARCHAR(255) DEFAULT NULL,
    thoiGianNhanPhong TIMESTAMP DEFAULT NULL,
    soNguoi INT DEFAULT NULL,
    chungMinhThu VARCHAR(255) DEFAULT NULL,
    tinhTrangPhong VARCHAR(255) DEFAULT NULL,
    tenKhachHang VARCHAR(255) DEFAULT NULL,
    maPhong VARCHAR(255) DEFAULT NULL
);

ALTER TABLE `PhieuDatPhong`
  ADD PRIMARY KEY (`maPhong`);
 
CREATE TABLE `HoaDonDichVu` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NULL DEFAULT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

 
 CREATE TABLE `HoaDonPhong` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nguoiTao` varchar(50) NOT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE ChiTietHoaDonDichVu (
  `maHoaDonDichVu` varchar(50) NOT NULL,
  `maDichVu` varchar(50) NOT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE ChiTietHoaDonPhong (
  `maHoaDonPhong` varchar(50) NOT NULL,
  `maPhong` varchar(50) NOT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

