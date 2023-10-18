package com.dio.listadetarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dio.listadetarefas.model.Tarefa;
import com.dio.listadetarefas.service.TarefaServiceImpl;

@RestController
@RequestMapping("/tasks")
public class TarefaController {
	
	@Autowired
	private TarefaServiceImpl tarefaService;
	
	@GetMapping
	public ResponseEntity<Iterable<Tarefa>> buscarTodos(){
		Iterable<Tarefa> tarefas = tarefaService.buscarTodos();
		return ResponseEntity.ok(tarefas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(tarefaService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa){
		Tarefa novaTarefa = tarefaService.inserir(tarefa);
		return ResponseEntity.ok(novaTarefa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
		tarefaService.atualizar(id, tarefa);
		return ResponseEntity.ok(tarefa);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		tarefaService.deletar(id);
		return ResponseEntity.ok().build();
	}

}
