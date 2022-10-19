<%-- 
    Document   : regEvento
    Created on : 18/10/2022, 01:29:45 PM
    Author     : solan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evento C</title>
    </head>
    <body>
        <h1>Crear evento</h1>
        
        
        <form method="post" action="evento">
            <table>
                <tr>
                    <th>
                        Nombre del evento<br>
                        <input type="text" name="nombre_even"><br><br>
                         Fecha inicio<br>
                        <input type="date" name="feInicio_even"><br><br>
                         Fecha final<br>
                        <input type="date" name="feFinal_even"><br><br>
                         Descripcion del evento<br>
                        <input type="text" name="descrip_even"><br><br>
                        
                        
                        Estado<br>
                        <input type="text" name="estado_even"><br><br>
                         Administrador del evento<br>
                        <input type="text" name="id_usua"><br><br>
            
            
            
                    </th>
                </tr>
            </table>
            <button class="btn btn-outline-secondary">Crear</button>
         <input type="hidden" value="1" name="opcion">
            
        </form>
        
        <br><br>
        
        <a class="txt2" href="consultarEvento.jsp">
          <button class="btn btn-outline-secondary">Eventos</button>  
        </a>
        
          
       <%if (request.getAttribute("MensajeError") != null) {%>
                ${MensajeError}    
                <% } else {%>
                ${MensajeExito}
                <% }%>
        
    </body>
</html>
