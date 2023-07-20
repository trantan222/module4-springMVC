package com.example.quan_li_bai_hat.service;
import com.example.quan_li_bai_hat.model.Music;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface iServiceMusic {
    List<Music> findAll();

    Music findById(int id);

    void create(Music music);

    void delete(int id);

    void write(MultipartFile file, Path dir);

}
