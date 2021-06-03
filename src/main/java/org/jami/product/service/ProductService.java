package org.jami.product.service;

import java.util.List;

import org.jami.product.model.Product;

public interface ProductService {

	Product getById(final String id);

	List<Product> getAll();

	void create(final Product product);
}
