package pl.edu.uj.jg.catalogue.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.products.Product;
import pl.edu.uj.jg.catalogue.repositories.LeafCategoryRepository;
import pl.edu.uj.jg.catalogue.repositories.ProductRepository;
import pl.edu.uj.jg.catalogue.services.ProductService;

import java.util.Collection;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private LeafCategoryRepository leafCategoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setLeafCategoryRepository(LeafCategoryRepository leafCategoryRepository) {
        this.leafCategoryRepository = leafCategoryRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<Product> listAllProducts() {
        return (Collection<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    @Override
    public void createNewProduct(String name, String description, Long categoryId, String imageUrl) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setCategory(leafCategoryRepository.findOne(categoryId));
        saveOrUpdate(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
