package com.br.tarefas.service.serviceImpl;

import com.br.tarefas.mapper.TarefaMapper;
import com.br.tarefas.model.Tarefa;
import com.br.tarefas.model.dto.TarefaDTO;
import com.br.tarefas.repository.TarefaRepository;
import com.br.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaServiceImpl implements TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    TarefaMapper tarefaMapper;

    @Override
    public List<TarefaDTO> buscarTodasTarefas() {
        List<TarefaDTO> tarefaDTOS = tarefaRepository.buscarTodasTarefas().stream().map(TarefaDTO::new).collect(Collectors.toList());
        return tarefaDTOS;
    }

    @Override
    public TarefaDTO buscarTarefaPorId(Integer id) {
        TarefaDTO.TarefaDTOInterface tarefaDTOInterface = tarefaRepository.buscarTarefasPorId(id);
        if(tarefaDTOInterface != null){
            TarefaDTO tarefaDTO = new TarefaDTO(tarefaDTOInterface);
            return tarefaDTO;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhuma tarefa encontrada com esse id.");
    }

    @Override
    public Integer salvarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.paraEntidade(tarefaDTO);
        tarefaRepository.saveAndFlush(tarefa);
        return tarefa.getId();
    }

    @Override
    public void excluirTarefa(Integer id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public Integer atualizarTarefa(TarefaDTO tarefaDTO) {
        if(tarefaDTO.getId() != null){
            Tarefa tarefa = tarefaMapper.paraEntidade(tarefaDTO);
            tarefaRepository.saveAndFlush(tarefa);
            return tarefa.getId();
        } throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o id para atualização.");
    }


}
