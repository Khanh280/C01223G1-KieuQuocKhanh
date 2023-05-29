package com.validate_song.service.impl;

import com.validate_song.model.Song;
import com.validate_song.repository.ISongRepository;
import com.validate_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;
@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public boolean save(Song song) {
        try{
            iSongRepository.save(song);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Song findSongById(Long id) {
        return iSongRepository.findById(id).get();
    }

    @Override
    public boolean delete(Long id) {
        try{
            iSongRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
