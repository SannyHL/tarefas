package com.br.tarefas.mapper;

import com.br.tarefas.model.Tarefa;
import com.br.tarefas.model.dto.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR )
public interface TarefaMapper {
    Tarefa paraEntidade(TarefaDTO tarefaDTO);
    TarefaDTO paraDto(Tarefa tarefa);
    List<Tarefa> paraEntidade(List<TarefaDTO> tarefaDTOList);
    List<TarefaDTO> paraDto(List<Tarefa> tarefaList);
}
