package com.challenge.literalura.Repository;

import com.challenge.literalura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface libroRepository extends JpaRepository<Libro, Long> {
}
