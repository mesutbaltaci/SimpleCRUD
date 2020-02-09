package org.ms.model;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.ms.entities.User;

public class UsersModel {
	 
	public List<User> listUsers (DataSource dataSource) {
		List<User> listUsers = new ArrayList<User>(); 
		//Step 1 initialize connection objects
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			connect = dataSource.getConnection();
			//Step2 Create a SQL statements string
			String query = "SELECT * from users";
			stmt= connect.createStatement();
			//Step3 Execute SQL query
			
			rs = stmt.executeQuery(query);
						
			//Step4 Process the result set
			while (rs.next()) {
				listUsers.add(new User(rs.getInt("user_id"),rs.getString("username"),rs.getString("email")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		return listUsers;
	}

	public void addUser(DataSource dataSource, User newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String username = newUser.getUsername();
			String email= newUser.getEmail();
			String query = "INSERT INTO users (username, email) values(?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				connect.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void updateUser(DataSource dataSource, User updatedUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int usersID=updatedUser.getUsers_ID();
			String username = updatedUser.getUsername();
			String email= updatedUser.getEmail();
			String query = "UPDATE users set username=?, email=? where user_id=?";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3,usersID );
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			try {
				connect.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}

	public void deleteUser(DataSource dataSource, int userID) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			
			String query = "DELETE from users where user_id=?";
			statement = connect.prepareStatement(query);
			statement.setInt(1, userID);
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
