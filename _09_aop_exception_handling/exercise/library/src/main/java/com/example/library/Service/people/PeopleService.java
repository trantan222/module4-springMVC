package com.example.library.Service.people;

import com.example.library.Repository.IPeopleRepo;
import com.example.library.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeopleService implements IPeopleService{
    final
    IPeopleRepo iPeopleRepo;

    public PeopleService(IPeopleRepo iPeopleRepo) {
        this.iPeopleRepo = iPeopleRepo;
    }

    @Override
    public Page<People> findAll(Pageable pageable) {
        return iPeopleRepo.findAll(pageable);
    }

    @Override
    public People create(People people) {
        iPeopleRepo.save(people);
        return people;
    }

    @Override
    public void delete(Integer id) {
        iPeopleRepo.deleteById(id);
    }

    @Override
    public People findById(Integer id) {
        return iPeopleRepo.findById(id).orElse(null);
    }
}
