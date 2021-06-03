package org.jami.product.resource;

import java.net.URI;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jami.product.model.Product;
import org.jami.product.service.ProductService;

@Path("/products")
@RequestScoped
@RolesAllowed({ "user" })
public class ProductResource {

	@Inject
	private ProductService productService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{productId}")
	public Response getProductById(@PathParam(value = "productId") String id) {
		final Product product = this.productService.getById(id);
		return Response.ok(product).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public Response getAllProducts() {
		final List<Product> products = this.productService.getAll();
		return Response.ok(products).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProduct(@Valid final Product product) {
		this.productService.create(product);
		return Response.created(URI.create("")).build();
	}
}
