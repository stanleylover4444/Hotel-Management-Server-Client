package socket;

// Lớp enum RequestType định nghĩa các loại yêu cầu mà client gửi đến server
public enum RequestType {
    LOGIN ("login"), // Đăng nhập
    GET_EMPLOYEE ("get_employee"),
    ADD_ROOM ("add_room"), // Thêm phòng
    BOOK_ROOM ("book_room"); // Đặt phòng
//    LOGOUT, // Đăng xuất
//    GET_ROOMS, // Lấy danh sách phòng
//    GET_ROOM, // Lấy thông tin phòng
//    UPDATE_ROOM, // Cập nhật thông tin phòng
//    DELETE_ROOM, // Xóa phòng
//    GET_CUSTOMERS, // Lấy danh sách khách hàng
//    GET_CUSTOMER, // Lấy thông tin khách hàng
//    ADD_CUSTOMER, // Thêm khách hàng
//    UPDATE_CUSTOMER, // Cập nhật thông tin khách hàng
//    DELETE_CUSTOMER, // Xóa khách hàng
//    GET_SERVICES, // Lấy danh sách dịch vụ
//    GET_SERVICE, // Lấy thông tin dịch vụ
//    ADD_SERVICE, // Thêm dịch vụ
//    UPDATE_SERVICE, // Cập nhật thông tin dịch vụ
//    DELETE_SERVICE, // Xóa dịch vụ
//    GET_BILLS, // Lấy danh sách hóa đơn
//    GET_BILL, // Lấy thông tin hóa đơn
//    ADD_BILL, // Thêm hóa đơn
//    UPDATE_BILL, // Cập nhật thông tin hóa đơn
//    DELETE_BILL, // Xóa hóa đơn
//    GET_BILL_DETAILS, // Lấy danh sách chi tiết hóa đơn
//    GET_BILL_DETAIL, // Lấy thông tin chi tiết hóa đơn
//    ADD_BILL_DETAIL, // Thêm chi tiết hóa đơn
//    UPDATE_BILL_DETAIL, // Cập nhật thông tin chi tiết hóa đơn
//    DELETE_BILL_DETAIL, // Xóa chi tiết hóa đơn
//    GET_ROOM_TYPES, // Lấy danh sách loại phòng
//    GET_ROOM_TYPE, // Lấy thông tin loại phòng
//    ADD_ROOM_TYPE, // Thêm loại phòng
//    UPDATE_ROOM_TYPE, // Cập nhật thông tin loại phòng
//    DELETE_ROOM_TYPE, // Xóa loại phòng
//    GET_ROOM_STATUS, // Lấy danh sách trạng thái phòng
//    GET_ROOM_STATUS_TYPE, // Lấy thông tin trạng thái phòng
//    ADD_ROOM_STATUS_TYPE; // Thêm trạng thái phòng

	private String type;
	private RequestType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
