package Products.ProductService.Controllers;

import Products.ProductService.Dtos.ProductDto;
import Products.ProductService.Response.Response;
import Products.ProductService.Services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/product")
    public ResponseEntity<Response> createProduct(@RequestBody ProductDto productDto) throws JsonProcessingException {
        return productService.createProduct(productDto);
    }
    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/Allproducts")
    public List<ProductDto> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{brand}")
    public ProductDto getProductByBrand(@PathVariable String brand){
        ProductDto pdto=productService.getProductByBrandName(brand);
        return pdto;
    }

    @GetMapping("/products/{category}")
    public ProductDto getProductByCategory(@PathVariable String category){
        ProductDto pdto=productService.getProductBycCategoryName(category);
        return pdto;
    }

    @GetMapping("/ProductByMatch/{name}")
    public List<ProductDto> getProductByMatch(@PathVariable String name){
        System.out.print(name);
        return productService.getProductByMatch(name);
    }
    @PutMapping("/UpdateProduct/{id}")
    public Response updateProduct(@PathVariable int id , @RequestBody ProductDto productDto){
        Response p=productService.getmodifiedProduct(id,productDto);
        return p;
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
