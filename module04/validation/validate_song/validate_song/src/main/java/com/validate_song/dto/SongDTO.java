package com.validate_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SongDTO {

    private Long id;
    @NotBlank(message = "Not empty")
    @Size(max = 800)
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,800}$",message = "The song title does not contain special characters. Up to 800 characters")
    private String songName;
    @NotBlank(message = "Not empty")
    @Size(max = 300)
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,300}$", message = "Singer names do not contain special characters. Up to 300 characters" )
    private String singer;
    @NotBlank(message = "Not empty")
    @Size(max = 1000)
    @Pattern(regexp = "^[A-Za-z0-9, ]{1,1000}$", message = "Music genre names do not contain special characters. Up to 1000 characters")
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

}

