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
    private final String ADD_URL = "http://localhost:8080/week4_final-1.0-SNAPSHOT/api/products";
    private final String GET_ALL_URL = "http://localhost:8080/week4_final-1.0-SNAPSHOT/api/products";
    private final String GET_BY_ID_URL = "http://localhost:8080/week4_final-1.0-SNAPSHOT/api/products/id";
    private final String DELETE_BY_ID_URL = "http://localhost:8080/week4_final-1.0-SNAPSHOT/api/products/id";


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
            // Tạo target cho URL API để lấy tất cả sản phẩm
            WebTarget target = client.target(GET_ALL_URL);

            // Gửi yêu cầu GET
            Response response = target.request().get();

            // Kiểm tra nếu mã trạng thái là 200 (OK)
            if (response.getStatus() == 200) {
                // Đọc và chuyển đổi dữ liệu trả về thành danh sách sản phẩm
                products = response.readEntity(new GenericType<List<Product>>() {});
            } else {
                // In ra thông báo lỗi nếu trạng thái không phải 200
                System.out.println("Failed to fetch products. HTTP error code: " + response.getStatus());
            }
        } catch (Exception e) {
            // Bắt và in ra các lỗi phát sinh khi gửi yêu cầu
            e.printStackTrace();
        }

        return products; // Trả về danh sách sản phẩm (có thể rỗng nếu thất bại)
    }

    public Product getProductById(int id) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(GET_BY_ID_URL + id)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(Product.class);
        } else {
            throw new RuntimeException("Failed to get product with ID: " + id);
        }
    }

    public String deleteProductById(int id) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(DELETE_BY_ID_URL + id)
                .request()
                .delete();
        if (response.getStatus() == 200) {
            return "Product deleted successfully";
        } else {
            throw new RuntimeException("Failed to delete product with ID: " + id);
        }
    }
}
