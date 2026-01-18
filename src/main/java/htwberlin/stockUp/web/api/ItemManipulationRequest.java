package htwberlin.stockUp.web.api;

public class ItemManipulationRequest {

    private String name;
    private String description;
    private String storage;
    private Long shelfId;

    public ItemManipulationRequest(String name, String description, String storage, Long shelfId) {
        this.name = name;
        this.description = description;
        this.storage = storage;
        this.shelfId = shelfId;
    }

    public ItemManipulationRequest() {}

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

    public Long getShelfId() {
        return shelfId;
    }

    public void setShelfId(Long shelfId) {
        this.shelfId = shelfId;
    }
}
