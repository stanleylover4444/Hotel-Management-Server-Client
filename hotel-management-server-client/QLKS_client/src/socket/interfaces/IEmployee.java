package socket.interfaces;

import java.util.List;

import entity.Employee;

public interface IEmployee extends Interfaces<Employee, String>{
 public List<Employee> getListEmpQuit();
    public List<Employee> getListEmpStay();
    public List<Employee> getListEmpGender(String gender);
    public List<Employee> getAllEmpType(String idType);
    public Employee findEmpCCCD(String cccd);
}
