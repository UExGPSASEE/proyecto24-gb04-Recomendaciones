package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Video
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-16T17:45:57.620163600+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Video {

  private Long id;

  private String duration;

  private String title;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime uploadDate;

  private String description;

  private String genre;

  private Integer likes;

  private Boolean ageRestricted;

  @Valid
  private List<String> countryRestricted = new ArrayList<>();

  private Integer user;

  public Video id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID único del video (clave primaria).
   * @return id
   */
  
  @Schema(name = "id", description = "ID único del video (clave primaria).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Video duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duración del video en formato HH:MM:SS.
   * @return duration
   */
  
  @Schema(name = "duration", description = "Duración del video en formato HH:MM:SS.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Video title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Título del video.
   * @return title
   */
  
  @Schema(name = "title", description = "Título del video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Video uploadDate(OffsetDateTime uploadDate) {
    this.uploadDate = uploadDate;
    return this;
  }

  /**
   * Fecha y hora de subida del video.
   * @return uploadDate
   */
  @Valid 
  @Schema(name = "uploadDate", description = "Fecha y hora de subida del video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploadDate")
  public OffsetDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(OffsetDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }

  public Video description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción del video.
   * @return description
   */
  
  @Schema(name = "description", description = "Descripción del video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Video genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * Género del video.
   * @return genre
   */
  
  @Schema(name = "genre", description = "Género del video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("genre")
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Video likes(Integer likes) {
    this.likes = likes;
    return this;
  }

  /**
   * Número de \"me gustas\" para el video.
   * @return likes
   */
  
  @Schema(name = "likes", description = "Número de \"me gustas\" para el video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("likes")
  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }

  public Video ageRestricted(Boolean ageRestricted) {
    this.ageRestricted = ageRestricted;
    return this;
  }

  /**
   * Indica si el contenido está restringido para usuarios mayores de edad.
   * @return ageRestricted
   */
  
  @Schema(name = "ageRestricted", description = "Indica si el contenido está restringido para usuarios mayores de edad.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ageRestricted")
  public Boolean getAgeRestricted() {
    return ageRestricted;
  }

  public void setAgeRestricted(Boolean ageRestricted) {
    this.ageRestricted = ageRestricted;
  }

  public Video countryRestricted(List<String> countryRestricted) {
    this.countryRestricted = countryRestricted;
    return this;
  }

  public Video addCountryRestrictedItem(String countryRestrictedItem) {
    if (this.countryRestricted == null) {
      this.countryRestricted = new ArrayList<>();
    }
    this.countryRestricted.add(countryRestrictedItem);
    return this;
  }

  /**
   * Lista de países a los que se restringe el acceso al video.
   * @return countryRestricted
   */
  
  @Schema(name = "countryRestricted", description = "Lista de países a los que se restringe el acceso al video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("countryRestricted")
  public List<String> getCountryRestricted() {
    return countryRestricted;
  }

  public void setCountryRestricted(List<String> countryRestricted) {
    this.countryRestricted = countryRestricted;
  }

  public Video user(Integer user) {
    this.user = user;
    return this;
  }

  /**
   * Clave que referencia al usuario que ha subido el video.
   * @return user
   */
  
  @Schema(name = "user", description = "Clave que referencia al usuario que ha subido el video.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user")
  public Integer getUser() {
    return user;
  }

  public void setUser(Integer user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Video video = (Video) o;
    return Objects.equals(this.id, video.id) &&
        Objects.equals(this.duration, video.duration) &&
        Objects.equals(this.title, video.title) &&
        Objects.equals(this.uploadDate, video.uploadDate) &&
        Objects.equals(this.description, video.description) &&
        Objects.equals(this.genre, video.genre) &&
        Objects.equals(this.likes, video.likes) &&
        Objects.equals(this.ageRestricted, video.ageRestricted) &&
        Objects.equals(this.countryRestricted, video.countryRestricted) &&
        Objects.equals(this.user, video.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, duration, title, uploadDate, description, genre, likes, ageRestricted, countryRestricted, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Video {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    uploadDate: ").append(toIndentedString(uploadDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    likes: ").append(toIndentedString(likes)).append("\n");
    sb.append("    ageRestricted: ").append(toIndentedString(ageRestricted)).append("\n");
    sb.append("    countryRestricted: ").append(toIndentedString(countryRestricted)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

