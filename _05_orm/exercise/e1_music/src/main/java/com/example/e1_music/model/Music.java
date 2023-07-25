package com.example.e1_music.model;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusic;
    private String nameMusic;

    private String nameSinger;

    private String typeMusic;

    private String link;
    private String play;
    public Music() {

    }

    public Music(MusicForm musicForm) {
        idMusic = musicForm.getIdMusic();
        nameMusic = musicForm.getNameMusic();
        nameSinger = musicForm.getNameSinger();
        typeMusic = musicForm.getTypeMusic();
        link = musicForm.getLink();
        play = musicForm.getPlay().getOriginalFilename();
    }

    public Music(Integer idMusic, String nameMusic, String nameSinger, String typeMusic, String link, String play) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.typeMusic = typeMusic;
        this.link = link;
        this.play = play;
    }


    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Integer idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }
}
