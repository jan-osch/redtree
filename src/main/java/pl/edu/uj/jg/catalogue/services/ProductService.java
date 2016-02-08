package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.products.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveOrUpdate(Product product);
    void deleteProduct(Integer id);
}
