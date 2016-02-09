package pl.edu.uj.jg.catalogue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.uj.jg.catalogue.repositories.CategoryRepository;
import pl.edu.uj.jg.catalogue.services.ProductService;

import java.util.HashMap;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    private ProductService productService;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        LOGGER.debug("Index page requested");
        HashMap<String, Object> map = new HashMap<>();
        map.put("products", productService.listAllProducts());
        map.put("categories", categoryRepository.findAll());
        return new ModelAndView("index", map);
    }
}
