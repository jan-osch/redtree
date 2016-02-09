package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.products.Category;
import pl.edu.uj.jg.catalogue.domain.products.LeafCategory;

public interface CategoryService {
    Category createRootCategory(String name);

    Category createSubcategory(Long parentId, String subcategoryName);

    LeafCategory createLeafCategory(Long parentId, String leafCategoryName);

    void changeParent(Long id, Long newParentId);

    void changeParentForLeafCategory(Long id, Long newParentId);

    void deleteCategory(Long id);

    void deleteLeafCategory(Long id);

    Category getCategoryByName(String name);

    LeafCategory getLeafCategoryByName(String name);
}
