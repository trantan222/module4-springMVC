package com.example.e1_music.service;

import com.example.e1_music.model.Music;
import com.example.e1_music.repo.MusicDAOimpl;
import com.example.e1_music.repo.MusicRepo;
import com.example.e1_music.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MusicImpl implements MusicService {
    MusicRepo musicRepo = new MusicDAOimpl();
    @Override
    public List<Music> findAll() {
        return musicRepo.findAll();
    }

    @Override
    public Music findById(int id) {
        return musicRepo.findById(id);
    }

    @Override
    public boolean create(Music music) {
        return musicRepo.create(music);
    }

    @Override
    public void update(Music music) {
        musicRepo.update(music);
    }

    @Override
    public List<Music> searchName(String name) {
        return musicRepo.searchName(name);
    }

    @Override
    public void delete(int id) {
        musicRepo.delete(id);
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
