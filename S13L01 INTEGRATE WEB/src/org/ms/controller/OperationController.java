package org.ms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.ms.entities.User;
import org.ms.model.UsersModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;

    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page=page.toLowerCase();
		
		switch (page) {
		case "listuser":
			listUsers(request, response);
			break;
		case "adduser":
			addUserFormLoader(request, response);
			break;
		case "updateuser":
			updateUserFormLoader(request, response);
			break;
		case "deleteuser":
			deleteUser(Integer.parseInt(request.getParameter("usersID")));
			listUsers(request, response);
			break;
		
			default:
				errorPage(request, response);
			
		}
		
	}
	private void deleteUser(int userID) {
		new UsersModel().deleteUser(dataSource,userID);
		
	}
	private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update User");
		try {
			request.getRequestDispatcher("updateuser.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String operation = request.getParameter("form");
			operation = operation.toLowerCase();
			
			switch (operation) {
			case "adduseroperation":
				User newUser = new User(request.getParameter("username"),request.getParameter("email"));
				addUserOperation(newUser);
				listUsers(request, response);
				break;
			case "updateuseroperation":
				User updatedUser = new User(Integer.parseInt(request.getParameter("userID")),request.getParameter("username"),request.getParameter("email"));
				updateUserOperation(updatedUser);
				listUsers(request, response);
				break;
			default:
				errorPage(request, response);
				break;
			}
		}
	
	private void updateUserOperation(User updatedUser) {
		new UsersModel().updateUser(dataSource,updatedUser);
		return;
		
	}
	private void addUserOperation(User newUser) {
		new UsersModel().addUser(dataSource, newUser);
		return;
		
	}
	public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		List<User> listUsers = new ArrayList<>();
		listUsers = new UsersModel().listUsers(dataSource);
		request.setAttribute("title", "List of Users");
		request.setAttribute("listUsers", listUsers);
		request.getRequestDispatcher("listuser.jsp").forward(request, response);
		
	}
	
	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
	}
	
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		request.setAttribute("title", "Error ");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

}
