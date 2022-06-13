package wt.javaee.javaee.dao;

import wt.javaee.javaee.model.LoginBean;
import wt.javaee.javaee.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;
		try (Connection connection = JDBCUtils.getConnection();
			 PreparedStatement preparedStatement = connection
						.prepareStatement("select * from users where username = ? and password = ? ")) {
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) { JDBCUtils.printSQLException(e); }
		return status ;
	}
}
