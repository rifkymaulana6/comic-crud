package com.naufalzaki.Comicproject.service.implementation;

import com.naufalzaki.Comicproject.entity.Comic;
import com.naufalzaki.Comicproject.repository.ComicRepository;
import com.naufalzaki.Comicproject.service.framework.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicServiceImpl implements ComicService {
    private final ComicRepository comicRepository;

    @Autowired
    public ComicServiceImpl(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public List<Comic> getAllComic() {
        return comicRepository.findAll();
    }

    @Override
    public Optional<Comic> findById(Long id) {
        return comicRepository.findById(id);
    }

    @Override
    public Optional<Comic> findByEmail(String email) {
        return comicRepository.findByEmail(email);
    }

    @Override
    public Comic save(Comic std) {
        return comicRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {
        comicRepository.deleteById(id);
    }
}
