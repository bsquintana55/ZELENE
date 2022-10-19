/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modeloDAO.usuarioDAO;
import modeloVO.usuarioVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sena
 */
@WebServlet(name = "usuarioControlador", urlPatterns = {"/usuario"})
public class usuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //1. recibir datos de las vistas
        String id_usua = request.getParameter("text_idu");
        String nombre_usua = request.getParameter("text_nombreu");
        String contra_usua = request.getParameter("text_contrau");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. el VO tiene los datos seguros
        usuarioVO usuvo = new usuarioVO(id_usua, nombre_usua, contra_usua);
        usuarioDAO usudao = new usuarioDAO(usuvo);

        switch (opcion) {

            case 1:
                    //inicio de sesion
                if (usudao.inicioSesion(nombre_usua, contra_usua)) {
                    request.getRequestDispatcher("dashbo.jsp").forward(request, response);
                } else {
                    request.setAttribute("MensajeError", "Verifique sus datos, por favor.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;

            case 2:
                if (usudao.agregarRegistro()) {
                    request.setAttribute("MensajeExito", "El usuario se registro correctamente");
                } else {
                    request.setAttribute("MensajeError", "El usuario no se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;

            case 3:
                if (usudao.actualizarRegistro()) {
                    request.setAttribute("MensajeExito", "El usuario se actualizo correctamente.");
                } else {
                    request.setAttribute("MensajeError", "El usuario no se actualizo correctamente.");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;

            case 4:
                if (usudao.eliminarRegistro()) {
                    request.setAttribute("MensajeExito", "El usuario se elimino correctamente.");
                } else {
                    request.setAttribute("MensajeError", "El usuario no se elimino correctamente.");
                }
                request.getRequestDispatcher("eliminarUsuario.jsp").forward(request, response);
                break;
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
