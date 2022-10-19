/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.eventoDAO;
import modeloVO.eventoVO;

/**
 *
 * @author solan
 */
@WebServlet(name = "eventoControlador", urlPatterns = {"/evento"})
public class eventoControlador extends HttpServlet {

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
        String id_even = request.getParameter("id_even");
        String nombre_even = request.getParameter("nombre_even");
        String feInicio_even = request.getParameter("feInicio_even");
        String feFinal_even = request.getParameter("feFinal_even");
        String estado_even = request.getParameter("estado_even");
        String descrip_even = request.getParameter("descrip_even");
        String id_usua = request.getParameter("id_usua");
        
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        
        eventoVO evO = new eventoVO(
                id_even,nombre_even,
                feInicio_even, feFinal_even,
                estado_even, descrip_even, id_usua
        );
        
        eventoDAO evedao = new eventoDAO(evO);

        
         switch (opcion) {

            case 1:  //agregar registro
             
            if (evedao.agregarRegistro()) {
                
                    request.setAttribute("MensajeExito", "El evento se creo correctamente");
                } else {
                    request.setAttribute("MensajeError", "El evento no se creo correctamente");
                }
                request.getRequestDispatcher("regEvento.jsp").forward(request, response);
                
                break;
                
            case 2:  //actualizar registro
                 if (evedao.actualizarRegistro()) {
                     
                    request.setAttribute("MensajeExito", "El evento se actualizo correctamente.");
                } else {
                    request.setAttribute("MensajeError", "El evento no se actualizo correctamente.");
                }
                request.getRequestDispatcher("consultarEvento.jsp").forward(request, response);
               
                break;
                

            case 3:
                 
                evO = evedao.consultarId(id_even);
                if (evO != null)
                {
                    request.setAttribute("Consulta_evento", evO);
                    request.getRequestDispatcher("actualizarEvento.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("MensajeError", "No se encuentran resultados para tu busqueda."
                            + " Por favor busque correctamente");

                    request.getRequestDispatcher("consultarEvento.jsp").forward(request, response);
                }
                break;

            case 4:
                if (evedao.eliminarRegistro())
                {
                    request.setAttribute("MensajeExito", "La evento se pudo elimino");
                }
                else
                {
                    request.setAttribute("MensajeError", "La evento no se pudo eliminar");
                }
                request.getRequestDispatcher("consultarEvento.jsp").forward(request, response);
                
                break;
        }//termina el switch

       
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
