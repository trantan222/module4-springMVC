package com.example.sudungthymeleafdequanlisanpham.repo;

import com.example.sudungthymeleafdequanlisanpham.model.product;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements RepoProduct{
    private static List<product> productList = new ArrayList<>();
    static {
        productList.add(new product(1,"iphoneX",5000,"X","Apple"));
        productList.add(new product(2,"iphone11",10000,"11","Apple"));
        productList.add(new product(3,"iphoneXR",8000,"XR","China"));
        productList.add(new product(4,"iphoneXS",9000,"XS","VietNam"));
        productList.add(new product(5,"iphone12",20000,"12","Apple"));
    }
    @Override
    public List<product> findAll() {
        return productList;
    }

    @Override
    public void save(product product) {
        productList.add(product);
    }

    @Override
    public List<product> findbyName(String name) {
        List<product> product2 = new ArrayList<>();
        for(product product : productList){
            if(product.getName().toLowerCase().contains(name)){
                product2.add(product);
            }
        }
        return product2;
    }

    @Override
    public void remove(int id) {
        int i;
        for ( i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId() == id){
                break;
            }
        }
        productList.remove(i);
    }

    @Override
    public void edit(int id,product product) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId() == id){
                productList.get(i).setName(product.getName());
                productList.get(i).setCost(product.getCost());
                productList.get(i).setDescribe(product.getDescribe());
                productList.get(i).setProducer(product.getProducer());
            }
        }
    }

    @Override
    public product detail(int id) {
        for(product product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
