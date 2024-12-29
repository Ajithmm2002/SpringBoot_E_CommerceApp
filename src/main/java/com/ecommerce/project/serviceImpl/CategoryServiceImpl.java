package com.ecommerce.project.serviceImpl;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public void createCategory(Category category) {

    }


    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().filter(c -> c.getCategoryId()
                        .equals(categoryId)).
                findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resourse not found"));
        categories.remove(category);
        return "deleted" + categoryId + "successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream().filter(c -> c.getCategoryId()
                        .equals(categoryId))
                .findFirst();

        if (optionalCategory.isPresent()) {
            Category existingcategory = optionalCategory.get();
            existingcategory.setCategoryName(category.getCategoryName());
            return existingcategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resourse Not Found");
        }
    }

}
