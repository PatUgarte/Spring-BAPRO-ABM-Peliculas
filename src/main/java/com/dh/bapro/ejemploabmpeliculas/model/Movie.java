package com.dh.bapro.ejemploabmpeliculas.model;

public class Movie {

	private Long id;
	private String title;
	private Double rating;
	private Integer releaseYear;
	private String country;

	public Movie() {
		super();
	}

	public Movie(String title, Double rating, Integer releaseYear, String country) {
		super();
		this.title = title;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.country = country;
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

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
