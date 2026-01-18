package htwberlin.stockUp.web.api;

public class CategoryManipulationRequest {

    private String name;
    private String description;
    private boolean activeStatus;

    public CategoryManipulationRequest(String name, String description, boolean activeStatus) {
        this.name = name;
        this.description = description;
        this.activeStatus = activeStatus;
    }

    public CategoryManipulationRequest() {}

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

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
