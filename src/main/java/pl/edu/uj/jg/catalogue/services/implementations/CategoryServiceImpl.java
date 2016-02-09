package pl.edu.uj.jg.catalogue.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.catalogue.domain.products.AbstractCategory;
import pl.edu.uj.jg.catalogue.domain.products.Category;
import pl.edu.uj.jg.catalogue.domain.products.LeafCategory;
import pl.edu.uj.jg.catalogue.repositories.CategoryRepository;
import pl.edu.uj.jg.catalogue.repositories.LeafCategoryRepository;
import pl.edu.uj.jg.catalogue.services.CategoryService;

import java.util.Stack;

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
    public Category createSubcategory(Long parentId, String subcategoryName) {
        Category subcategory = createCategoryByName(subcategoryName);
        addAsSubcategoryToParent(parentId, subcategory);
        return categoryRepository.save(subcategory);
    }

    @Override
    public LeafCategory createLeafCategory(Long parentId, String leafCategoryName) {
        LeafCategory subcategory = createLeafCategoryByName(leafCategoryName);
        addAsSubcategoryToParent(parentId, subcategory);
        return leafCategoryRepository.save(subcategory);
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

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public LeafCategory getLeafCategoryByName(String name) {
        return leafCategoryRepository.findByName(name);
    }

    @Override
    public Category fetchSubtree(Long id) {
        Category category = categoryRepository.findOne(id);
        Stack<Category> toExplore = new Stack<>();
        toExplore.push(category);
        while (!toExplore.empty()) {
            toExplore.pop().getSubcategories().stream().filter(subcategory -> subcategory instanceof Category).forEach(subcategory -> {
                toExplore.push((Category) subcategory);
            });
        }
        return category;
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
    }

}
