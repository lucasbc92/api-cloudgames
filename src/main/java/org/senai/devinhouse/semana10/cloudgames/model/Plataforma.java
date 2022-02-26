package org.senai.devinhouse.semana10.cloudgames.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plataforma_ger")
    @SequenceGenerator(name = "plataforma_ger", sequenceName = "plataforma_seq")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plataforma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JogoPlataforma> jogos;


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

    @Override
    public String toString() {
        return "Plataforma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
