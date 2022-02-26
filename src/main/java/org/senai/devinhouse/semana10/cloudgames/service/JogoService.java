package org.senai.devinhouse.semana10.cloudgames.service;

import org.senai.devinhouse.semana10.cloudgames.model.Genero;
import org.senai.devinhouse.semana10.cloudgames.model.Jogo;
import org.senai.devinhouse.semana10.cloudgames.model.Midia;
import org.senai.devinhouse.semana10.cloudgames.model.Usuario;
import org.senai.devinhouse.semana10.cloudgames.parameter.JogoPostParameter;
import org.senai.devinhouse.semana10.cloudgames.repository.JogoRepository;
import org.senai.devinhouse.semana10.cloudgames.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    public Page<Jogo> listar(List<Genero> generosPassados, Integer p) {
        List<Genero> generos = new ArrayList<>();
        if(generosPassados != null){
            generos.addAll(generosPassados);
        } else {
            generos.addAll(Arrays.asList(Genero.values()));
        }
        PageRequest pageRequest = PageRequest.of(p-1, 2, Sort.by("nome"));
        return repository.findByGeneroIn(generos, pageRequest);
    }

    public Jogo salvar(JogoPostParameter parameter) {
        Jogo jogo = new Jogo();
        jogo.setNome(parameter.getNome());
        jogo.setGenero(Genero.valueOf(parameter.getGenero()));

        Midia capa = new Midia();

        capa.setUrl(parameter.getCapa());
        capa.setJogo(jogo);

        jogo.setCapa(capa);

        return repository.save(jogo);
    }

    public Jogo atualizar(JogoPostParameter parameter, Long id){
        Optional<Jogo> optionalJogo = repository.findById(id);

        Jogo jogo = optionalJogo.orElseThrow(() -> new IllegalArgumentException("O id é inválido."));

        jogo.setNome(parameter.getNome());
        jogo.setGenero(Genero.valueOf(parameter.getGenero()));

        jogo.getCapa().setUrl(parameter.getCapa());

        return repository.save(jogo);
    }

    public void deletar(Long id) {
        Optional<Jogo> optionalJogo = repository.findById(id);
        Jogo jogo = optionalJogo.orElseThrow(NotFoundException::new);

        repository.delete(jogo);
    }
}
