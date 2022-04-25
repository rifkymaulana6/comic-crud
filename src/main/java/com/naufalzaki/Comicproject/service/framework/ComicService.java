package com.naufalzaki.Comicproject.service.framework;

import com.naufalzaki.Comicproject.entity.Comic;

import java.util.List;
import java.util.Optional;

public interface ComicService {
    List<Comic> getAllComic();

    Optional<Comic> findById(Long id);

    Optional<Comic> findByEmail(String email);

    Comic save(Comic std);

    void deleteById(Long id);
}
