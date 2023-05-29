package com.validate_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class SongDTO implements Validator {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Not empty")
    @Size(max = 800)
    private String songName;
    @NotEmpty(message = "Not empty")
    @Size(max = 300)
    private String singer;
    @NotEmpty(message = "Not empty")
    @Size(max = 1000)
    private String genres;

    public SongDTO() {
    }

    public SongDTO(Long id, String songName, String singer, String genres) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        String regexSongName = "^[A-Za-z0-9 ]{1,800}$";
        String regexSinger = "^[A-Za-z0-9 ]{1,300}$";
        String regexGenres = "^[A-Za-z0-9, ]{1,1000}$";
        if (!songDTO.songName.matches(regexSongName)) {
            errors.rejectValue("songName", "", "The song title does not contain special characters. Up to 800 characters");
        }
        if (!songDTO.singer.matches(regexSinger)) {
            errors.rejectValue("singer", "", "Singer names do not contain special characters. Up to 300 characters");
        }
        if (!songDTO.genres.matches(regexGenres)) {
            errors.rejectValue("genres", "", "Music genre names do not contain special characters. Up to 1000 characters");
        }
    }
}

