package com.example.e2_informationn_music.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_Music;
    private String musican;
    private String type;

    public Music() {
    }

    public Music(Long id, String name_Music, String musican, String type) {
        this.id = id;
        this.name_Music = name_Music;
        this.musican = musican;
        this.type = type;
    }

}
