package com.br.tarefas.repository;

import com.br.tarefas.model.Tarefa;
import com.br.tarefas.model.dto.TarefaDTO.TarefaDTOInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query(value = "SELECT ID AS id, NOME AS nome, DATA AS data, LOCAL AS local FROM TAREFA", nativeQuery = true)
    List<TarefaDTOInterface> buscarTodasTarefas();

    @Query(value = "SELECT ID AS id, NOME AS nome, DATA AS data, LOCAL AS local FROM TAREFA WHERE ID = :id", nativeQuery = true)
    TarefaDTOInterface buscarTarefasPorId(@Param("id") Integer id);
}
