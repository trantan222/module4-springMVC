package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productDtoIntegerMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductDtoIntegerMap() {
        return productDtoIntegerMap;
    }

    public void setProductDtoIntegerMap(Map<ProductDto, Integer> productDtoIntegerMap) {
        this.productDtoIntegerMap = productDtoIntegerMap;
    }
    public void addProduct(ProductDto productDto){
        if(productDtoIntegerMap.containsKey(productDto)){
         Integer currentValue = productDtoIntegerMap.get(productDto);
         productDtoIntegerMap.replace(productDto,currentValue+1);
        }else {
            productDtoIntegerMap.put(productDto,1);
        }
    }
    public void deleteProduct(ProductDto productDto){
        Integer valueDelete = productDtoIntegerMap.get(productDto);
        if(valueDelete != null){
            productDtoIntegerMap.remove(productDto);
        }
    }

}
