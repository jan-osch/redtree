package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.uj.jg.catalogue.domain.products.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
