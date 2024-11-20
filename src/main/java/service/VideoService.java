package service;

import org.openapitools.model.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class VideoService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String videoServiceUrl = "http://localhost:8082"; // URL del microservicio de videos

    public ArrayList<Video> getVideosByGenre(String genre) {
        try {
            // Construye la URL con el parámetro de género
            String url = String.format("%s/video/genres?genre=%s", videoServiceUrl, genre);

            // Envía una solicitud GET al microservicio de videos y obtiene un arreglo
            Video[] videosArray = restTemplate.getForObject(url, Video[].class);

            // Convierte el arreglo en un ArrayList para una mejor gestión
            return new ArrayList<>(Arrays.asList(videosArray));
        } catch (HttpClientErrorException e) {
            // Maneja errores, como un 400 o 404
            return new ArrayList<>(); // Devuelve una lista vacía si ocurre un error
        }
    }
    
    public ArrayList<Video> getVideosByTitle(String title) {
        try {
            // Construye la URL con el parámetro del título parcial
            String url = String.format("%s/video/title?title=%s", videoServiceUrl, title);

            // Envía una solicitud GET al microservicio de videos y obtiene un arreglo
            Video[] videosArray = restTemplate.getForObject(url, Video[].class);

            // Convierte el arreglo en un ArrayList para una mejor gestión
            return new ArrayList<>(Arrays.asList(videosArray));
        } catch (HttpClientErrorException e) {
            // Maneja errores, como un 400 o 404
            System.out.println("Error al obtener videos: " + e.getMessage());
            return new ArrayList<>(); // Devuelve una lista vacía si ocurre un error
        }
    }

}
