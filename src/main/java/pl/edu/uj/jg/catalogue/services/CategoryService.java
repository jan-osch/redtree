package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.catalogue.domain.products.Category;

public interface CategoryService {
    Category createRootCategory(String name);

    void createSubcategory(Long parentId, String subcategoryName);

    void createLeafCategory(Long parentId, String leafCategoryName);

    void changeParent(Long id, Long newParentId);

    void changeParentForLeafCategory(Long id, Long newParentId);

    void deleteCategory(Long id);

    void deleteLeafCategory(Long id);
}
