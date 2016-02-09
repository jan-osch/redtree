package pl.edu.uj.jg.preload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.uj.jg.auth.domain.Role;
import pl.edu.uj.jg.auth.domain.User;
import pl.edu.uj.jg.auth.domain.UserCreateForm;
import pl.edu.uj.jg.auth.services.UserService;
import pl.edu.uj.jg.catalogue.domain.products.Category;
import pl.edu.uj.jg.catalogue.services.*;

import java.util.Optional;

@Component
public class DataInitializer {
    private CategoryService categoryService;
    private ProductService productService;
    private AccountService accountService;
    private UserService userService;
    private AttributeService attributeService;
    private FeatureService featureService;
    private RatingService ratingService;


    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Autowired
    public void setFeatureService(FeatureService featureService) {
        this.featureService = featureService;
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void initialize() {
        initializeUsers();
        initializeCategories();
        initializeAttributes();
        initializeProducts();
        initializeFeatures();
        initializeRatings();
    }

    private void initializeRatings() {
        Optional<User> userByEmail = userService.getUserByEmail("basia@uj");
        Long id = productService.findByName("Surly Cacao Bender").getId();
        if (userByEmail.isPresent()) {
            User user = userByEmail.get();
            ratingService.addRatingToProduct(id, (float) 9.0, user.getAccount().getId());
        }
    }

    private void initializeFeatures() {
        Long id = productService.findByName("Surly Cacao Bender").getId();
        featureService.addBooleanFeature(id, true, attributeService.getBooleanAttributeByName("Bottled").getId());
        featureService.addStringFeature(id, "USA", attributeService.getStringAttributeByName("Country").getId());
        featureService.addStringFeature(id, "Surly Brewing Company", attributeService.getStringAttributeByName("Brewery").getId());
        featureService.addIntegerFeature(id, 45, attributeService.getIntegerAttributeByName("IBU").getId());
    }

    private void initializeProducts() {
        productService.createNewProduct("Surly Cacao Bender",
                "Great cacao taste",
                categoryService.getLeafCategoryByName("Irish Ale").getId(),
                "http://res.cloudinary.com/ratebeer/image/upload/w_120,c_limit/beer_180113.jpg");
    }

    private void initializeAttributes() {
        attributeService.createStringAttribute("Country");
        attributeService.createStringAttribute("Brewery");
        attributeService.createNumberAttribute("IBU");
        attributeService.createBooleanAttribute("Bottled");
    }

    private void initializeCategories() {
        Category beers = categoryService.createRootCategory("beers");

        Category ale = categoryService.createSubcategory(beers.getId(), "Ale");

        categoryService.createLeafCategory(ale.getId(), "Indian Pale Ale");

        categoryService.createLeafCategory(ale.getId(), "Irish Ale");
    }

    private void initializeUsers() {
        UserCreateForm createForm = new UserCreateForm();
        createForm.setEmail("demo@localhost");
        createForm.setPassword("demo");
        createForm.setPasswordRepeated("demo");
        createForm.setRole(Role.ADMIN);
        userService.create(createForm);

        createForm = new UserCreateForm();
        createForm.setEmail("basia@uj");
        createForm.setPassword("basia");
        createForm.setPasswordRepeated("basia");
        createForm.setRole(Role.USER);

        accountService.createAccountForUser(userService.create(createForm), "Barbara's Account");

        createForm = new UserCreateForm();
        createForm.setEmail("web@shop.com");
        createForm.setPassword("webshop");
        createForm.setPasswordRepeated("webshop");
        createForm.setRole(Role.SHOP);
        userService.create(createForm);
    }
}
