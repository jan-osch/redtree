package pl.edu.uj.jg.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.uj.jg.domain.products.Product;
import pl.edu.uj.jg.exceptions.ProductEmptyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Profile("pureMemory")
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> productMap;
    private Integer currentKey;


    public ProductServiceImpl() {
        this.currentKey = 0;
        loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(this.productMap.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return this.productMap.get(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        if (product != null) {
            if (product.getId() == null) {
                product.setId(getNextKey());
            }
            this.productMap.put(product.getId(), product);
            return product;
        }
        throw new ProductEmptyException();
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productMap.remove(id);
    }

    private Integer getNextKey() {
        return this.currentKey++;
    }

    private void loadProducts() {
        this.productMap = new HashMap<>();

        Product product1 = new Product();

        product1.setId(getNextKey());
        product1.setDescription("Some description");

        this.productMap.put(product1.getId(), product1);

        Product product2 = new Product();
        product2.setId(getNextKey());
        product2.setDescription("Some description 2");

        this.productMap.put(product2.getId(), product2);

        Product product3 = new Product();
        product3.setId(getNextKey());
        product3.setDescription("Some description 3");

        this.productMap.put(product3.getId(), product3);

        Product product4 = new Product();
        product4.setId(getNextKey());
        product4.setDescription("Some description 4");

        this.productMap.put(product4.getId(), product4);
    }
}
