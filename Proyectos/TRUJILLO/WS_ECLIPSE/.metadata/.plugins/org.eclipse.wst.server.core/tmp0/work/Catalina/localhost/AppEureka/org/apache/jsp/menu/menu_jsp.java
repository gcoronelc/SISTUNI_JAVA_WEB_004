/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.14
 * Generated at: 2016-04-14 07:14:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<div class=\"menu\">\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li><a href=\"mainPage.jsp\">Home</a></li>\n");
      out.write("\t\t<li><a href=\"#\">Procesos</a>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Apertura de cuenta</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"javascript: loadPage('regDeposito.jsp')\">Depósito</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Retiro</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Transferencia</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Cierre de cuenta</a></li>\n");
      out.write("\t\t\t</ul></li>\n");
      out.write("\t\t<li><a href=\"#\">Tablas</a>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Clientes</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Empleados</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Sucursales</a></li>\n");
      out.write("\t\t\t</ul></li>\n");
      out.write("\t\t<li><a href=\"#\">Consultas</a>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"javascript: loadPage('conClientes.jsp')\">Clientes</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Cuentas</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"javascript: loadPage('conMovimientos.jsp')\">Movimientos</a></li>\n");
      out.write("\t\t\t</ul></li>\n");
      out.write("\t\t<li><a href=\"#\">Reportes</a>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Clientes</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Cuentas</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"javascript: loadPage('repoMovimientos.jsp')\">Movimientos</a></li>\n");
      out.write("\t\t\t</ul></li>\n");
      out.write("\t\t<li><a href=\"#\">Utilidades</a>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Cambio de clave</a></li>\n");
      out.write("\t\t\t</ul></li>\n");
      out.write("\t</ul>\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
