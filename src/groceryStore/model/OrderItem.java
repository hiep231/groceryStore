package groceryStore.model;
public class OrderItem {
    private String productId;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quality) {
        this.quantity = quality;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId='" + productId + '\'' +
                ", quality='" + quantity + '\'' +
                '}';
    }
}
