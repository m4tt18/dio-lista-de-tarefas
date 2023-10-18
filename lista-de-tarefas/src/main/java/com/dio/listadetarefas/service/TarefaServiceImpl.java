package com.dio.listadetarefas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.listadetarefas.model.Tarefa;
import com.dio.listadetarefas.repository.TarefaRepository;

@Service
public class TarefaServiceImpl implements TarefaService{
	
	@Autowired
	private TarefaRepository tarefaRepository;

	@Override
	public Iterable<Tarefa> buscarTodos() {
		return tarefaRepository.findAll();
	}

	@Override
	public Tarefa buscarPorId(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		if(tarefa.isPresent()) {
			return tarefa.get();
		} else {
			return null;
		}
	}

	@Override
	public Tarefa inserir(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	@Override
	public Tarefa atualizar(Long id, Tarefa tarefa) {
		Optional<Tarefa> tarefaBd = tarefaRepository.findById(id);
		if (tarefaBd.isPresent()) {
			return tarefaRepository.save(tarefa);
		} else {
			return null;
		}
	}

	@Override
	public void deletar(Long id) {
		Optional<Tarefa> tarefaDeletar = tarefaRepository.findById(id);
		if(tarefaDeletar.isPresent()) {
			tarefaRepository.deleteById(id);
		} else {

		}
 		
		
	}
	

}
