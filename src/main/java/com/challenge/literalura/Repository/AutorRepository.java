package com.challenge.literalura.Repository;

import com.challenge.literalura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

    /*
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Autor a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :nombreAutor, '%'))")
    Boolean existsByNameContainingIgnoreCase(@Param("nombreAutor") String nombreAutor);
 */
    boolean findByName (String name);
  /*  User findByEmailAddress(String emailAddress);*/

}

