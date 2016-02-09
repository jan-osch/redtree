package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.products.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> listAllProducts();

    Product getProductById(Long id);

    Product saveOrUpdate(Product product);

    void deleteProduct(Long id);

    void createNewProduct(String name, String description, Long categoryId, String imageUrl);

    Product findByName(String name);
}
