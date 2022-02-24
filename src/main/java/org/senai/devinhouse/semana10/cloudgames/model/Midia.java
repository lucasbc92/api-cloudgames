package org.senai.devinhouse.semana10.cloudgames.model;

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
}
