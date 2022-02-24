package org.senai.devinhouse.semana10.cloudgames.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_ger")
    @SequenceGenerator(name = "jogo_ger", sequenceName = "jogo_seq")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "jogo")
    private Midia capa;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<JogoPlataforma> plataformas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Midia getCapa() {
        return capa;
    }

    public void setCapa(Midia capa) {
        this.capa = capa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

//    public List<JogoPlataforma> getPlataformas() {
//        return plataformas;
//    }
//
//    public void setPlataformas(List<JogoPlataforma> plataformas) {
//        this.plataformas = plataformas;
//    }
}
