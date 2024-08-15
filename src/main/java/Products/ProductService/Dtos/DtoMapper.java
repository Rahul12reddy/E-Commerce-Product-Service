package Products.ProductService.Dtos;

import Products.ProductService.Models.ProductDetails;
import Products.ProductService.Repositories.ProductRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DtoMapper {
    private final ObjectMapper objectMapper=new ObjectMapper();
    //to dto from entity
    public ProductDto toDto(ProductDetails productDetails){
        ProductDto p=new ProductDto();
        p.setId(productDetails.getId());
        p.setTitle(productDetails.getTitle());
        p.setPrice(productDetails.getPrice());
        p.setDescription(productDetails.getDescription());
        p.setStock(productDetails.getStock());
        p.setCategory(productDetails.getCategory());
        p.setBrand(productDetails.getBrand());
        p.setSku(productDetails.getSku());
        if(productDetails.getAttributes()==null){
            p.setAttributes(null);
        }
        else{
            try{
                Map<String, Object> attributeMap=objectMapper.readValue(productDetails.getAttributes(), Map.class);
                p.setAttributes(attributeMap);
            } catch(JsonProcessingException e){
                throw new RuntimeException("Error");
            }
        }
        return p;
    }
    // to entity from dto
    public ProductDetails toEntity(ProductDto dto) throws JsonProcessingException {
        ProductDetails q=new ProductDetails();
        q.setTitle(dto.getTitle());
        q.setPrice(dto.getPrice());
        q.setDescription(dto.getDescription());
        q.setStock(dto.getStock());
        q.setCategory(dto.getCategory());
        q.setBrand(dto.getBrand());
        q.setSku(dto.getSku());
        try{
            String attribute=objectMapper.writeValueAsString(dto.getAttributes());
            q.setAttributes(attribute);
        }catch(JsonProcessingException e){
            throw new RuntimeException("Error");
        }
        return q;
    }

}
