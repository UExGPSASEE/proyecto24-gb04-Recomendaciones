package org.openapitools.api;

import org.openapitools.model.Video;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import service.UserService;
import service.VideoService;

import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

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
    	
    	ArrayList<Video> videos = videoservice.getVideosByGenre(genre);
    	
            return new ResponseEntity<>(videos,HttpStatus.OK);
        }
    
    @Override
    public ResponseEntity<List<Video>> searchVideosByTitle(
            @NotNull @Parameter(name = "title", description = "Título del video a buscar", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "title", required = true) String title
        ) {
    	
    	ArrayList<Video> videos = videoservice.getVideosByTitle(title);
    	
            return new ResponseEntity<>(videos,HttpStatus.OK);

        }
    
    @Override
    public ResponseEntity<Integer> countLikesByVideoId(
            @NotNull @Parameter(name = "id", description = "ID del video para el cual contar los likes", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
        ) {
    	
    	Integer likeCount = videoservice.getLikesFromVideo(id);
    	
            return new ResponseEntity<>(likeCount,HttpStatus.OK);

        }
    
    @Override
    public ResponseEntity<List<Video>> getUserVideoHistory(
            @NotNull @Parameter(name = "username", description = "Nombre del usuario", required = true, in = ParameterIn.QUERY) 
            @PathVariable("username") String username
        ) {
    	
    	
    	ArrayList<Video> videoList = userservice.getUserVideoHistory(username);
    	
            return new ResponseEntity<>(videoList,HttpStatus.OK);
        }
    
    @Override
    public ResponseEntity<Long> countViewsByVideoId(
            @NotNull @Parameter(name = "id", description = "ID del video para el cual contar los views", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
        ) {
    	
    	Long viewsCount = videoservice.getViewsFromVideo(id);
    	
            return new ResponseEntity<>(viewsCount,HttpStatus.OK);
        }
    
    @Override
    public ResponseEntity<List<Video>> getTopVideos() {
        
    	ArrayList<Video> videos = videoservice.getTopVideos();
    	
        return new ResponseEntity<>(videos,HttpStatus.OK);
    }

}
