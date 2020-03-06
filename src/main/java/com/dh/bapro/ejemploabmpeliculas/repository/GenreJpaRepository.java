package com.dh.bapro.ejemploabmpeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.bapro.ejemploabmpeliculas.model.Genre;

public interface GenreJpaRepository extends JpaRepository<Genre, Long> {
}
