package com.example.e2_informationn_music.service;

import com.example.e2_informationn_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceMusic {
    Page<Music> findAll(Pageable pageable);
    void save(Music music);
    Music findById(Long id);
}
