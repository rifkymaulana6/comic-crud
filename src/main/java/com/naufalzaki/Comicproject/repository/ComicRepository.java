package com.naufalzaki.Comicproject.repository;

import com.naufalzaki.Comicproject.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComicRepository extends JpaRepository<Comic, Long> {
    Optional<Comic> findByEmail(String email);
}
