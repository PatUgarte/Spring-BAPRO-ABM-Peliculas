package com.dh.bapro.ejemploabmpeliculas.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name="movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "El titulo no puede ser vacio")
	@Size(min=2, max=30, message = "Titulo debe de estar entre 2 y 30 letras")
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private Double rating;
	@Column
	private Integer awards;

	@Column
	private String poster;

	@ManyToOne //pertenece a un genero
	@JoinColumn(name = "genre_id")
	private Genre genre;

	//aqui cree la relacion para saber a que usuarios les gusta una pelicula, hago referencia a favouriteMovies que es el atributo de User
	@ManyToMany(mappedBy = "favouriteMovies")
	private List<User> users;


	public Movie() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getAwards() {
		return awards;
	}

	public void setAwards(Integer awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
