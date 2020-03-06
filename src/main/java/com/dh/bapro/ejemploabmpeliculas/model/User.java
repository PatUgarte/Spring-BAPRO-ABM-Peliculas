package com.dh.bapro.ejemploabmpeliculas.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    //aqui creo la relacion y la tabla, seria la tabla "favourite_movies" (carrito) con esto es suficiente
    @JoinTable(
            name = "favourite_movies",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="movie_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Movie> favouriteMovies;

    public User() {
        this.favouriteMovies = new ArrayList<Movie>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userName) {
        this.email = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addFavouriteMovie(Movie movie)
    {
        if(this.favouriteMovies == null){
            this.favouriteMovies = new ArrayList<>();
        }

        this.favouriteMovies.add(movie);
    }

    public List<Movie> getFavorites()
    {
        return this.favouriteMovies;
    }
}
