package pl.edu.uj.jg.services;

import pl.edu.uj.jg.domain.products.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveOrUpdate(Product product);
    void deleteProduct(Integer id);
}
