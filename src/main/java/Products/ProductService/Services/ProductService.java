package Products.ProductService.Services;

import Products.ProductService.Dtos.DtoMapper;
import Products.ProductService.Dtos.ProductDto;
import Products.ProductService.Exceptions.CustomExceptions;
import Products.ProductService.Models.ProductDetails;
import Products.ProductService.Repositories.ProductRepo;
import Products.ProductService.Response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;
    private DtoMapper dtoMapper;
    public ProductService(ProductRepo productRepo, DtoMapper dtoMapper) {
        this.productRepo = productRepo;
        this.dtoMapper=dtoMapper;
    }
    public ResponseEntity<Response> createProduct(ProductDto p) throws JsonProcessingException {
        ProductDetails q=dtoMapper.toEntity(p);
        System.out.println(q);
     //   String jsonattributes=print
        productRepo.save(q);
        Response response=new Response();
        response.setMessage("Product is created");
        response.setSuccess(true);
        ProductDetails entity=productRepo.findByTitle(p.getTitle());
        ProductDto d=dtoMapper.toDto(entity);
       // System.out.println(entity);
        response.setProductDto(d);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    public List<ProductDto> getProducts(){
        List<ProductDetails> d=productRepo.findAll();
        System.out.println(d);
        List<ProductDto> h=new ArrayList<>();
        for(ProductDetails i:d){
            ProductDto t=dtoMapper.toDto(i);
            //System.out.println(t);
            h.add(t);
        }
        return h;
    }

    public ProductDto getProductByBrandName(String brand) {
        ProductDto p=new ProductDto();
        ProductDetails q=productRepo.findByBrand(brand);
        if(q==null){
            throw new CustomExceptions(brand+" "+"Product not found");
        }
        p=dtoMapper.toDto(q);
        return p;
    }

    public ProductDto getProductBycCategoryName(String category){
        ProductDetails pdetails=productRepo.findByCategory(category);
        if(pdetails==null){
            throw new CustomExceptions(category+" "+"Category not found");
        }
        ProductDto pdto=dtoMapper.toDto(pdetails);
        return pdto;
    }
    public Response getmodifiedProduct(int id, ProductDto productDto) {
        Response resp=new Response();
        Optional<ProductDetails> productDetails=productRepo.findById(id);
        if(productDetails==null){
            throw new CustomExceptions(id+" "+"product is not found. Please create a product");
        }
        productRepo.save(productDetails.get());
        ProductDto pdto=dtoMapper.toDto(productRepo.findById(id).get());
        resp.setMessage("Details updated successfully");
        resp.setSuccess(true);
        resp.setProductDto(pdto);
        return resp;
    }
    public ResponseEntity<String> deleteProduct(int id) {
        if(!productRepo.existsById(id)){
            throw new CustomExceptions(id+" "+"Product has not been found");
        }
        productRepo.deleteById(id);
        return new ResponseEntity<>("product has been deleted successfully",HttpStatus.OK);
    }

    public ProductDto getProductById(int id) {
        ProductDetails pdetails=productRepo.findById(id).get();
        if(pdetails==null){
            throw new CustomExceptions(id+" "+"Category not found");
        }
        ProductDto pdto=dtoMapper.toDto(pdetails);
        return pdto;
    }
    public List<ProductDto> getProductByMatch(String name){
        List<ProductDetails> d=productRepo.findByTitleContains(name);
      //  System.out.println(d.toString()+"Hello");
        if(d==null){
            throw new CustomExceptions("No items found with"+" "+name);
        }
        List<ProductDto> dtoList=new ArrayList<>();
        for(ProductDetails i: d){
            ProductDto pdto=dtoMapper.toDto(i);
            dtoList.add(pdto);
        }
        return dtoList;
    }
}
