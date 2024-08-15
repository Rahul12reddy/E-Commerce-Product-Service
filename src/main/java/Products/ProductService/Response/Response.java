package Products.ProductService.Response;

import Products.ProductService.Dtos.ProductDto;
import Products.ProductService.Repositories.ProductRepo;

public class Response{
    private int id;
    private String message;
    private boolean success;
    private ProductDto productDto;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
