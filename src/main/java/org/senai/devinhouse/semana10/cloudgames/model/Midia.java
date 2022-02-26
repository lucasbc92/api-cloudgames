package org.senai.devinhouse.semana10.cloudgames.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Midia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "midia_ger")
    @SequenceGenerator(name = "midia_ger", sequenceName = "midia_seq")
    private Long id;

    @Column(nullable = false)
    private String url;

    // @OneToOne e @ManyToOne é EAGER por padrão.
    // @OneToMany e @ManyToMany é LAZY.
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id")
    private Jogo jogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
