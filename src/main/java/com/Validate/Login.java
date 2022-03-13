package com.Validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the content type
		response.setContentType("text/html");
		// Get the writer
		PrintWriter out = response.getWriter();
		// Get the userName from the request
		String uName = request.getParameter("userName");
		String uPassword = request.getParameter("userPassword");
		// Get a reference to the HttpSession object
		HttpSession session = request.getSession();
		// Validate the username
		if (uName.equals("Srikar") && uPassword.equals("Srikar@123")) {
			// Save the username in the session
			session.setAttribute("userName", uName);
			session.setAttribute("userPassword", uPassword);
			// Redirect to the Dashboard
			response.sendRedirect("dashBoard");
		} else {
			response.sendRedirect("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
