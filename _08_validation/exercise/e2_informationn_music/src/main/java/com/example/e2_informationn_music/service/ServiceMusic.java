package com.example.e2_informationn_music.service;

import com.example.e2_informationn_music.model.Music;
import com.example.e2_informationn_music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceMusic implements IServiceMusic{
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iMusicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(Long id) {
        return iMusicRepository.findById(id).orElse(null);
    }
}
