package com.nagarro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.ItemDao;
import com.nagarro.entity.Item;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		
		List<Item> list = new ItemDao().getItemList();
		for(Item item:list) {
			if(item.getTitle().equalsIgnoreCase(title) && item.getSize() == size && item.getQuantity() == quantity) {
				new ItemDao().delete(item);
			}
		}
		HttpSession session = request.getSession();
		ItemDao dao = new ItemDao();
		List<Item> itemList = dao.getItemList();
		session.setAttribute("itemList", dao.getItemList());
		response.sendRedirect("home.jsp");
		//System.out.println(title);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
