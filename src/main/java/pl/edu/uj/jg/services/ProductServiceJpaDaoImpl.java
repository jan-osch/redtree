package pl.edu.uj.jg.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.uj.jg.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpa")
public class ProductServiceJpaDaoImpl implements ProductService {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Product> listAllProducts() {
        EntityManager entityManager = getEntityManager();
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(Integer id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        Product persistedProduct = entityManager.merge(product);
        entityManager.getTransaction().commit();

        return persistedProduct;
    }

    @Override
    public void deleteProduct(Integer id) {
        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class,id));
        entityManager.getTransaction().commit();
    }

    private EntityManager getEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }
}
