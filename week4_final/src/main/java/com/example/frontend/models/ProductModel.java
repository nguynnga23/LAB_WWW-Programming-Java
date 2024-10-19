package com.example.frontend.models;

import com.example.backend.repositories.entities.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private final String ADD_URL = "http://localhost:8080/week04-1.0-SNAPSHOT/api/products";
    private final String GET_ALL_URL = "http://localhost:8080/week04-1.0-SNAPSHOT/api/products";
    public void createProduct(Product product) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);

            Response response = target.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(product, MediaType.APPLICATION_JSON));

            if (response.getStatus() == 201) {
                System.out.println("Product created successfully.");
            } else {
                System.out.println("Failed to create product: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(GET_ALL_URL);

            Response response = target.request().get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                products = response.readEntity(new GenericType<List<Product>>() {});
            } else {
                System.out.println("Failed to fetch products: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
