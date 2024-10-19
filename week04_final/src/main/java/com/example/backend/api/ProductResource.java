package com.example.backend.api;

import com.example.backend.business.ProductBeanRemote;
import com.example.backend.repositories.entities.Product;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBean;

    @GET
    public Response getAllProducts() {
        return Response.ok(productBean.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") int id) {
        return Response.ok(productBean.findById(id)).build();
    }

    @POST
    public Response createProduct(Product product) {
        productBean.add(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        productBean.deleteById(id);
        return Response.ok("Product deleted successfully").build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, Product product) {
        product.setId(id);
        productBean.update(product);
        return Response.ok("Product updated successfully").build();
    }
}
