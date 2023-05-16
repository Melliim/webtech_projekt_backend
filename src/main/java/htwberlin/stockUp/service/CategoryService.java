package htwberlin.stockUp.service;

import htwberlin.stockUp.persistence.CategoryEntity;
import htwberlin.stockUp.persistence.CategoryRepository;
import htwberlin.stockUp.web.api.Category;
import htwberlin.stockUp.web.api.CategoryManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Category findById(Long id) {
        var categoryEntity = categoryRepository.findById(id);
        return categoryEntity.map(this::transformEntity).orElse(null);
    }

    public Category create(CategoryManipulationRequest request) {
        var categoryEntity = new CategoryEntity(request.getName(), request.getDescription(), request.isActiveStatus());
        categoryRepository.save(categoryEntity);
        return transformEntity(categoryEntity);

    }

    public Category update(Long id, CategoryManipulationRequest request) {
        var categoryEntityOptional = categoryRepository.findById(id);
        if (categoryEntityOptional.isEmpty()) {
            return null;
        }

        var categoryEntity = categoryEntityOptional.get();
        categoryEntity.setName(request.getName());
        categoryEntity.setDescription(request.getDescription());
        categoryEntity.setActiveStatus(request.isActiveStatus());
        categoryEntity = categoryRepository.save(categoryEntity);

        return transformEntity(categoryEntity);
    }

    public boolean deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }

        categoryRepository.deleteById(id);
        return true;
    }

    private Category transformEntity(CategoryEntity categoryEntity) {
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getDescription(),
                categoryEntity.getActiveStatus()
        );
    }

}
