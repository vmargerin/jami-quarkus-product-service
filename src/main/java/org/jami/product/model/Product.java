package org.jami.product.model;

import javax.validation.constraints.NotBlank;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection = "products")
public class Product {

	@BsonRepresentation(BsonType.OBJECT_ID)
	private String id;

	@NotBlank(message = "Product name cannot be blank")
	private String name;

	@NotBlank(message = "Product description cannot be blank")
	private String description;

	public Product() {
	}

	public Product(final String id, final String name, final String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
