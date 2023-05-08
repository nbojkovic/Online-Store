package rs.singidunum.ac.rs.OnlineStore.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.singidunum.ac.rs.OnlineStore.model.Category;
import rs.singidunum.ac.rs.OnlineStore.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(String id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(new ObjectId(id));
        if (!optionalCategory.isPresent()) {
            return null;
        }

        Category existingCategory = optionalCategory.get();
        existingCategory.setName(category.getName());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(new ObjectId(id));
    }

}
