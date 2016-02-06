package pl.edu.uj.jg.domain.products;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class LeafCategory extends AbstractCategory {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    Collection<Product> products;

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    private Collection<Product> getProductsInternally() {
        if (this.products == null) {
            this.products = new HashSet<Product>();
        }
        return this.products;
    }

    public void addProduct(Product product) {
        this.getProductsInternally().add(product);
    }

    public void removeProduct(Product product) {
        this.getProductsInternally().remove(product);
    }
}
