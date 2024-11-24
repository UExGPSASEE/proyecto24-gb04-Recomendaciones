package service;

import java.util.ArrayList;
import java.util.Arrays;

import org.openapitools.model.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
            String url = String.format("%s/video/title/%s", videoServiceUrl, title);

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
    
    public int getLikesFromVideo(Long videoId) {
        try {
            // Construye la URL para el endpoint del microservicio de videos
            String url = String.format("%s/videos/%d/countLikes", videoServiceUrl, videoId);

            // Envía una solicitud GET al microservicio y obtiene el número de likes como un Integer
            Integer likes = restTemplate.getForObject(url, Integer.class);

            // Retorna el número de likes, asegurándose de manejar valores nulos
            return (likes != null) ? likes : 0;
        } catch (HttpClientErrorException e) {
            // Maneja errores como un 400 o 404
            System.err.println("Error al obtener el número de likes: " + e.getMessage());
            return 0; // Devuelve 0 en caso de error
        }
    }
    
    public Long getViewsFromVideo(Long videoId) {
        try {
            // Construye la URL para el endpoint del microservicio de videos
            String url = String.format("%s/videos/%d/views", videoServiceUrl, videoId);

            // Envía una solicitud GET al microservicio y obtiene el número de likes como un Integer
            Long likes = restTemplate.getForObject(url, Long.class);

            // Retorna el número de likes, asegurándose de manejar valores nulos
            return (likes != null) ? likes : 0L;
        } catch (HttpClientErrorException e) {
            // Maneja errores como un 400 o 404
            System.err.println("Error al obtener el número de likes: " + e.getMessage());
            return 0L; // Devuelve 0 en caso de error
        }
    }
    
    public ArrayList<Video> getTopVideos() {
        try {
            // Construye la URL para el endpoint del microservicio de videos
            String url = String.format("%s/videos/top", videoServiceUrl);

            // Envía una solicitud GET al microservicio y obtiene el número de likes como un Integer
            // Envía una solicitud GET al microservicio de videos y obtiene un arreglo
            Video[] videosArray = restTemplate.getForObject(url, Video[].class);

            // Convierte el arreglo en un ArrayList para una mejor gestión
            return new ArrayList<>(Arrays.asList(videosArray));
        } catch (HttpClientErrorException e) {
            // Maneja errores como un 400 o 404
            System.err.println("Error al obtener el número de likes: " + e.getMessage());
            return null; // Devuelve null en caso de error
        }
    }
    
    public ArrayList<Video> getRandomVideosByUserId(Long userId) {
        try {
            // Validar que el ID no sea nulo o negativo
            if (userId == null || userId <= 0) {
                System.out.println("ID de usuario inválido");
                return new ArrayList<>(); // Devuelve una lista vacía si el ID es inválido
            }

            // Construye la URL para el endpoint del microservicio de videos
            String url = String.format("%s/videos/user/%d/randomVideos", videoServiceUrl, userId);

            // Envía una solicitud GET al microservicio y obtiene un arreglo de videos
            Video[] videosArray = restTemplate.getForObject(url, Video[].class);

            // Convierte el arreglo a una lista y la retorna
            return new ArrayList<>(Arrays.asList(videosArray));
        } catch (HttpClientErrorException e) {
            // Maneja errores HTTP como 400 o 404
            System.err.println("Error al obtener videos aleatorios: " + e.getMessage());
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        } catch (Exception e) {
            // Maneja errores no previstos
            e.printStackTrace();
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }

    
    
}
