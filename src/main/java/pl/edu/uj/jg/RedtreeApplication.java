package pl.edu.uj.jg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.edu.uj.jg.domain.products.Category;
import pl.edu.uj.jg.domain.products.LeafCategory;
import pl.edu.uj.jg.domain.products.features.IntegerAttribute;
import pl.edu.uj.jg.domain.products.features.IntegerFeature;
import pl.edu.uj.jg.domain.products.Product;
import pl.edu.uj.jg.domain.social.Account;
import pl.edu.uj.jg.domain.social.Review;
import pl.edu.uj.jg.repositories.CategoryRepository;
import pl.edu.uj.jg.repositories.IntegerAttributeRepository;
import pl.edu.uj.jg.repositories.IntegerFeatureRepository;
import pl.edu.uj.jg.repositories.ReviewRepository;
import pl.edu.uj.jg.services.ProductService;

@SpringBootApplication
public class RedtreeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RedtreeApplication.class, args);

        System.out.println("BEANS *********");
        System.out.println(ctx.getBeanDefinitionCount());
        for(String beanName : ctx.getBeanDefinitionNames()){
            System.out.println(beanName);
        }

        Product piwerko = new Product();
        piwerko.setDescription("dobre");
        piwerko.setName("piwerko");

        IntegerAttribute integerAttribute = new IntegerAttribute();
        integerAttribute.setName("wielgachnosc");

        Category napoje = new Category();
        napoje.setName("napoje");

        LeafCategory piwska = new LeafCategory();
        piwska.setName("piwska");

        napoje.addSubcategory(piwska);
        piwska.setParent(napoje);

        piwska.addProduct(piwerko);
        piwerko.setCategory(piwska);

        IntegerFeature integerFeature = new IntegerFeature();
        integerFeature.setValue(123);

        integerFeature.setProduct(piwerko);

        Account bogdan = new Account();
        bogdan.setName("Bogdan");

        Review review = new Review();
        review.setNow();
        review.setContent("srakowe trochem");
        review.setAccount(bogdan);
        review.setRatingSubject(piwerko);

        ProductService productService = ctx.getBean(ProductService.class);
        IntegerAttributeRepository integerAttributeRepository = ctx.getBean(IntegerAttributeRepository.class);
        IntegerFeatureRepository integerFeatureRepository = ctx.getBean(IntegerFeatureRepository.class);

        ReviewRepository reviewRepository = ctx.getBean(ReviewRepository.class);
        reviewRepository.save(review);

        CategoryRepository categoryRepository = ctx.getBean(CategoryRepository.class);
        Iterable<Category> all = categoryRepository.findAll();
        for(Category c: all){
            System.out.println(c.getSubcategories().toString());
        }

    }
}
