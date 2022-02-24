package org.senai.devinhouse.semana10.cloudgames.api.v1;

import org.senai.devinhouse.semana10.cloudgames.model.Usuario;
import org.senai.devinhouse.semana10.cloudgames.parameter.UsuarioPostParameter;
import org.senai.devinhouse.semana10.cloudgames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> get(@RequestParam(required = false) String nome, @RequestParam(required = false) String email) {
        if(nome == null && email == null){
            List<Usuario> result = new ArrayList<>();

            Iterable<Usuario> usuarioEntityIterable = repository.findAll();
            Iterator<Usuario> iterator = usuarioEntityIterable.iterator();
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }

            return result;
        } else if(nome == null && email != null){
            return repository.findByEmail(email);
        } else if(nome != null && email == null){
            return repository.findByNomeLike(nome);
        } else {
            return repository.findByNomeAndEmail(nome, email);
        }
    }

//    @GetMapping("/nome")
//    public List<Usuario> getByNome(@RequestParam String nome) {
//        return repository.findByNomeLike(nome);
//    }
//
//    @GetMapping("/email")
//    public List<Usuario> getByEmail(@RequestParam String email) {
//        return repository.findByEmail(email);
//    }

    @PostMapping
    public ResponseEntity<Long> post(@RequestBody UsuarioPostParameter usuarioPostParameter) {
        Usuario usuario;

        try {
            usuario = new Usuario(usuarioPostParameter);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        usuario = repository.save(usuario);
        return new ResponseEntity<>(usuario.getId(), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchSenha(@PathVariable Long id,
                                          @RequestBody String senha) {
        Optional<Usuario> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Usuario usuarioEntity = optionalUsuario.get();
        usuarioEntity.setSenha(senha);
        repository.save(usuarioEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable Long id,
                                    @RequestBody UsuarioPostParameter usuarioPostParameter) {
        Usuario usuario;

        try {
            usuario = new Usuario(usuarioPostParameter);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Usuario> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!id.equals(usuario.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        repository.save(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(optionalUsuario.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
