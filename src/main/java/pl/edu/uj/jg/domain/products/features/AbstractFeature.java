package pl.edu.uj.jg.domain.products.features;

import pl.edu.uj.jg.domain.base.BaseEntity;
import pl.edu.uj.jg.domain.products.Product;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractFeature extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
