package com.validate_song.service;

import com.validate_song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    boolean save(Song song);
    Song findSongById(Long id);
    boolean delete(Long id);
}
