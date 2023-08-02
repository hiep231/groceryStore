package groceryStore.model;
public class Category {
    private String id;
    private String name;
    private Integer quantity;

    public Category() {
    }

    public Category(String id, String name, Integer quality) {
        this.id = id;
        this.name = name;
        this.quantity = quality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quality) {
        this.quantity = quality;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
