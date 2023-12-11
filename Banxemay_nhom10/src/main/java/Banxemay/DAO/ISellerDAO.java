package Banxemay.DAO;

import java.util.List;

import Banxemay.models.Seller;

public interface ISellerDAO {
	void insert(Seller seller);

	void update(Seller seller);

	void delete(int id);

	List<Seller> findAll();
}
