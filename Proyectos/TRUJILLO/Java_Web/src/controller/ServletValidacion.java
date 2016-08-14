package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.EmpleadoBll;
import entity.Empleado;

/**
 * Servlet implementation class ServletValidacion
 */
@WebServlet("/ServletValidacion")
public class ServletValidacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletValidacion() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Empleado emp = new Empleado();
	EmpleadoBll bean = new EmpleadoBll();
	emp.setUsuario(request.getParameter("email"));
	emp.setClave(request.getParameter("pass"));
	String destino;
	try {
		boolean log=bean.EmpleadoValidar(emp.getUsuario(),emp.getClave());
		if(log){
		HttpSession session =request.getSession();
		session.setAttribute("usuario",emp.getUsuario());
		destino="Menu.jsp";
		}else{
			throw new Exception("Datos incorrectos.");
		}
	} catch (Exception e) {
		request.setAttribute("error",e.getMessage());
		destino="index.jsp";
	}	
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
	}
}