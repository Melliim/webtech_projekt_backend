package htwberlin.stockUp.web.api;

import java.util.List;

public class Category {

    private long id;
    private String name;
    private String description;
    private boolean activeStatus;
    private List<Long> items;

    public Category(long id, String name, String description, boolean activeStatus, List<Long> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.activeStatus = activeStatus;
        this.items = items;
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

    public boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }
}
