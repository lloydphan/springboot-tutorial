package com.cimb.secure.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String coverPhotoURL;

    @NotNull
    private Long isbnNumber;

    @NotNull
    private Double price;

    @NotNull
    private String language;

    @NotNull
    private String genre;
}
