package com.challenge.literalura.Service;

import com.challenge.literalura.Model.Libro;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@Service
public class LibroService {

    @Autowired
    private AutorService autorService1 = new AutorService();

    public List<Libro> findAPI(String name) {
        String API_URL = "http://gutendex.com/books/";


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JSONObject jsonObject = new JSONObject(responseBody);
                JSONArray result = jsonObject.getJSONArray("results");


                // Iterar sobre los elementos del array
                for (int i = 0; i < result.length(); i++) {
                    JSONObject resultObject = result.getJSONObject(i);

                    // Obtener el título del objeto actual
                    String title = resultObject.getString("title");


                    // Verificar si el título contiene el término de búsqueda (ignorando mayúsculas y minúsculas)
                    if (title.equalsIgnoreCase(name)) {
                        // Si encuentra una coincidencia, hacer un scream
                        System.out.println("¡Encontré una coincidencia en el título!");

                        // Puedes imprimir el título si lo deseas
                        System.out.println("Titulo: "+resultObject.getString("title") + "\n" +
                                            "Id: "+ resultObject.getNumber("id")+ "\n" +
                                            "authors: "+ resultObject.getJSONArray("authors")+ "\n" +
                                            "languages: "+ resultObject.getJSONArray("languages")+ "\n" +
                                            "download_count: "+ resultObject.getLong("download_count")+ "\n");

                        autorService1.add(resultObject.getJSONArray("authors"));
                        return Collections.emptyList();
                    }
                }
                System.out.println("No se encontro ningun libro con tal nombre");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al procesar la solicitud HTTP", e);
        }
        return Collections.emptyList(); // Si ocurre algún error, devolver una lista vacía
    }

}
