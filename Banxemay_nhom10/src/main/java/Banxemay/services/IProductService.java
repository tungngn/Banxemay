package Banxemay.services;

import java.util.List;

import Banxemay.models.CategoryModels;
import Banxemay.models.ProductModel;

public interface IProductService {
	
	void insert(ProductModel model);
	
	void update(ProductModel model);
	
	void delete(int id);
	
	ProductModel findOne(int id);
	List<ProductModel> find10Top();
	
	List<ProductModel> count();
	int countByCateID(int id);
	
	List<ProductModel> findAll();
	
	//List<ProductModel> findAllNew();
	
	List<ProductModel> findProductByCategory(int cateID);
	
	List<ProductModel> findAllByCID(int id, int index);
	
	List<ProductModel> findAllBySeller(int id, int index);
	
	List<ProductModel> findAllPage(int indexp);
	
	int countAll();
	
	int countCID(int id);
	
	int countSell(int id);

	void update(CategoryModels model);
	
	
	
	

}
