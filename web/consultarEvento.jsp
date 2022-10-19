<%-- 
    Document   : consultarMascota
    Created on : 25/07/2022, 09:50:38 AM
    Author     : julia_000
--%>
<%@page import="modeloVO.usuarioVO"%>
<%@page import="modeloDAO.usuarioDAO"%>
<%@page import="modeloVO.eventoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.eventoDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet" type="text/css"/>
        
        <title>Consultar mascota</title>
    </head>
    <body></body>        
    <div class="form">
        
        <h1 style="font-size: 50px;">Eventos</h1>
        
        <form method="post" action="Mascota">
            
            <input type="text" name="id_even" class="validate" placeholder="Buscar Evento">
            
            <button class="waves-effect waves-light btn" >Consultar Evento</button>
            <input type="hidden" value="3" name="opcion">        
            
            <a href="regEvento.jsp" class="btn btn-info" >Registrar Evento</a><br><br>

        </form>
        
        
        <br><br>
        <%            if (request.getAttribute("MensajeError") != null) { %>
        ${MensajeError}

        <% } else {%>
        ${MensajeExito}
        <%}%>


        <form method="post" action="evento">
            <table class="striped">
                <thead>
                    <tr>
                        <th>Num. Evento</th>
                        <th>Administrador</th>
                        <th>Nombre Evento</th>
                        <th>Fecha Inicio</th>
                        <th>Fecha Final</th>
                        <th>Estado</th>
                        <th>Informacion </th>
                        <th></th>
                        <th></th>
                      
                    </tr>


                    <%
                        eventoVO eveVO = new eventoVO();
                        eventoDAO eveDAO = new eventoDAO();
                        ArrayList<eventoVO> listaEvento = eveDAO.listar();
                        for (int i = 0; i < listaEvento.size(); i++) {

                            eveVO = listaEvento.get(i);

                    %>
                </thead>

                <tbody>
                    <tr>
                        <td><%=eveVO.getId_even()%></td>
                        <td><%=eveVO.getId_usua()%></td>
                        <td><%=eveVO.getNombre_even()%></td>
                        <td><%=eveVO.getFeInicio_even()%></td>
                        <td><%=eveVO.getFeFinal_even()%></td>
                        <td><%=eveVO.getEstado_even()%></td>
                        <td><%=eveVO.getDescrip_even()%></td> 
                        
                        
       <td> <input type="hidden" value="4" name="opcion"  >
        <button class="waves-effect waves-light btn" value="<%=eveVO.getId_even()%>">Eliminar</button></td>
               
                </tr>
                <%}%>

                </tbody>
            </table>


            
        </form>
    </div>
   
</html>
