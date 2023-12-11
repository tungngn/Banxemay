package Banxemay.DAO;

import java.util.List;

import Banxemay.models.CategoryModels;

public interface ICategoryDAO {
	
	//định nghĩa các phuong thuc
	List<CategoryModels> findAll();
	
	void insert(CategoryModels model);
	
	CategoryModels findOne(int id);
	
	void update(CategoryModels model);

	void delete(int id);
	
}
