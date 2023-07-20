package com.example.quan_li_bai_hat.service.imp;


import com.example.quan_li_bai_hat.model.Music;
import com.example.quan_li_bai_hat.repo.iRepositoryMusic;
import com.example.quan_li_bai_hat.service.iServiceMusic;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class serviceMusicImpl implements iServiceMusic {
    private final iRepositoryMusic repositoryMusic;

    public serviceMusicImpl(iRepositoryMusic repositoryMusic) {
        this.repositoryMusic = repositoryMusic;
    }

    @Override
    public List<Music> findAll() {
        return (List<Music>) repositoryMusic.findAll();
    }

    @Override
    public Music findById(int id) {
        return repositoryMusic.findById(id).orElse(null);
    }

    @Override
    public void create(Music music) {
        repositoryMusic.save(music);
    }

    @Override
    public void delete(int id) {
        repositoryMusic.deleteById(id);
    }

    @Override
    public void write(MultipartFile file, Path dir) {
        Path filepath = Paths.get(dir.toString());
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
