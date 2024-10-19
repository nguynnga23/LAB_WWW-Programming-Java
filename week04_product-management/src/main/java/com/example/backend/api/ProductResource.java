package com.example.backend.api;

import com.example.backend.business.ProductBeanRemote;
import com.example.backend.repositories.entities.Product;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
}
