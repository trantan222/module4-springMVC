package com.example.library.Repository;

import com.example.library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepo extends JpaRepository<Borrow,Integer> {
}
