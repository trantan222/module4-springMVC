package com.example.e1_music.repo;

import com.example.e1_music.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface MusicRepo
{
    List<Music> findAll();

    Music findById(int id);

    boolean create(Music music);

    void delete(int id);

    void write(MultipartFile file, Path dir);

    void update(Music music);
    List<Music> searchName(String name);

}
