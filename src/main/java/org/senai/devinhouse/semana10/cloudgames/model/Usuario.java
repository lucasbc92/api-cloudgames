package org.senai.devinhouse.semana10.cloudgames.model;

import org.senai.devinhouse.semana10.cloudgames.parameter.UsuarioPostParameter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_ger")
    @SequenceGenerator(name = "usuario_ger", sequenceName = "usuario_seq")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "biblioteca",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_jogo", referencedColumnName = "id")
    )
    private List<Jogo> biblioteca = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(UsuarioPostParameter parameter) throws DateTimeParseException{
            this.id = parameter.getId();
            this.nome = parameter.getNome();
            this.email = parameter.getEmail();
            this.login = parameter.getLogin();
            this.senha = parameter.getSenha();
            this.cpf = parameter.getCpf();
            this.rg = parameter.getRg();
            // a data vai vir no formato dd/mm/yyyy
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(parameter.getDataNascimento(), dateTimeFormatter);
            this.dataNascimento = dataNascimento;
    }

    public void adicionarJogo(Jogo jogo){
        biblioteca.add(jogo);
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<Jogo> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(List<Jogo> biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
