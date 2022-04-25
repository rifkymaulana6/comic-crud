package com.naufalzaki.Comicproject.controller;

import com.naufalzaki.Comicproject.exception.ComicNotFoundException;
import com.naufalzaki.Comicproject.entity.Comic;
import com.naufalzaki.Comicproject.service.framework.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api/comic")
public class ComicController {

    private final ComicService comicService;

    @Autowired
    public ComicController(ComicService comicservice) {
        this.comicService = comicservice;
    }

    @GetMapping
    public List<Comic> getAllComic() {
        return comicService.getAllComic();
    }

    @GetMapping(value = "/{id}")
    public Comic getComicById(@PathVariable("id") @Min(1) Long id) {
        Comic std = comicService.findById(id)
                .orElseThrow(() -> new ComicNotFoundException("Comic with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Comic addComic(@Valid @RequestBody Comic std) {
        return comicService.save(std);
    }

    @PutMapping(value = "/{id}")
    public Comic updateComic(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Comic newStd) {
        Comic Comic = comicService.findById(id)
                .orElseThrow(() -> new ComicNotFoundException("Comic with " + id + " is Not Found!"));
        Comic.setComicName(newStd.getComicName());
        Comic.setAuthorName(newStd.getAuthorName());
        Comic.setGenre(newStd.getGenre());
        Comic.setPublisherName(newStd.getPublisherName());
        Comic.setEmail(newStd.getEmail());
        return comicService.save(Comic);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteComic(@PathVariable("id") @Min(1) Long id) {
        Comic std = comicService.findById(id)
                .orElseThrow(() -> new ComicNotFoundException("Comic with " + id + " is Not Found!"));
        comicService.deleteById(std.getId());
        return "Comic with ID :" + id + " is deleted";
    }
}
