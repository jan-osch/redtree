package pl.edu.uj.jg.catalogue.repositories.features;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import pl.edu.uj.jg.catalogue.domain.products.features.AbstractFeature;

import java.util.List;

@NoRepositoryBean
public interface GenericFeatureRepository<T extends AbstractFeature> extends CrudRepository<T, Long> {
    List<T> findByProductId(@Param("product_id") Long id);
}
