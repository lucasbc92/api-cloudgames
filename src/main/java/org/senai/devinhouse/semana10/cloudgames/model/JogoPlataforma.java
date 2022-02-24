package org.senai.devinhouse.semana10.cloudgames.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jogo_plataforma")
public class JogoPlataforma {
   @EmbeddedId
   private JogoPlataformaKey id;

   @ManyToOne
   @MapsId("idJogo")
   @JoinColumn(name = "id_jogo")
   private Jogo jogo;

   @ManyToOne
   @MapsId("idPlataforma")
   @JoinColumn(name = "id_plataforma")
   private Plataforma plataforma;

   @Column(name = "dt_lancamento")
   private LocalDate dataLancamento;

   public JogoPlataforma(){

   }

   public JogoPlataforma(Jogo jogo, Plataforma plataforma) {
      this.jogo = jogo;
      this.plataforma = plataforma;
      this.id = new JogoPlataformaKey(jogo.getId(), plataforma.getId());
   }

   public JogoPlataformaKey getId() {
      return id;
   }

   public void setId(JogoPlataformaKey id) {
      this.id = id;
   }

   public Jogo getJogo() {
      return jogo;
   }

   public void setJogo(Jogo jogo) {
      this.jogo = jogo;
   }

   public Plataforma getPlataforma() {
      return plataforma;
   }

   public void setPlataforma(Plataforma plataforma) {
      this.plataforma = plataforma;
   }

   public LocalDate getDataLancamento() {
      return dataLancamento;
   }

   public void setDataLancamento(LocalDate dataLancamento) {
      this.dataLancamento = dataLancamento;
   }
}
