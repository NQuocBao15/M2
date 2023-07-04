package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IUserService {
// + Thêm 1 User
// + Sửa 1 user
// + Xóa 1 user
// + Tìm 1 user theo name, address
// + Tìm users theo ngày sinh, theo năm sinh, theo 1 khoảng thời gian
// + Sắp xếp  user theo name, ngày sinh
    List<User> getAllUsers();
    User findUserByName(String name);
    User findUserByAddress(String address);
    void updateUserById(long id, User user);
    void deleteUserById(long id);
    void addUser(User user);
}
