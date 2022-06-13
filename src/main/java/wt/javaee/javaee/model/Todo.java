package wt.javaee.javaee.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Todo {

	private Long id;
	private String title;
	private String username;
	private String description;
	private LocalDate targetDate;
	private boolean status;
	
	protected Todo() {
		
	}
	
	public Todo(long id, String title, String username, String description, LocalDate targetDate, boolean isDone) {
		super();
		this.id = id;
		this.title = title;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.status = isDone;
	}

	public Todo(String title, String username, String description, LocalDate targetDate, boolean isDone) {
		super();
		this.title = title;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.status = isDone;
	}

}
