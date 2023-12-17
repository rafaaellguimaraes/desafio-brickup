package br.com.rafaelguimaraes.brickup.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String title;
	@NotBlank
	private String description;
	private boolean completed;
	@Column(columnDefinition = "TEXT")
	private String image;

	public Task() {
	}

	public Task(Long id, @NotBlank String title, @NotBlank String description, boolean completed, String image) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.image = image;
	}

	public Task(String title, String description, boolean completed, String image) {
    this.title = title;
    this.description = description;
		this.completed = completed;
		this.image = image;
  }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Override 
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(obj, this);
	}
}
