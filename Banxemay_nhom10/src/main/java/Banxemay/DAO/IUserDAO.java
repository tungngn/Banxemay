package Banxemay.DAO;

import java.util.List;

import Banxemay.models.Users;

public interface IUserDAO {
	// khai báo các hàm xử lý của Dao
	
	List<Users> findAll(); // hàm lấy toàn bộ User
	
	Users findOne(int id); //hàm lấy 01 đối tượng User theo ID
	
	Users findOne(String username); //hàm lấy 01 đối tượng User theo username
	
	void insert(Users user); //hàm thêm dữ liệu mới cho User
	
	void insertregister(Users user); // hàm dùng cho register
	
	void update(Users user); //hàm cập nhật 1 đối tượng User
	
	void updatestatus(Users user); //hàm dùng active tài khoản
	
	void delete(int id); //hàm xoá 1 đối tượng User
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	

}
