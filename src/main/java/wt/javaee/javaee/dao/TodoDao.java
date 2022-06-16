package wt.javaee.javaee.dao;

import wt.javaee.javaee.model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {

	void insertTodo(Todo todo) throws SQLException;

	Todo selectTodo(long todoId);

	List<Todo> selectAllTodos();

	List<Todo> selectByUsername(String username);

	void deleteTodo(int id) throws SQLException;

	void updateTodo(Todo todo) throws SQLException;

}