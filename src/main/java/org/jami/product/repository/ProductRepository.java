package org.jami.product.repository;

import java.util.List;

import org.jami.product.model.Product;

public interface ProductRepository {

	Product getById(String id);

	List<Product> getAll();

	void create(Product product);

}
