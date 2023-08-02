package groceryStore.model;
import java.time.LocalDate;
public class Product {
    private String id;
    private String name;
    private Double price;
    private LocalDate expiration;
    private String image;
    private String categoryId;
        
    public Product() {
    }

    public Product(String id, String name, Double price, LocalDate expiration, String image, String categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.image = image;
        this.categoryId = categoryId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiration=" + expiration +
                ", image='" + image + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
