package org.senai.devinhouse.semana10.cloudgames.repository;

import org.senai.devinhouse.semana10.cloudgames.model.Jogo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends PagingAndSortingRepository<Jogo, Long> {
}
