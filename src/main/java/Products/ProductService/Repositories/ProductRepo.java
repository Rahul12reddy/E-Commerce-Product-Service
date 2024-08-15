package Products.ProductService.Repositories;

import Products.ProductService.Models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetails, Integer> {
    public ProductDetails findByTitle(String title);
    public ProductDetails findByBrand(String brand);
    public ProductDetails findByCategory(String category);
   // @Query(value="SELECT * FROM products_data WHERE title LIKE %?name%", nativeQuery = true)
    public List<ProductDetails> findByTitleContains(String name);
    
}
