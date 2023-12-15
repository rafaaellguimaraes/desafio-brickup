package br.com.rafaelguimaraes.brickup;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelguimaraes.brickup.entity.Task;

public class TestConstants {
	public static final List<Task> TASKS = new ArrayList<>() {
		{
			add(new Task(1L, "Task 1", "Desc 1", false));
			add(new Task(2L, "Task 2", "Desc 2", true));
			add(new Task(3L, "Task 3", "Desc 3", false));
			add(new Task(4L, "Task 4", "Desc 4", true));
			add(new Task(5L, "Task 5", "Desc 5", false));
		}
	};

	public static final Task TASK = TASKS.get(0);
}
