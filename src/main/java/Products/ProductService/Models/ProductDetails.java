package Products.ProductService.Models;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="products_data")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private double price;
    private String description;
    private int stock;
    private String category;
    private String brand;
    private String sku;
    @Column(columnDefinition = "json")
    private String attributes;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
   // @Column(name="createdAt", updatable = false)
    private Date createdAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    //@Column(name="updatedAt", updatable = false)
    private Date updatedAt;
    public ProductDetails() {
    }

    public ProductDetails(int id, String title, double price, String description, int stock, String category, String brand, String sku,String attributes, Date createdAt, Date updatedAt) {
        this.title=title;
        this.price=price;
        this.description = description;
        this.stock = stock;
        this.category = category;
        this.brand = brand;
        this.sku = sku;
        this.attributes=attributes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                ", attributes='" + attributes + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
