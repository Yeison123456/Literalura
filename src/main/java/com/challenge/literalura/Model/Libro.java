package com.challenge.literalura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Libro")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    @JsonAlias("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("title")
    private String title;
    @JsonAlias("download_count")
    private Number download_count;
    @JsonAlias("languages")
    private String languages;

    @JsonAlias("authors")
    @ManyToOne
    private Autor autor;


}
