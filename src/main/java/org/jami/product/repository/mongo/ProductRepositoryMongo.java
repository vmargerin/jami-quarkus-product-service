package org.jami.product.repository.mongo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.bson.types.ObjectId;
import org.jami.product.model.Product;
import org.jami.product.repository.ProductRepository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class ProductRepositoryMongo implements PanacheMongoRepository<Product>, ProductRepository {

	@Override
	public Product getById(String id) {
		return findById(new ObjectId(id));
	}

	@Override
	public List<Product> getAll() {
		return findAll().list();
	}

	@Override
	public void create(Product product) {
		persist(product);
	}

}
