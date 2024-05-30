package com.challenge.literalura.Repository;

import com.challenge.literalura.Model.Autor;
import com.challenge.literalura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface libroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT CASE WHEN EXISTS (SELECT l FROM Libro l WHERE LOWER(l.title) = LOWER(:nombreLibro)) THEN TRUE ELSE FALSE END")
    boolean existsByNameIgnoreCase(@Param("nombreLibro") String nombreLibro);

    @Query("SELECT l FROM Libro l WHERE l.languages like %:lenguage%")
    List<Libro> findByLenguage(@Param("lenguage") String lenguage);

}
