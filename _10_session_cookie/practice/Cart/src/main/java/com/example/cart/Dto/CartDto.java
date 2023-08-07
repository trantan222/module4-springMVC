package com.example.cart.Dto;

import com.example.cart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<Product,Long> cartMap = new HashMap<>();

    public CartDto(Map<Product, Integer> cartMap) {
        cartMap = cartMap;
    }

    public CartDto() {
    }

    public Map<Product, Long> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Product, Long> cartMap) {
        cartMap = cartMap;
    }
    public void addProduct(Product productDto){
        if(cartMap.containsKey(productDto)){
            Long currentValue = cartMap.get(productDto);
            cartMap.replace(productDto,currentValue+1);
        }else{
            cartMap.put(productDto,1l);
        }
    }
    public void removeProduct(Product productDto){
        cartMap.remove(productDto);
    }
    public void deleteProduct(Product productDto){
        if (cartMap.containsKey(productDto)){
            if(cartMap.get(productDto) >1){
                Long currentvalue = cartMap.get(productDto);
                cartMap.replace(productDto,currentvalue-1);
            }else {
                cartMap.remove(productDto);
            }
        }
    }
    public Long countProduct(){
        Long count =0l;
        for(Map.Entry<Product,Long> entry : cartMap.entrySet()){
            count+=entry.getValue();
        }
        return count;
    }
    public Integer sizeCart(){
        return cartMap.size();
    }
    public Float Total(){
        Float total =0f;
        for(Map.Entry<Product,Long> entry : cartMap.entrySet()){
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
