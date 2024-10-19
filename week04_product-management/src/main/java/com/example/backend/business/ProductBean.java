package backend.business;

import com.example.backend.repositories.entities.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class ProductBean implements ProductBeanRemote {
    @PersistenceContext(unitName = "lab_week_4")
    private EntityManager em;

    @Override
    public void add(Product product) {
        em.persist(product);
        try {
            em.persist(product);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return em.createNamedQuery("Product.findById", Product.class).getSingleResult();
    }

    public static void main(String[] args) {
        ProductBean bean = new ProductBean();
        Product product = new Product("Trung ga", "Rat la ngon", "img.img.img");
//        bean.add(product);
        System.out.println(bean.findAll());
    }
}
