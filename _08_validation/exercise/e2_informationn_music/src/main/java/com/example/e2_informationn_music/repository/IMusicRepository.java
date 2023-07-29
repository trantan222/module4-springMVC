package com.example.e2_informationn_music.repository;

import com.example.e2_informationn_music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Long> {
}
