package com.codegym.service;

import com.codegym.model.Config;
import com.codegym.model.User;
import com.codegym.utils.FileUtils;

import java.util.List;
import java.util.Objects;

public class UserService implements IUserService{
    private final String path = "./data/user.txt";
    @Override
    public List<User> getAllUsers() {
        return FileUtils.readFile(path, Config.TYPE_USER);
    }

    @Override
    public User findUserByName(String name) {
        List<User> userList = FileUtils.readFile(path, Config.TYPE_USER);
        for (User user : userList) {
            if (Objects.equals(user.getName(), name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findUserByAddress(String address) {
        List<User> userList = FileUtils.readFile(path, Config.TYPE_USER);
        for (User user : userList) {
            if (Objects.equals(user.getAddress(), address)) {
                return user;
            }
        }
        return null;
    }


    @Override
    public void updateUserById(long id, User user) {
        List<User> userList = FileUtils.readFile(path, Config.TYPE_USER);
        for (User user1 : userList) {
            if (user1.getId() == id) {
                user1.setName(user.getName());
                user1.setAddress(user.getAddress());
                user1.seteGender(user.geteGender());
                user1.seteRole(user.geteRole());
                user1.setDob(user.getDob());
            }
        }
        FileUtils.writeFile(path, userList);
    }

    @Override
    public void deleteUserById(long id) {
        List<User> userList = FileUtils.readFile(path, Config.TYPE_USER);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.remove(i);
                break;
            }
        }
        FileUtils.writeFile(path, userList);
    }

    @Override
    public void addUser(User user) {
        List<User> userList = FileUtils.readFile(path, Config.TYPE_USER);
        userList.add(user);
        FileUtils.writeFile(path, userList);
    }
}
