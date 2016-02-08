package pl.edu.uj.jg.catalogue.controllers;

import pl.edu.uj.jg.catalogue.domain.products.Product;
import pl.edu.uj.jg.catalogue.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/product/";
    }

    @RequestMapping("/product/new")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @RequestMapping("/product/edit/{id}")
    public String createProduct(@PathVariable Integer id,  Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-form";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/" + savedProduct.getId();
    }
}
