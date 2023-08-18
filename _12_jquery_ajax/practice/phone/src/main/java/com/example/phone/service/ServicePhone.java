package com.example.phone.service;

import com.example.phone.model.Phone;
import com.example.phone.repo.IRepoPhone;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ServicePhone {

    public IRepoPhone iRepoPhone;
    public Iterable<Phone> findAll() {
        return iRepoPhone.findAll();
    }

    public Optional<Phone> findById(Long id) {
        return iRepoPhone.findById(id);
    }

    public Phone save(Phone smartPhone) {
        return iRepoPhone.save(smartPhone);
    }

    public void remove(Long id) {
        iRepoPhone.deleteById(id);
    }
}
