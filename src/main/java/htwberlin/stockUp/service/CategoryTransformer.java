package htwberlin.stockUp.service;

import htwberlin.stockUp.persistence.CategoryEntity;
import htwberlin.stockUp.persistence.ItemEntity;
import htwberlin.stockUp.web.api.Category;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoryTransformer {

    public Category transformEntity(CategoryEntity categoryEntity) {
        var itemIds = categoryEntity.getItems().stream().map(ItemEntity::getId).collect(Collectors.toList());
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getDescription(),
                categoryEntity.getActiveStatus(),
                itemIds);
    }
}
