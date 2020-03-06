package com.dh.bapro.ejemploabmpeliculas.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.dh.bapro.ejemploabmpeliculas.repository.GenreJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dh.bapro.ejemploabmpeliculas.model.Movie;
import com.dh.bapro.ejemploabmpeliculas.repository.MovieJpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("pelicula")
public class MovieController {

	private String upload_folder = ".//src//main//resources//static//posters//";

	private MovieJpaRepository movieJpaRepository;
	private GenreJpaRepository genreJpaRepository;

	public MovieController(MovieJpaRepository movieJpaRepository, GenreJpaRepository genreJpaRepository)
	{
		this.movieJpaRepository = movieJpaRepository;
		this.genreJpaRepository = genreJpaRepository;
	}
	
	// Al entrar POR GET al localhost:8080/pelicula/add
	@GetMapping("add")
	public String movieForm(Movie movie, Model model) {
		model.addAttribute("genres", this.genreJpaRepository.findAll());
		return "add-movie";
	}
	
	// Al entrar POR POST al localhost:8080/pelicula/add
	@PostMapping("add")
	public String insertMovie(@Valid Movie movie, BindingResult bindingResult
			, RedirectAttributes redirAttrs
	) {
		if (bindingResult.hasErrors()) {
			return "add-movie";
		}


		movieJpaRepository.save(movie);
		redirAttrs.addFlashAttribute("mensaje", "Pelicula guardada exitosamente");

		return "redirect:/pelicula/all";
	}
	
	// Al entrar POR GET al localhost:8080/pelicula/all
	@GetMapping("all")
	public String showAllMovies(Model model) {
		List<Movie> movieList = movieJpaRepository.findAll();
		model.addAttribute("listaPeliculas", movieList);
		return "movies";
	}
}
