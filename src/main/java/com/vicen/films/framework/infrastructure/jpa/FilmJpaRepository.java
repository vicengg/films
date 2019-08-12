package com.vicen.films.framework.infrastructure.jpa;

import com.vicen.films.framework.infrastructure.jpa.dto.FilmJpaDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FilmJpaRepository extends CrudRepository<FilmJpaDto, UUID> {

    @Override
    List<FilmJpaDto> findAll();

}
