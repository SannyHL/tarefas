package com.br.tarefas.service;

import com.br.tarefas.model.Tarefa;
import com.br.tarefas.model.dto.TarefaDTO;

import java.util.List;

public interface TarefaService {

    List<TarefaDTO> buscarTodasTarefas();
    TarefaDTO buscarTarefaPorId(Integer id);
    Integer salvarTarefa(TarefaDTO tarefaDTO);
    void excluirTarefa(Integer id);
    Integer atualizarTarefa(TarefaDTO tarefaDTO);
}
