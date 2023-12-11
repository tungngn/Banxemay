package Banxemay.services;

import java.util.List;

import Banxemay.DAO.IUserDAO;
import Banxemay.DAO.UserDAOImpl;
import Banxemay.models.Users;

public class UserServiceImpl implements IUserService {
	IUserDAO userDao = new UserDAOImpl();

	@Override
	public List<Users> findAll() {
		
		return userDao.findAll();
	}

	@Override
	public Users findOne(int id) {
		
		return userDao.findOne(id);
	}

	@Override
	public Users findOne(String username) {
		
		return userDao.findOne(username);
	}

	@Override
	public void insert(Users user) {
		userDao.insert(user);
		
	}

	@Override
	public void update(Users user) {
		Users oldUser = userDao.findOne(user.getUserid());
		oldUser.setEmail(user.getEmail());
		oldUser.setFullname(user.getFullname());
		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(user.getPassword());
		oldUser.setPhone(user.getPhone());
		oldUser.setRoles(user.getRoles());
		oldUser.setStatus(user.getStatus());
		oldUser.setImage(user.getImage());
		userDao.update(user);
		
	}

	@Override
	public void updatestatus(Users user) {
		userDao.updatestatus(user);
		
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String code) {
		if (userDao.checkExistEmail(email)) {
			return false;
		}
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.insertregister(new Users(username, email, fullname, password, 0, code, 2));
		return true;
	}

	@Override
	public Users login(String username, String password) {
		Users user = this.findOne(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		 
		return userDao.checkExistUsername(username);
	}

}
