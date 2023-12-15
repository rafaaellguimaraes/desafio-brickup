package br.com.rafaelguimaraes.brickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafaelguimaraes.brickup.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
} 