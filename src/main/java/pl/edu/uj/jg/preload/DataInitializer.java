package pl.edu.uj.jg.preload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.uj.jg.catalogue.domain.products.Category;
import pl.edu.uj.jg.catalogue.domain.products.LeafCategory;
import pl.edu.uj.jg.catalogue.repositories.CategoryRepository;
import pl.edu.uj.jg.catalogue.repositories.IntegerAttributeRepository;
import pl.edu.uj.jg.catalogue.repositories.IntegerFeatureRepository;
import pl.edu.uj.jg.catalogue.services.ProductService;

@Component
public class DataInitializer {

    private ProductService productService;
    private IntegerAttributeRepository integerAttributeRepository;
    private IntegerFeatureRepository integerFeatureRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setIntegerFeatureRepository(IntegerFeatureRepository integerFeatureRepository) {
        this.integerFeatureRepository = integerFeatureRepository;
    }

    @Autowired
    public void setIntegerAttributeRepository(IntegerAttributeRepository integerAttributeRepository) {
        this.integerAttributeRepository = integerAttributeRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void preloadData() {
        preloadCategories();
    }

    private void preloadCategories() {
        Category beers = new Category();
        beers.setName("Beers");

        Category ales = new Category();
        ales.setName("Ale");
        beers.addSubcategory(ales);

        String alesLeafs[] = {"American Ale", "Mild Ale", "Old Ale", "Irish Ale"};

        for (String name : alesLeafs) {
            ales.addSubcategory(createLeafCategory(name));
        }

        String subcategories[] = {"Oatmeal Stout", "IPA", "Weizen", "Pilzner", "Barley"};

        for (String name : subcategories) {
            beers.addSubcategory(createLeafCategory(name));
        }

        categoryRepository.save(beers);
    }

    private LeafCategory createLeafCategory(String name) {
        LeafCategory oatmeal = new LeafCategory();
        oatmeal.setName(name);
        return oatmeal;
    }
}
