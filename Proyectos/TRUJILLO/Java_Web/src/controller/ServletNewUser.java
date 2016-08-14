package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Empleado;

/**
 * Servlet implementation class ServletNewUser
 */
@WebServlet("/ServletNewUser")
public class ServletNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpleadoBll obj =new EmpleadoBll();
		Empleado emp  = new Empleado("0001", request.getParameter("name")
				,request.getParameter("apellido"),request.getParameter("email")
				, request.getParameter("user"), request.getParameter("clave"));
		String destino=null;
		try {
			obj.EmpleadoAdicionar(emp);
			destino="Menu.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
	    RequestDispatcher rd;
	    rd = request.getRequestDispatcher(destino);
	    rd.forward(request, response);
	}
}