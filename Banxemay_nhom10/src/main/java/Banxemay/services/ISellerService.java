package Banxemay.services;

import java.util.List;

import Banxemay.models.Seller;

public interface ISellerService {
	void insert(Seller seller);

	void update(Seller seller);

	void delete(int id);
	
	List<Seller> findAll();
}
