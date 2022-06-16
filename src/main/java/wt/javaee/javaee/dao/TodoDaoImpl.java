package wt.javaee.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import wt.javaee.javaee.model.Todo;
import wt.javaee.javaee.utils.JDBCUtils;

public class TodoDaoImpl implements TodoDao {

	private static final String INSERT_TODOS_SQL = "INSERT INTO todos"
			+ "  (title, username, description, target_date,  is_done) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String SELECT_TODO_BY_ID = "select id,title,username,description,target_date,is_done from todos where id =?";
	private static final String SELECT_ALL_TODOS = "select * from todos";
	private static final String SELECT_BY_USER = "select * from todos where username = ?";
	private static final String DELETE_TODO_BY_ID = "delete from todos where id = ?;";
	private static final String UPDATE_TODO = "update todos set title = ?, username= ?, description =?, target_date =?, is_done = ? where id = ?;";

	public TodoDaoImpl() {}

	@Override
	public void insertTodo(Todo todo) {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
			preparedStatement.setString(1, todo.getTitle());
			preparedStatement.setString(2, todo.getUsername());
			preparedStatement.setString(3, todo.getDescription());
			preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
			preparedStatement.setBoolean(5, todo.isStatus());
			preparedStatement.executeUpdate();
		} catch (SQLException exception) { JDBCUtils.printSQLException(exception); }
	}

	@Override
	public Todo selectTodo(long todoId) {
		Todo todo = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID)) {
			preparedStatement.setLong(1, todoId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) todo = newTodoFromRS(rs);
		} catch (SQLException exception) { JDBCUtils.printSQLException(exception); }
		return todo;
	}

	@Override
	public List<Todo> selectAllTodos() {
		List<Todo> todos = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				todos.add( newTodoFromRS(rs) ); }
		} catch (SQLException exception) { JDBCUtils.printSQLException(exception); }
		return todos;
	}

    @Override
    public List<Todo> selectByUsername(String username) {
		List<Todo> todos = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USER)) {
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				todos.add( newTodoFromRS(rs) ); }
		} catch (SQLException exception) { JDBCUtils.printSQLException(exception); }
		return todos;
    }

    @Override
	public void deleteTodo(int id) throws SQLException {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID)) {
			statement.setInt(1, id);
			statement.execute(); }
	}

	@Override
	public void updateTodo(Todo todo) throws SQLException {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TODO)) {
			statement.setString(1, todo.getTitle());
			statement.setString(2, todo.getUsername());
			statement.setString(3, todo.getDescription());
			statement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
			statement.setBoolean(5, todo.isStatus());
			statement.setLong(6, todo.getId());
			statement.execute();
		}
	}

	private Todo newTodoFromRS(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String title = rs.getString("title");
		String username = rs.getString("username");
		String description = rs.getString("description");
		LocalDate targetDate = rs.getDate("target_date").toLocalDate();
		boolean isDone = rs.getBoolean("is_done");
		return new Todo(id, title, username, description, targetDate, isDone);
	}

}