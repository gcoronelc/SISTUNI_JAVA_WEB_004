/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.controller;

import colegioweb.domain.Alumnos;
import colegioweb.domain.Matriculados;
import colegioweb.service.AlumnoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/AlumnoRegistro", "/AlumnoActualizar", "/AlumnoContraseña", "/AlumnoMatricular"})
public class AlumnoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/AlumnoRegistro")) {
            alumnoRegistro(request, response);
        } else if (path.equals("/AlumnoActualizar")) {
            alumnoActualizar(request, response);
        } else if (path.equals("/AlumnoContraseña")) {
            alumnoCambiarContraseña(request, response);
        } else if (path.equals("/AlumnoMatricular")) {
            alumnoMatricular(request, response);
        }

    }

    private void alumnoRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta, usuario = "", nombres = "", apellidos = "", email = "";
        try {
            //Verifica password
            String password = request.getParameter("password");
            String confirmpass = request.getParameter("confirm-password");
            //Datos
            usuario = request.getParameter("usuario");
            nombres = request.getParameter("nombres");
            apellidos = request.getParameter("apellidos");
            email = request.getParameter("email");
            if (password.equals(confirmpass)) {
                //Proceso
                AlumnoService service = new AlumnoService();
                Alumnos bean = new Alumnos(nombres, apellidos, email, usuario, password, "no");
                HttpSession session = request.getSession();
                //Insertar Alumno
                rpta = service.insertar(bean);
                if (rpta.equals("OK")) {
                    request.setAttribute("info", "Alumno registrado correctamente.");
                }
            } else {
                request.setAttribute("error", "Las constraseñas no coinciden");
                request.setAttribute("usuario", usuario);
                request.setAttribute("nombres", nombres);
                request.setAttribute("apellidos", apellidos);
                request.setAttribute("email", email);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("usuario", usuario);
            request.setAttribute("nombres", nombres);
            request.setAttribute("apellidos", apellidos);
            request.setAttribute("email", email);
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("registroAlumno.jsp");
        rd.forward(request, response);
    }

    private void alumnoActualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta, usuario = "", nombres = "", apellidos = "", email = "";
        try {
            //Datos
            usuario = request.getParameter("usuario");
            nombres = request.getParameter("nombres");
            apellidos = request.getParameter("apellidos");
            email = request.getParameter("email");
            //Proceso
            AlumnoService service = new AlumnoService();
            Alumnos bean = new Alumnos();
            bean.setUsuario(usuario);
            bean.setNombres(nombres);
            bean.setApellidos(apellidos);
            bean.setEmail(email);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", bean);
            //Actualizar Alumno
            rpta = service.actualizar(bean);
            if (rpta.equals("OK")) {
                request.setAttribute("info", "Alumno actualizado correctamente.");
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("actualizaAlumno.jsp");
        rd.forward(request, response);
    }

    private void alumnoCambiarContraseña(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta = "";
        try {
            //Datos
            String pass = request.getParameter("password");
            String confpass = request.getParameter("confirm-password");
            String usuario = request.getParameter("usuario");
            if (pass.equals(confpass)) {
                //Proceso
                AlumnoService service = new AlumnoService();
                rpta = service.cambiarContraseña(pass, usuario);
                if (rpta.equals("OK")) {
                    request.setAttribute("info", "Se actualizo correctamente la contraseña");
                }
            } else {
                request.setAttribute("error", "Las contraseñas no coinciden");
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("configuracionAlumno.jsp");
        rd.forward(request, response);
    }

    private void alumnoMatricular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta = "";
        try {
            //Datos
            String usuario = request.getParameter("usuario");
            String anio = request.getParameter("anio");
            String grado = request.getParameter("grado");
            String codigo = request.getParameter("codigo");
            AlumnoService service = new AlumnoService();
            Matriculados bean = new Matriculados();
            bean.setUsuario(usuario);
            bean.setAnio(anio);
            bean.setCodigo(codigo);
            bean.setGrado(grado);
            if (service.EstaMatriculado(usuario).equals("si")) {
                request.setAttribute("info", "El alumno ya esta matriculado");
            } else {

                service.matricularse(bean);
                service.matricularseCurso(bean);
                service.actualizarEstadoMatricula(usuario);
                request.setAttribute("info", "El alumno se matriculo correctamente");

            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("matriculaAlumno.jsp");
        rd.forward(request, response);
    }

}
