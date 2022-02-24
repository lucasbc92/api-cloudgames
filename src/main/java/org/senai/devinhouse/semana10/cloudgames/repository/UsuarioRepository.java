package org.senai.devinhouse.semana10.cloudgames.repository;

import org.senai.devinhouse.semana10.cloudgames.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    List<Usuario> findByNomeLike(String nome);

    @Query(value = "SELECT * FROM lista2.usuario WHERE email ILIKE %:email%", nativeQuery = true)
    List<Usuario> findByEmail(String email);

    @Query(value = "SELECT * FROM lista2.usuario WHERE nome ILIKE %:nome% AND email ILIKE %:email%", nativeQuery = true)
    List<Usuario> findByNomeAndEmail(String nome, String email);
}
