package com.example.phone.repo;

import com.example.phone.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepoPhone extends JpaRepository<Phone,Long> {
}
