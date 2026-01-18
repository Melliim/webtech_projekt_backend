package htwberlin.stockUp.persistence;

import jakarta.persistence.*;

@Entity(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "storage")
    @Enumerated(value = EnumType.STRING)
    private Storage storage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "shelf_id", referencedColumnName = "id")
    private CategoryEntity shelf;

    public ItemEntity() {
    }

    public ItemEntity(String name, String description, Storage storage, CategoryEntity shelf) {
        this.name = name;
        this.description = description;
        this.storage = storage;
        this.shelf = shelf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public CategoryEntity getShelf() {
        return shelf;
    }

    public void setShelf(CategoryEntity shelf) {
        this.shelf = shelf;
    }
}
