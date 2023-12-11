package Banxemay.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Banxemay.models.CategoryModels;

public class CategoryDAOimpl implements ICategoryDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CategoryModels> findAll() {
		
		//xu li du lieu hien thi tat ca category
		List<CategoryModels> list = new ArrayList<CategoryModels>();
		String sql = "Select * from category";
		
			try {
				new DBConnection();
				Connection conn = DBConnection.getConnection(); //Kết nối cơ sở dữ liệu
				PreparedStatement ps = conn.prepareStatement(sql); //Ném câu lệnh sql bằng phát biểu preparestatement
				ResultSet rs = ps.executeQuery(); //thực thi câu query và trả về Resultset
				while (rs.next()) { //duyệt từng dòng trong ResultSet trả về danh sách đối tượng
					
					CategoryModels category = new CategoryModels();
					category.setCateID(rs.getInt("CategoryID"));
					category.setCateName(rs.getString("CategoryName"));
					category.setImage(rs.getString("icon"));
					list.add(category);
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return list;
	}

	@Override
	public void insert(CategoryModels model) {
		//xu ly them category
		String sql = "insert into category(CategoryName, icon) values (?,?)";
		try {
			new DBConnection();
			conn = DBConnection.getConnection(); //Kết nối cơ sở dữ liệu
			ps = conn.prepareStatement(sql); //Ném câu lệnh sql bằng phát biểu preparestatement
			//gan gia tri cho tham so
			ps.setString(1, model.getCateName()); //thiet lap gia tri cho tham so ? thu nhat
			ps.setString(2, model.getImage()); //thiet lap gia tri cho tham so ? thu hai
			ps.executeUpdate(); //thực thi câu query và trả về Resultset
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(CategoryModels model) {
		String sql ="update Category set CategoryName=?, icon=? where CategoryID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection(); //Kết nối cơ sở dữ liệu
			ps = conn.prepareStatement(sql); //Ném câu lệnh sql bằng phát biểu preparestatement
			//gan gia tri cho tham so
			ps.setString(1, model.getCateName()); //thiet lap gia tri cho tham so ? thu nhat
			ps.setString(2, model.getImage()); //thiet lap gia tri cho tham so ? thu hai
			ps.setInt(3, model.getCateID());
			
			ps.executeUpdate(); //thực thi câu query và trả về Resultset
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public CategoryModels findOne(int id) {
		//xu ly du lieu lay ra 1 doi tuong category
		String sql = "select * from category where CategoryID=?";
		CategoryModels model = new CategoryModels();
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				model.setCateID(rs.getInt("CategoryID"));
				model.setCateName(rs.getString("CategoryName"));
				model.setImage(rs.getString("icon"));
			}
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}


	@Override
	public void delete(int id) {
		String sql = "delete from Category where CategoryID=?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection(); //Kết nối cơ sở dữ liệu
			ps = conn.prepareStatement(sql); //Ném câu lệnh sql bằng phát biểu preparestatement
			//gan gia tri cho tham so
			ps.setInt(1, id);
			ps.executeUpdate(); //thực thi câu query và trả về Resultset
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
