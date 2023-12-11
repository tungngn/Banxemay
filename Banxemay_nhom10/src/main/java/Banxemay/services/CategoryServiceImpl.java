package Banxemay.services;

import java.util.List;

import Banxemay.DAO.CategoryDAOimpl;
import Banxemay.DAO.ICategoryDAO;
import Banxemay.models.CategoryModels;

public class CategoryServiceImpl implements ICategoryService {
	//goi cac phuong thuc trong DAO
	ICategoryDAO cateDao = new CategoryDAOimpl();
	
	@Override
	public List<CategoryModels> findAll() {
		//xu ly logic
		//goi va truyen cho DAO
		return cateDao.findAll();
	}

	@Override
	public void insert(CategoryModels model) {
		//xu ly logic
		//goi va truyen cho DAO
		cateDao.insert(model);
		
	}

	@Override
	public CategoryModels findOne(int id) {
		
		return cateDao.findOne(id);
	}

	@Override
	public void update(CategoryModels model) {
		CategoryModels oldcate = cateDao.findOne(model.getCateID());
		oldcate.setCateID(model.getCateID());
		oldcate.setCateName(model.getCateName());
		oldcate.setImage(model.getImage());
		
		cateDao.update(oldcate);
		
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
		
	}

}
