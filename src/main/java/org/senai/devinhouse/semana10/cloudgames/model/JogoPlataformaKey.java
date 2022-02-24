package org.senai.devinhouse.semana10.cloudgames.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JogoPlataformaKey implements Serializable {
    @Column(name = "id_jogo")
    private Long idJogo;

    @Column(name = "id_plataforma")
    private Long idPlataforma;

    public JogoPlataformaKey(){

    }

    public JogoPlataformaKey(Long idJogo, Long idPlataforma) {
        this.idJogo = idJogo;
        this.idPlataforma = idPlataforma;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }
}
