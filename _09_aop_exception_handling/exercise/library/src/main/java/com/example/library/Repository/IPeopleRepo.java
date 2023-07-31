package com.example.library.Repository;

import com.example.library.model.Book;
import com.example.library.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeopleRepo extends JpaRepository<People,Integer> {
}
