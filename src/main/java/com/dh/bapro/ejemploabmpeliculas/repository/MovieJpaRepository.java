package com.dh.bapro.ejemploabmpeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.bapro.ejemploabmpeliculas.model.Movie;

public interface MovieJpaRepository extends JpaRepository<Movie, Long> {

}
