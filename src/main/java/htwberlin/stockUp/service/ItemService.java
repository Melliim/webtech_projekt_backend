package htwberlin.stockUp.service;

import htwberlin.stockUp.persistence.CategoryRepository;
import htwberlin.stockUp.persistence.ItemEntity;
import htwberlin.stockUp.persistence.ItemRepository;
import htwberlin.stockUp.persistence.Storage;
import htwberlin.stockUp.web.api.Item;
import htwberlin.stockUp.web.api.ItemManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryTransformer categoryTransformer;


    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository, CategoryTransformer categoryTransformer) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.categoryTransformer = categoryTransformer;
    }

    public List<Item> findAll() {
        List<ItemEntity> items = itemRepository.findAll();
        return items.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Item findById(Long id) {
        var itemEntity = itemRepository.findById(id);
        return itemEntity.map(this::transformEntity).orElse(null);
    }

    public Item create(ItemManipulationRequest request) {
        var storage = Storage.valueOf(request.getStorage());
        var shelf = categoryRepository.findById(request.getShelfId()).orElseThrow();
        var itemEntity = new ItemEntity(request.getName(), request.getDescription(), storage, shelf);
        itemEntity = itemRepository.save(itemEntity);
        return transformEntity(itemEntity);
    }

    public Item update(Long id, ItemManipulationRequest request) {
        var itemEntityOptional = itemRepository.findById(id);
        if (itemEntityOptional.isEmpty()) {
            return null;
        }

        var itemEntity = itemEntityOptional.get();
        itemEntity.setName(request.getName());
        itemEntity.setDescription(request.getDescription());
        itemEntity.setStorage(Storage.valueOf((request.getStorage())));

        var categoryEntityOptional = categoryRepository.findById(request.getShelfId());
        if (categoryEntityOptional.isPresent()) {
            var categoryEntity = categoryEntityOptional.get();
            itemEntity.setShelf(categoryEntity);
        }

        itemEntity = itemRepository.save(itemEntity);

        return this.transformEntity((itemEntity));
    }

    public boolean deleteById(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);
        return true;
    }

    private Item transformEntity(ItemEntity itemEntity) {
        var storage = itemEntity.getStorage() != null ? itemEntity.getStorage().name() : Storage.NOTSET.name();
        return new Item(
                itemEntity.getId(),
                itemEntity.getName(),
                itemEntity.getDescription(),
                storage,
                categoryTransformer.transformEntity(itemEntity.getShelf()));
    }
}
