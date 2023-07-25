package com.example.e1_music.repo;

import com.example.e1_music.model.Music;
import com.example.e1_music.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MusicDAOimpl implements MusicRepo{
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        List<Music> Musics = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Music> query = session.createQuery("from Music",Music.class);
        Musics = query.getResultList();
        session.close();
        return Musics;
    }

    @Override
    public Music findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Music> query = session.createQuery("from Music where idMusic =:id",Music.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public boolean create(Music music) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(music);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void update(Music music){
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.update(music);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public List<Music> searchName(String name) {
        String hql = "SELECT m FROM Music m WHERE m.nameMusic LIKE :name";
        Session session = ConnectionUtil.sessionFactory.openSession();
        Query<Music> query = session.createQuery(hql, Music.class);
        query.setParameter("name", "%" + name + "%");
        List<Music> results = query.getResultList();
        session.close();
        return results;
    }

    @Override
    public void delete(int id) {
        String hql = "DELETE FROM Music WHERE idMusic =:id";
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Query> query = session.createQuery(hql);
        query.setParameter("id",id);
        query.executeUpdate();
        session.close();
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
