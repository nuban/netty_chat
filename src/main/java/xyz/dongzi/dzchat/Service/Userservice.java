package xyz.dongzi.dzchat.Service;

import xyz.dongzi.dzchat.pojo.vo.User;

public interface Userservice {

    User login(String username, String password);
}
