package br.com.rafaelguimaraes.brickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelguimaraes.brickup.entity.Task;
import br.com.rafaelguimaraes.brickup.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
	@Autowired
	private TaskService taskService;


	@PostMapping
	List<Task> create(@RequestBody @Valid Task task) {
		return taskService.create(task);
	}

	@GetMapping
	List<Task> list() {
		return taskService.list();
	}

	@PutMapping("/{id}")
	List<Task> update(@PathVariable Long id, @RequestBody Task task) {
		return taskService.update(id, task);
	}

	@DeleteMapping("/{id}")
	List<Task> delete(@PathVariable("id") Long id) {
		return taskService.delete(id);
	}

	@PutMapping("/complete/{id}")
	List<Task> completeTask(@PathVariable("id") Long id) {
		return taskService.completeTask(id);
	}
	
}
