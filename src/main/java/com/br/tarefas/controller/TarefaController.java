package com.br.tarefas.controller;

import com.br.tarefas.model.dto.TarefaDTO;
import com.br.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Integer> salvarTarefa(@RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.ok(tarefaService.salvarTarefa(tarefaDTO));
    }

    @GetMapping
    public  ResponseEntity<List<TarefaDTO>> buscarTodasTarefas(){
        return ResponseEntity.ok(tarefaService.buscarTodasTarefas());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TarefaDTO> buscarTarefaPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(tarefaService.buscarTarefaPorId(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> excluirTarefa(@PathVariable("id") Integer id){
        tarefaService.excluirTarefa(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/atualizar")
    public  ResponseEntity<Integer> atualizarTarefa(@RequestBody TarefaDTO tarefaDTO){
        Integer idTarefa = tarefaService.atualizarTarefa(tarefaDTO);
        return ResponseEntity.ok(idTarefa);
    }
}
