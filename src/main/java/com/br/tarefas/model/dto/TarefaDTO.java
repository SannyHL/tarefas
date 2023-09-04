package com.br.tarefas.model.dto;

import java.util.Date;

public class TarefaDTO {
    private Integer id;
    private String nome;
    private Date data;
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

    public TarefaDTO(Integer id, String nome, Date data, String local) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
    }

    public TarefaDTO() {
    }

    public TarefaDTO(TarefaDTOInterface x){
        this.id = x.getId();
        this.data = x.getData();
        this.nome = x.getNome();
        this.local = x.getLocal();
    }

    public interface TarefaDTOInterface{
        Integer getId();
        String getNome();
        Date getData();
        String getLocal();
    }
}
