package org.senai.devinhouse.semana10.cloudgames.api.v1;

import org.senai.devinhouse.semana10.cloudgames.model.Genero;
import org.senai.devinhouse.semana10.cloudgames.model.Jogo;
import org.senai.devinhouse.semana10.cloudgames.model.Usuario;
import org.senai.devinhouse.semana10.cloudgames.parameter.JogoPostParameter;
import org.senai.devinhouse.semana10.cloudgames.parameter.UsuarioPostParameter;
import org.senai.devinhouse.semana10.cloudgames.repository.JogoRepository;
import org.senai.devinhouse.semana10.cloudgames.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/jogo")
public class JogoController {

    @Autowired
    private JogoRepository repository;

    @Autowired
    private JogoService service;

    @GetMapping
    public Page<Jogo> get(
            @RequestParam(required = false, name = "genero") List<Genero> generos,
            @RequestParam(required = false, defaultValue = "1") Integer p
    ){
        Page<Jogo> resultPage = service.listar(generos, p);
        return resultPage;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> getById(@PathVariable("id") Long id) {

        Optional<Jogo> institution = this.repository.findById(id);

        return institution.isPresent()
                ? ResponseEntity.ok(institution.get())
                : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Jogo> post(@RequestBody JogoPostParameter parameter){
        Jogo jogo = service.salvar(parameter);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jogo.getId()).toUri();

        return ResponseEntity.created(location).body(jogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable Long id,
                                    @RequestBody JogoPostParameter parameter) {

        Jogo jogo = service.atualizar(parameter, id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
