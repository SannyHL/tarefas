package com.br.tarefas.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TAREFA")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA")
    private Date data;
    @Column(name = "LOCAL")
    private String local;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Tarefa() {
    }
    public Tarefa(Integer id, String nome, Date data, String local) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
    }

}
