package com.example.quan_li_bai_hat.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MusicForm {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idMusic;
    @Column(name = "ten_bai_hat", columnDefinition = "varchar(50)")
    private String nameMusic;
    @Column(name = "ten_ca_si", columnDefinition = "varchar(50)")

    private String nameSinger;
    @Column(name = "Loai_bai_hat", columnDefinition = "varchar(50)")

    private String typeMusic;
    @Column(name = "Link_bai_hat", columnDefinition = "varchar(50)")

    private String link;

    @Column(name = "nghe_nhac", columnDefinition = "varchar(50)")

    private MultipartFile play;


    public MusicForm() {

    }

    public MusicForm(Integer idMusic, String nameMusic, String nameSinger, String typeMusic, String link, MultipartFile play) {
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

    public MultipartFile getPlay() {
        return play;
    }

    public void setPlay(MultipartFile play) {
        this.play = play;
    }
}
