package pl.edu.uj.jg.catalogue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.products.AbstractCategory;
import pl.edu.uj.jg.catalogue.domain.products.Category;
import pl.edu.uj.jg.catalogue.domain.products.LeafCategory;
import pl.edu.uj.jg.catalogue.repositories.CategoryRepository;
import pl.edu.uj.jg.catalogue.repositories.LeafCategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private LeafCategoryRepository leafCategoryRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public void setLeafCategoryRepository(LeafCategoryRepository leafCategoryRepository) {
        this.leafCategoryRepository = leafCategoryRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createRootCategory(String name) {
        Category category = createCategoryByName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void createSubcategory(Long parentId, String subcategoryName) {
        Category subcategory = createCategoryByName(subcategoryName);
        addAsSubcategoryToParent(parentId, subcategory);
        categoryRepository.save(subcategory);
    }

    @Override
    public void createLeafCategory(Long parentId, String leafCategoryName) {
        LeafCategory subcategory = createLeafCategoryByName(leafCategoryName);
        addAsSubcategoryToParent(parentId, subcategory);
        leafCategoryRepository.save(subcategory);
    }

    @Override
    public void changeParent(Long id, Long newParentId) {
        Category category = categoryRepository.findOne(id);
        removeOldParentAndAddNew(newParentId, category);
    }

    @Override
    public void changeParentForLeafCategory(Long id, Long newParentId) {
        LeafCategory category = leafCategoryRepository.findOne(id);
        removeOldParentAndAddNew(newParentId, category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public void deleteLeafCategory(Long id) {
        leafCategoryRepository.delete(id);
    }

    private Category createCategoryByName(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }

    private LeafCategory createLeafCategoryByName(String leafCategoryName) {
        LeafCategory leafCategory = new LeafCategory();
        leafCategory.setName(leafCategoryName);
        return leafCategory;
    }

    private void addAsSubcategoryToParent(Long parentId, AbstractCategory subcategory) {
        Category parent = categoryRepository.findOne(parentId);
        addAsSubcategoryAndPersist(subcategory, parent);
    }

    private void removeOldParentAndAddNew(Long newParentId, AbstractCategory category) {
        Category newParent = categoryRepository.findOne(newParentId);
        category.getParent().removeSubcategory(category);
        categoryRepository.save(category.getParent());
        addAsSubcategoryAndPersist(category, newParent);
    }

    private void addAsSubcategoryAndPersist(AbstractCategory subcategory, Category parent) {
        parent.addSubcategory(subcategory);
        subcategory.setParent(parent);
        categoryRepository.save(parent);
    }

}
