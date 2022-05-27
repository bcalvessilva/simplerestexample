package br.com.curtaocodigo.simplerestexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idade;

    public User(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public User() {
        //default constructor
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Long getId() {
        return id;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
