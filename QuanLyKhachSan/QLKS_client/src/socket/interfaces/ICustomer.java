package socket.interfaces;

import java.util.ArrayList;
import java.util.List;

import entity.Customer;

public interface ICustomer extends Interfaces<Customer, String> {
    Customer getCustomerByCCCD(String cccd);
    ArrayList<Customer> getalltbKhachHang();
    List<Customer> getAllEmpType(String idType);
    List<Customer> getListEmpGender(String gender);
}
