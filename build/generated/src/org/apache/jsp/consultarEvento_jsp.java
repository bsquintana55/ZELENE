package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modeloVO.usuarioVO;
import modeloDAO.usuarioDAO;
import modeloVO.eventoVO;
import java.util.ArrayList;
import modeloDAO.eventoDAO;

public final class consultarEvento_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/materialize.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("        <title>Consultar mascota</title>\n");
      out.write("    </head>\n");
      out.write("    <body></body>        \n");
      out.write("    <div class=\"form\">\n");
      out.write("        \n");
      out.write("        <h1 style=\"font-size: 50px;\">Eventos</h1>\n");
      out.write("        \n");
      out.write("        <form method=\"post\" action=\"Mascota\">\n");
      out.write("            \n");
      out.write("            <input type=\"text\" name=\"id_even\" class=\"validate\" placeholder=\"Buscar Evento\">\n");
      out.write("            \n");
      out.write("            <button class=\"waves-effect waves-light btn\" >Consultar Evento</button>\n");
      out.write("            <input type=\"hidden\" value=\"3\" name=\"opcion\">        \n");
      out.write("            \n");
      out.write("            <a href=\"regEvento.jsp\" class=\"btn btn-info\" >Registrar Evento</a><br><br>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        ");
            if (request.getAttribute("MensajeError") != null) { 
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("        ");
 } else {
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"evento\">\n");
      out.write("            <table class=\"striped\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Num. Evento</th>\n");
      out.write("                        <th>Administrador</th>\n");
      out.write("                        <th>Nombre Evento</th>\n");
      out.write("                        <th>Fecha Inicio</th>\n");
      out.write("                        <th>Fecha Final</th>\n");
      out.write("                        <th>Estado</th>\n");
      out.write("                        <th>Informacion </th>\n");
      out.write("                        <th></th>\n");
      out.write("                        <th></th>\n");
      out.write("                      \n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        eventoVO eveVO = new eventoVO();
                        eventoDAO eveDAO = new eventoDAO();
                        ArrayList<eventoVO> listaEvento = eveDAO.listar();
                        for (int i = 0; i < listaEvento.size(); i++) {

                            eveVO = listaEvento.get(i);

                    
      out.write("\n");
      out.write("                </thead>\n");
      out.write("\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(eveVO.getId_even());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(eveVO.getId_usua());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(eveVO.getNombre_even());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(eveVO.getFeInicio_even());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(eveVO.getFeFinal_even());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(eveVO.getEstado_even());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(eveVO.getDescrip_even());
      out.write("</td> \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("       <td> <input type=\"hidden\" value=\"4\" name=\"opcion\"  >\n");
      out.write("        <button class=\"waves-effect waves-light btn\" value=\"");
      out.print(eveVO.getId_even());
      out.write("\">Eliminar</button></td>\n");
      out.write("               \n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
