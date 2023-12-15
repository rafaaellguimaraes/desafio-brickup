package br.com.rafaelguimaraes.brickup;

import static br.com.rafaelguimaraes.brickup.TestConstants.TASK;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.rafaelguimaraes.brickup.entity.Task;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql")
class BrickupApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTaskSuccess() {
		var task = new Task("task 1", "description 1", false);

		webTestClient
			.post()
			.uri("/api/tasks")
			.bodyValue(task)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].title").isEqualTo(task.getTitle())
			.jsonPath("$[0].description").isEqualTo(task.getDescription())
			.jsonPath("$[0].completed").isEqualTo(task.getCompleted());
			
	}

	@Test
	void testCreateTaskFailure() {
		var task = new Task("", "", false);

		webTestClient
			.post()
			.uri("/api/tasks")
			.bodyValue(task)
			.exchange()
			.expectStatus().isBadRequest();
	}

	@Sql("/import.sql")
	@Test
	public void testUpdateTaskSuccess() {
		var task = new Task(TASK.getId(), TASK.getTitle() + " teste", TASK.getDescription() + " descrip teste", !TASK.getCompleted());

		webTestClient
			.put()
			.uri("/api/tasks" + TASK.getId())
			.bodyValue(task)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(5)
			.jsonPath("$[0].title").isEqualTo(task.getTitle())
			.jsonPath("$[0].description").isEqualTo(task.getDescription())
			.jsonPath("$[0].completed").isEqualTo(task.getCompleted());
	}


}
