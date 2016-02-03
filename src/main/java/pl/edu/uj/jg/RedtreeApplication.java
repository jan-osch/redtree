package pl.edu.uj.jg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.edu.uj.jg.domain.Account;
import pl.edu.uj.jg.domain.Product;
import pl.edu.uj.jg.domain.Rating;
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

        Account account = new Account("stefan");

        Product product = new Product("piwko", "dobre");

        Rating rejting = new Rating((float) 5.0, product, account);

        ProductService productService = ctx.getBean(ProductService.class);

        productService.saveOrUpdate(product);
    }
}
