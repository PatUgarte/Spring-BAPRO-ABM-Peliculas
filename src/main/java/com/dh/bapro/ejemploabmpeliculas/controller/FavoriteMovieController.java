package com.dh.bapro.ejemploabmpeliculas.controller;

import com.dh.bapro.ejemploabmpeliculas.model.Movie;
import com.dh.bapro.ejemploabmpeliculas.model.User;
import com.dh.bapro.ejemploabmpeliculas.repository.MovieJpaRepository;
import com.dh.bapro.ejemploabmpeliculas.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/favorites")
public class FavoriteMovieController {

    @Autowired
    MovieJpaRepository movieJpaRepository;
    @Autowired
    UserJpaRepository userJpaRepository;

    @PostMapping("/add/{movie_id}")
    public String addFavorite(@PathVariable("movie_id") Long movie_id) {
        //busco a la peli por el id
        Optional<Movie> opt2 = this.movieJpaRepository.findById(movie_id);
        //lo mismo del user lo hacemos para la movie
        Movie movie = opt2.get();

        //en teoria deberia de ser el id del usuario que esta logueado
        Optional<User> opt = this.userJpaRepository.findById((long) 1);
        //esto tengo que hacerlo para obtener el user.
        User user = opt.get();

        //agrego la movie al listado de pelis favoritas
        user.addFavouriteMovie(movie);

        //guardo al usuario en la base usando el repositorio
        this.userJpaRepository.save(user);

        return "redirect:/pelicula/all";
    }

    @GetMapping("")
    public String show(Model model) {
        //en teoria deberia de ser el id del usuario que esta logueado
        Optional<User> opt = this.userJpaRepository.findById((long) 1);
        //esto tengo que hacerlo para obtener el user.
        User user = opt.get();

        //el listado de las favoritas
        List<Movie> favorites = user.getFavorites();

        model.addAttribute("favorites", favorites);
        return "favorites";
    }
}
