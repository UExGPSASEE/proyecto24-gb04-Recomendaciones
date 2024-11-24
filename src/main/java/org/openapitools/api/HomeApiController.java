package org.openapitools.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.openapitools.model.User;
import org.openapitools.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import service.UserService;
import service.VideoService;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-16T17:45:57.620163600+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.tubeFlixRecomendacionesYVisualizacionesOpenAPI30.base-path:}")
public class HomeApiController implements HomeApi {
	
	@Autowired
	private VideoService videoservice;
	@Autowired
	private UserService userservice;

    private final NativeWebRequest request;

    public HomeApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @Override
    public ResponseEntity<List<Video>> getVideosByGenre(String genre) {
		System.out.println("-------- HomeApiController -> getVideosByGenre() -----------");

    	System.out.println("Service: Llamada a servicio de videos para obtener videos según el genero dado");
    	ArrayList<Video> videos = videoservice.getVideosByGenre(genre);
    	
            return new ResponseEntity<>(videos,HttpStatus.OK);
        }
    
    @Override
    public ResponseEntity<List<Video>> searchVideosByTitle(String query) {
		System.out.println("-------- HomeApiController -> searchVideosByTitle() -----------");
    	
    	System.out.println("Service: Llamada a servicio de videos para obtener los videos por el titulo");
    	ArrayList<Video> videos = videoservice.getVideosByTitle(query);
    	
            return new ResponseEntity<>(videos,HttpStatus.OK);

        }
    
    @Override
    public ResponseEntity<List<Video>> getUserVideoHistory(
            @NotNull @Parameter(name = "username", description = "Nombre del usuario", required = true, in = ParameterIn.QUERY) 
            @PathVariable("username") String username
        ) {
		System.out.println("-------- HomeApiController -> getUserVideoHistory() -----------");
		
    	System.out.println("Service: Llamada a servicio de videos para obtener historial");
    	ArrayList<Video> videoList = userservice.getUserVideoHistory(username);
    	
            return new ResponseEntity<>(videoList,HttpStatus.OK);
        }
    
    @Override
    public ResponseEntity<List<Video>> getTopVideos() {
		System.out.println("-------- HomeApiController -> getTopVideos() -----------");
		
		
    	System.out.println("Service: Llamada a servicio de videos para obtener el top de videos");
    	ArrayList<Video> videos = videoservice.getTopVideos();
    	
        return new ResponseEntity<>(videos,HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<List<Video>> getRecommendationsByUsername(
            @NotNull @Parameter(name = "username", description = "Nombre del usuario", required = true, in = ParameterIn.PATH) 
            @PathVariable("username") String username
    ) {
		System.out.println("-------- HomeApiController -> getRecommendationsByUsername() -----------");

        // Obtener el historial de videos del usuario
    	System.out.println("Service: Llamada a servicio de usuarios para obtener el historial de videos");
        ArrayList<Video> videoList = userservice.getUserVideoHistory(username);

        if (videoList == null || videoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuario sin historial
        }

        // Contar el número de videos por género
        Map<String, Integer> genreCounts = new HashMap<>();

        for (Video video : videoList) {
            String genre = video.getGenre();

            if (genre != null) {
                genreCounts.put(genre, genreCounts.getOrDefault(genre, 0) + 1);
            }
        }

        // Determinar el género más visto
        String mostViewedGenre = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : genreCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostViewedGenre = entry.getKey();
            }
        }

        if (mostViewedGenre == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // No se pudo determinar el género
        }

        // Obtener los videos del género más visto
    	System.out.println("Service: Llamada a servicio de videos para obtener los videos de un genero");
        ArrayList<Video> videos = videoservice.getVideosByGenre(mostViewedGenre);

        if (videos == null || videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // No hay videos en este género
        }

        return new ResponseEntity<>(videos, HttpStatus.OK); // Lista de videos del género más visto
    }
    
    @Override
    public ResponseEntity<List<Video>> getVideosByFollowing(
            @PathVariable("username") String username
        ) {
		System.out.println("-------- HomeApiController -> getVideosByFollowing() -----------");
    	
    		ArrayList<Video> FollowingVideos = new ArrayList<Video>();
    		
        	System.out.println("Service: Llamada a servicio de usuarios para obtener los ids de los usuarios seguidos");
            ArrayList<Long> idFollowing = userservice.getFollowingIds(username);
            
            for(Long id : idFollowing) {
            	System.out.println("Service: Llamada a servicio de videos para obtener videos aleatorios de un usuario con su id");
            	FollowingVideos.addAll(videoservice.getRandomVideosByUserId(id));
            }
            
            return new ResponseEntity<>(FollowingVideos, HttpStatus.OK); // Lista de videos del género más visto
        }
    
    @Override
    public ResponseEntity<List<User>> getProfilesByFollowing(
            @PathVariable("username") String username
        ) {
    		System.out.println("-----HomeAPI : getProfilesByFollowing() ------");
    		ArrayList<User> FollowingProfiles = new ArrayList<User>();
        	System.out.println("Service: Llamada a servicio de usuarios para obtener los usuarios seguidos");
            FollowingProfiles = userservice.getFollowingProfiles(username);
            
            return new ResponseEntity<>(FollowingProfiles, HttpStatus.OK); // Lista de videos del género más visto
        }
    
    @Override
    public ResponseEntity<List<User>> getProfilesByNotFollowing(
            @PathVariable("username") String username
        ) {
    		System.out.println("-----HomeAPI : getProfilesByNotFollowing() ------");
    		ArrayList<User> notFollowingProfiles = new ArrayList<User>();
        	System.out.println("Service: Llamada a servicio de usuarios para obtener los usuarios no seguidos");
            notFollowingProfiles = userservice.getNotFollowingProfiles(username);
            
            return new ResponseEntity<>(notFollowingProfiles, HttpStatus.OK); // Lista de videos del género más visto
        }
}
