package Banxemay.services;

import java.util.List;

import Banxemay.models.Users;

public interface IUserService {
	// khai báo các hàm xử lý
	List<Users> findAll(); // hàm lấy toàn bộ user
	
	Users findOne(int id); // hàm lấy 01 đối tượng User theo ID
	
	Users findOne(String username); //hàm lấy 01 đối tượng User theo username
	
	void insert(Users user); //hàm thêm dữ liệu mới cho User
	
	void update(Users user); // hàm cập nhật 1 đối tượng User
	
	void updatestatus(Users user); // hàm dùng active tài khoản
	
	void delete(int id); //hàm xoá 1 đối tượng User
	
	boolean register(String email, String password, String username, String fullname, String code);
	
	Users login(String username, String password);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);

}
