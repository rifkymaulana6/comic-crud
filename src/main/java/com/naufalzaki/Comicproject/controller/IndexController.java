package com.naufalzaki.Comicproject.controller;

import com.naufalzaki.Comicproject.entity.Comic;
import com.naufalzaki.Comicproject.service.framework.ComicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IndexController {
    private ComicService comicService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("comic", comicService.getAllComic());
        return "index";
    }
    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("comic", new Comic());
        return "formComic";
    }

    @PostMapping(value = "/create")
    public String tambahComic(Model model, Comic Comic) {
        model.addAttribute("comic", comicService.save(Comic));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("comic", comicService.findById(id));
        return "formComic";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusComic(@PathVariable Long id) {
        comicService.deleteById(id);
        return "redirect:/";
    }

}

