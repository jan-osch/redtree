package pl.edu.uj.jg.catalogue.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import pl.edu.uj.jg.catalogue.domain.products.features.AbstractFeature;

@NoRepositoryBean
public interface GenericFeatureRepository<T extends AbstractFeature> extends CrudRepository<T, Long> {
    T findByProductId(@Param("product_id")Long id);
}
