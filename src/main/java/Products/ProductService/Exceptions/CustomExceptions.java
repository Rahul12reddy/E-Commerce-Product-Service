package Products.ProductService.Exceptions;

import org.springframework.stereotype.Component;


public class CustomExceptions extends RuntimeException{
    public CustomExceptions(String message){
        super(message);
    }
}
