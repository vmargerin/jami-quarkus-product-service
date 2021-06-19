package org.jami.product.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import org.jami.product.model.Product;
import org.jami.product.service.ProductService;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.quarkus.test.security.TestSecurity;

@QuarkusTest
@TestSecurity(user = "testUser", roles = { "user" })
@TestHTTPEndpoint(ProductResource.class)
public class ProductResourceTest {

	@InjectMock
	ProductService productService;

	private static final String PRODUCT_ID = "1234";

	@Test
	public void getProductById() {
		final Product product = new Product(PRODUCT_ID, "Abondance", "");
		when(productService.getById(PRODUCT_ID)).thenReturn(product);
		given().when().get(PRODUCT_ID).then().statusCode(200).body("id", equalTo(product.getId())).body("name",
				equalTo(product.getName()));
	}

}
