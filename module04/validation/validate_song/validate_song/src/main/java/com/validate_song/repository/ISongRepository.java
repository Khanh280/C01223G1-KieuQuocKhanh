package com.validate_song.repository;

import com.validate_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Long> {
}
