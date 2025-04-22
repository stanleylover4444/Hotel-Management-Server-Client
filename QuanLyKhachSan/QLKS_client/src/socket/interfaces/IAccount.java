package socket.interfaces;

import entity.Account;

public interface IAccount extends Interfaces<Account, String>{
    boolean checkLogin(String username, String password);
    String findPass(String username);
}
