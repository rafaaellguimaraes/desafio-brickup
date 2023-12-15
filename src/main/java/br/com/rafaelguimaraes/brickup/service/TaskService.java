package br.com.rafaelguimaraes.brickup.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.rafaelguimaraes.brickup.entity.Task;
import br.com.rafaelguimaraes.brickup.repository.TaskRepository;

@Service
public class TaskService {
	private TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> create(Task task) {
		taskRepository.save(task);
		return list();
	}

	public List<Task> list() {
		Sort sort = Sort.by("completed").descending().and(Sort.by("title").ascending());
		return taskRepository.findAll(sort);
	}

	public List<Task> update(Long id, Task task) {
		taskRepository.findById(id).ifPresentOrElse((existingTask) -> {
			task.setId(id);
			taskRepository.save(task);
		}, () -> {
			try {
				throw new BadRequestException("Task %d não existe! ".formatted(id));
			} catch (BadRequestException e) {
				e.printStackTrace();
			}
		});
		return list();
	}

	public List<Task> delete(Long id) {
		taskRepository.deleteById(id);
		return list();
	}
}
