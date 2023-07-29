package com.example.blogspringboot.service.categoryy;

import com.example.blogspringboot.model.category;
import com.example.blogspringboot.repository.ICateGoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCategory implements IServiceCategory{
         final
         ICateGoryRepository iCateGoryRepository;

    public ServiceCategory(ICateGoryRepository iCateGoryRepository) {
        this.iCateGoryRepository = iCateGoryRepository;
    }

    @Override
    public Page<category> findAll(Pageable pageable, String name) {
        return iCateGoryRepository.findAll(pageable);
    }

    @Override
    public List<category> findAll() {
        return iCateGoryRepository.findAll();
    }

    @Override
    public category findById(Integer id) {
        return iCateGoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(category category) {
        category category1 = iCateGoryRepository.save(category);
        if(category1 != null){
            return true;
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        iCateGoryRepository.deleteById(id);
    }

}
