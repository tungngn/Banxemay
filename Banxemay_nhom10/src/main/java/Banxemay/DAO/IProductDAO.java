package Banxemay.DAO;

import java.util.List;

import Banxemay.models.ProductModel;

public interface IProductDAO {
	
	List<ProductModel> findAll();
	List<ProductModel> find10Top();
	List<ProductModel> findAllByCID(int id, int index);
	List<ProductModel> findAllBySeller(int id, int index);
	List<ProductModel> findProductByCategory(int cateID);
	List<ProductModel> findAllPage(int indexp);
	
	int countAll();
	
	int countCID(int id);
	
	int countSell(int id);
	
	void insert(ProductModel model);
	
	void update(ProductModel model);
	
	void delete(int id);
	
	ProductModel findOne(int id);
	
	int countByCateID(int id);
	
	List<ProductModel> count();
	
	
	

}
