package com.nagarro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.entity.User;
import com.nagarro.servicesImpl.ListOfItems;
import com.nagarro.servicesImpl.UserValidation;

@WebServlet("/InputDetails")
public class InputProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String name = request.getParameter("uname");
		String password = request.getParameter("password");
		System.out.println(name + " " + password);
		User user = new User(name, password); 
		boolean validate = new UserValidation().validate(user);
		
		
		HttpSession session = request.getSession();
		
			if(validate) {
				
				session.setAttribute("name", name);
				session.setAttribute("itemList", new ListOfItems().getAllItems());
				response.sendRedirect("home.jsp");
			}
			else {
				session.setAttribute("error", "Invalid username or Password");
				response.sendRedirect("index.jsp");
			}
		
	}
//		if(name.equals("shadzu") && password.equals("123")) {
//			HttpSession session = request.getSession();
//			session.setAttribute("name", name);
//			response.sendRedirect("home.jsp");
//		}
//		else {
//			
//			response.sendRedirect("index.jsp");
//		}
//			request.getSession().setAttribute("uname", name);
//			request.getSession().setAttribute("password", password);
//			request.getRequestDispatcher("home.jsp").forward(request, response);
//		
//		if (name != null && password != null) {
//			RequestDispatcher rd = request.getRequestDispatcher("HomePage");
//			rd.include(request, response);
//		}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
