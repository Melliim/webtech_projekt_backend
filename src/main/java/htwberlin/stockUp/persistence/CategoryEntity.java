package htwberlin.stockUp.persistence;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "is_active")
    private boolean activeStatus;

    @OneToMany(mappedBy = "shelf", fetch = FetchType.EAGER)
    private List<ItemEntity> items = new ArrayList<>();


    public CategoryEntity( String name, String description, boolean activeStatus) {
        this.name = name;
        this.description = description;
        this.activeStatus = activeStatus;
    }

    protected CategoryEntity() {}

    public long getId() {
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

    public boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}
