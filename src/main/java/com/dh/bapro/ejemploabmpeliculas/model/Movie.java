package com.dh.bapro.ejemploabmpeliculas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	public Movie() { }

	public Movie(String title, Double rating) {
		super();
		this.title = title;
		this.rating = rating;
	}

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
}
