package Banxemay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Banxemay.models.UserRoles;
import Banxemay.models.Users;

public class UserDAOImpl implements IUserDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	

	@Override
	public List<Users> findAll() {
		List<Users> userList = new ArrayList<Users>();
		String sql="select users.userID,users.email,users.fullname,users.image,users.username,users.phone,users.status,users.code,users.roleid"
				+ "from users\r\n"
				+ "INNER JOIN  UserRoles ON Users.roleId = UserRoles.roleID";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserRoles userRoles = userRoleService.finOne(rs.getInt("roleId"));
				Users user = new Users();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				//user.setCode(rs.getInt("code"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRoles(userRoles);
				user.setStatus(rs.getInt("status"));
				
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public Users findOne(int id) {
		String sql="select users.userID,users.email,users.fullname,users.image,users.username,users.password"
				+"from users\r\n"
				+"INNER JOIN UserRoles ON Users.roleid = UserRoles.roleId\r\n"
				+ "where users.userID=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserRoles userRoles = userRoleService.findOne(rs.getInt("roleid"));
				Users user = new Users();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				//user.setCode(rs.getInt("code"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRoles(userRoles);
				user.setStatus(rs.getInt("status"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public Users findOne(String username) {
		String sql="select users.userID,users.email,users.fullname,users.image,users.username,users.password"
				+"from users\r\n"
				+"INNER JOIN UserRoles ON Users.roleid = UserRoles.roleId\r\n"
				+ "where users.username=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserRoles userRoles = userRoleService.findOne(rs.getInt("roleid"));
				Users user = new Users();
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				//user.setCode(rs.getInt("code"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setRoles(userRoles);
				user.setStatus(rs.getInt("status"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Users user) {
		String sql ="Insert INTO users (email,username,fullname,password,image,phone,status,roleid) values (?,?,?,?,?,?,?,?)";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImage());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getStatus());
			ps.setInt(8, user.getRoles().getRoleid());
			//ps.setInt(9, user.getUserid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertregister(Users user) {
		String sql ="Insert INTO users(email,username,fullname,password,status,roleid,code) Values (?,?,?,?,?,?,?)";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getStatus());
			ps.setInt(6, user.getRoleid());
			ps.setInt(7, user.getUserid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Users user) {
		String sql ="Update users set email=?,username=?,fullname=?,password=?,image=?,phone=?,status=?,code=?,roleid=?,isSeller=?,isAdmin=?"
				+ "where userID=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImage());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getStatus());
			ps.setInt(8, user.getRoles().getRoleid());
			ps.setInt(9, user.getUserid());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatestatus(Users user) {
		String sql = "UPDATE [Users] SET status=?, code=? WHERE email = ?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getStatus());
			ps.setString(2, user.getCode());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from users where userID=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "Select * From users where username=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "Select * From users where username=?";
		try {
			new DBConnection();
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

}
