package com.dio.listadetarefas.service;

import com.dio.listadetarefas.model.Tarefa;

public interface TarefaService {
	
	Iterable<Tarefa> buscarTodos();
	
	Tarefa buscarPorId (Long Id);
	
	Tarefa inserir (Tarefa tarefa);
	
	Tarefa atualizar (Long id, Tarefa tarefa);
	
	void deletar (Long id);
	
}
