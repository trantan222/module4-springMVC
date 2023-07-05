package com.example.tracuutudien.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
public class TuDienMap {
    Map<String,String> map = new HashMap<>();
    public void addWordToDictionary(String vn, String eng){
        map.put(vn, eng);
    }

    public Map<String, String> getAll(){
        return map;
    }

    public String find(String vn){
        return map.get(vn);
    }
}
