package org.senai.devinhouse.semana10.cloudgames.repository;

import org.senai.devinhouse.semana10.cloudgames.model.Genero;
import org.senai.devinhouse.semana10.cloudgames.model.Jogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JogoRepository extends PagingAndSortingRepository<Jogo, Long> {
    Page<Jogo> findByGeneroIn(List<Genero> genero, Pageable pageable);
}
