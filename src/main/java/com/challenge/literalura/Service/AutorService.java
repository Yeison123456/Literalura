package com.challenge.literalura.Service;
import com.challenge.literalura.Model.Autor;

import com.challenge.literalura.Repository.AutorRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {


    @Autowired
    private AutorRepository autorRepository;


    public List<Autor> add(JSONArray obje) {
        System.out.println(obje);
        List<Autor> autores = new ArrayList<>();
        for (int i = 0; i < obje.length(); i++) {
            JSONObject jsonObject = obje.getJSONObject(i);
            Autor autor = new Autor();
            autor.setName(jsonObject.getString("name"));
            autor.setBirth_year(jsonObject.getInt("birth_year"));
            autor.setDeath_year(jsonObject.getInt("death_year"));
            // Si tienes libros asociados, tendrás que añadir lógica adicional para manejarlos
            if (!autorRepository.existsByNameIgnoreCase(jsonObject.getString("name"))) {
                autores.add(autor);
            }
        }
        autorRepository.saveAll(autores);
        return autores;
    }


}
