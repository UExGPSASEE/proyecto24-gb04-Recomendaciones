package service;

import java.util.ArrayList;
import java.util.Arrays;

import org.openapitools.model.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private final String videoServiceUrl = "http://localhost:8081"; // URL del microservicio de videos actualizado

	public ArrayList<Video> getUserVideoHistory(String username) {
	    try {
	        // Construye la URL con el nombre de usuario como parámetro
	        String url = String.format("%s/user/%s/history", videoServiceUrl, username);

	        // Envía una solicitud GET al microservicio de videos y obtiene un arreglo
	        Video[] videosArray = restTemplate.getForObject(url, Video[].class);

	        // Convierte el arreglo en un ArrayList para una mejor gestión
	        return new ArrayList<>(Arrays.asList(videosArray));
	    } catch (HttpClientErrorException e) {
	        // Maneja errores, como un 400 o 404
	        return new ArrayList<>(); // Devuelve una lista vacía si ocurre un error
	    }
	}
	
	


}
