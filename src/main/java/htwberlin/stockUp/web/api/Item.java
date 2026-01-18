package htwberlin.stockUp.web.api;

public class Item {
    private long id;
    private String name;
    private String description;
    private String storage;
    private Category category;

    public Item(long id, String name, String description, String storage, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.storage = storage;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

