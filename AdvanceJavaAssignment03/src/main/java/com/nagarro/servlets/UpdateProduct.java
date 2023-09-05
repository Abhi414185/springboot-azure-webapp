package com.nagarro.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nagarro.dao.ItemDao;
import com.nagarro.entity.Item;
import com.nagarro.servicesImpl.ListOfItems;
@MultipartConfig
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("hello");
		
		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));
		Item item = new Item();

		
	
		Part filePart = request.getPart("image");
		if(filePart!=null) {
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			System.out.println(filePart.getSubmittedFileName());
			
		}

		File file = new File("C:\\Users\\abhirajgope\\Desktop\\"+filePart.getSubmittedFileName());
		byte[] bFile = new byte[(int)file.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 item.setImage(bFile);
		//item.setImage(bytes);

		item.setTitle(title);
		item.setQuantity(quantity);
		item.setSize(size);
		
		int id = Integer.parseInt(request.getParameter("id"));
		item.setProductID(id);
		
//		String title = request.getParameter("title");
//		String a = request.getParameter("quantity");
//		System.out.println(a);
//		int quantity = Integer.parseInt(a);
//		int size = Integer.parseInt(request.getParameter("size"));
//		
//		int id = Integer.parseInt(request.getParameter("id"));
//		Item item = new Item();
//		item.setQuantity(quantity);
//		item.setSize(size);
//		item.setTitle(title);
//		item.setProductID(id);
//		
//		Part filePart = request.getPart("image");
//		if(filePart != null) {
//			System.out.println(filePart.getName());
//			System.out.println(filePart.getSize());
//			System.out.println(filePart.getContentType());
//			System.out.println(filePart.getSubmittedFileName());
//			
//		}
//
//		File file = new File("C:\\Users\\mdhussain02\\Desktop\\"+filePart.getSubmittedFileName());
//		byte[] bFile = new byte[(int)file.length()];
//		try {
//			FileInputStream fileInputStream = new FileInputStream(file);
//			fileInputStream.read(bFile);
//			fileInputStream.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		 item.setImage(bFile);
//		
		
		
		new ItemDao().updateChanges(item);
		
		HttpSession session = request.getSession();
		session.setAttribute("itemList", new ListOfItems().getAllItems());
		response.sendRedirect("home.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
