package com.dio.listadetarefas.repository;

import org.springframework.data.repository.CrudRepository;

import com.dio.listadetarefas.model.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Long>{

}
