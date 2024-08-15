package Products.ProductService.Dtos;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductDto {
    private int id;
    private String title;
    private double price;
    private String description;
    private int stock;
    private String category;
    private String brand;
    private String sku;
    private Map<String, Object> attributes;
    public ProductDto() {
    }

    /*public ProductDto(int id, String title, double price, String description, int stock, String category, String brand, String sku, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title=title;
        this.price=price;
        this.description = description;
        this.stock = stock;
        this.category = category;
        this.brand = brand;
        this.sku = sku;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    */
    public ProductDto(String title, double price, String description, int stock, String category, String brand, String sku, Map<String, Object> attributes) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.category = category;
        this.brand = brand;
        this.sku = sku;
        this.attributes=attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }
}
