package com.challenge.literalura.Repository;

import com.challenge.literalura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {



    @Query("SELECT COUNT(a) > 0 FROM Autor a WHERE LOWER(a.name) = LOWER(:nombreAutor)")
    boolean existsByNameIgnoreCase(@Param("nombreAutor") String nombreAutor);

}

