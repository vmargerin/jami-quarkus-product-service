package org.jami.product.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jami.product.model.Product;
import org.jami.product.repository.ProductRepository;
import org.jami.product.service.ProductService;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductRepository productRepository;

	@Override
	public Product getById(final String id) {
		return this.productRepository.getById(id);
	}

	@Override
	public List<Product> getAll() {
		return this.productRepository.getAll();
	}

	@Override
	public void create(Product product) {
		this.productRepository.create(product);
	}

}
