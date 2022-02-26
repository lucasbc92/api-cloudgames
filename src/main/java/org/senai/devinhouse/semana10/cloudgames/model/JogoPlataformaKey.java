package org.senai.devinhouse.semana10.cloudgames.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoPlataformaKey that = (JogoPlataformaKey) o;
        return idJogo.equals(that.idJogo) && idPlataforma.equals(that.idPlataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJogo, idPlataforma);
    }
}
