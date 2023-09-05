package com.kaya.BookStore.model;

import com.sun.istack.NotNull;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="UUID")
    private UUID id;
    @Column
    @NotNull
    private String title;
    @Column
    @NotNull
    private String description;
    @Column
    @NotNull
    private int releaseYear;
}
