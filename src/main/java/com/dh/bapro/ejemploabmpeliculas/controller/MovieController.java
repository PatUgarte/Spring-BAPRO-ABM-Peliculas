package com.dh.bapro.ejemploabmpeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dh.bapro.ejemploabmpeliculas.model.Movie;
import com.dh.bapro.ejemploabmpeliculas.repository.MovieJpaRepository;

@Controller
@RequestMapping("pelicula")
public class MovieController {
	
	@Autowired
	MovieJpaRepository movieJpaRepository;
	
	// Al entrar POR GET al localhost:8080/pelicula/add
	@GetMapping("add")
	public String movieForm() {
		return "add-movie";
	}
	
	// Al entrar POR POST al localhost:8080/pelicula/add
	@PostMapping("add")
	public String insertMovie(Movie pelicula) {
		movieJpaRepository.save(pelicula);
		return "home";
	}
	
	// Al entrar POR GET al localhost:8080/pelicula/all
	@GetMapping("all")
	public String showAllMovies(Model model) {
		List<Movie> movieList = movieJpaRepository.findAll();
		model.addAttribute("listaPeliculas", movieList);
		return "movies";
	}
}
