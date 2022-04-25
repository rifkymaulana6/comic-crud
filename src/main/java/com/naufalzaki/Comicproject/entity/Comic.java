package com.naufalzaki.Comicproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comic")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "comic name is required")
    @Column(nullable = false, name = "comicName")
    private String comicName;

    @NotEmpty(message = "author name is required")
    @Column(nullable = false, name = "authorName")
    private String authorName;

    @NotEmpty(message = "genre is required")
    @Column(nullable = false, name = "genre")
    private String genre;

    @NotEmpty(message = "publisher name is required")
    @Column(nullable = false, name="publisherName")
    private String publisherName;

    @NotEmpty(message = "email is required")
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "year is required")
    @Column(nullable = false, name="year")
    private String year;
}

