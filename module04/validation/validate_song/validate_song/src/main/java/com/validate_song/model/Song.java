package com.validate_song.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(columnDefinition = "text")
    private String songName;
    @NotNull
    @Column(columnDefinition = "text")
    private String singer;
    @NotNull
    @Column(columnDefinition = "text")
    private String genres;

    public Song() {
    }

    public Song(Long id, String songName, String singer, String genres) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

}
