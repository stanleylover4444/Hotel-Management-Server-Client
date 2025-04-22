package socket.interfaces;

import entity.CustomerType;

public interface ICustomerType{
    CustomerType findCusTypeID(String id);
    CustomerType findCusByName(String name);
}