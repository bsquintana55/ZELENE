<%-- 
    Document   : verMascota
    Created on : 19/08/2022, 09:21:42 AM
    Author     : julia_000
--%>


<%@page import="modeloVO.eventoVO"%>
<%@page import="modeloVO.usuarioVO"%>
<%@page import="modeloDAO.usuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evento A</title>
    </head><html>
<body>
    
    
    <div class="form">
        <h1>Evento</h1>


        <%
            eventoVO eveVO = (eventoVO) request.getAttribute("");
            if (eveVO != null) {
        %>
        <form method="post" action="evento" onsubmit="">
           
                    <input type="hidden" class="form-control" value="<%=eveVO.getId_even() %>"name="id_even">
              
                  
                    <label for="">Nombre del evento</label>
                    <input type="text" id="nombre" class="form-control" value="<%=eveVO.getNombre_even()%> "name="nombre_even">
              
                <br>

          
                <label for="">Fecha de Inicio</label>
                <input type="date" id="inicio" name="feInicio_even" class="form-control" value="<%=eveVO.getFeInicio_even()%>">
    

            <br> <br>
       
                Fecha final<br>
                <input type="date" name="feFinal_even" value="<%=eveVO.getFeInicio_even()%>" >
                <br><br>
                 
                        
                        <label for="">Estado</label>
                        <input type="text" name="estado_even" value="<%=eveVO.getEstado_even()%>"><br><br>
                        
                       
                         <label for="">Descripcion del evento</label>
                         <input type="text" name="descrip_even" value="<%=eveVO.getDescrip_even()%>"><br><br>
                        
                   

            <button id="actualizar" class="waves-effect waves-light btn">Actualizar</button>
            <input type="hidden" value="2" name="opcion" id="actualizar">
            
            

            <%}%>
            <%
            if (request.getAttribute("MensajeError") != null) { %>
            ${MensajeError}

            <% } else {%>
            ${MensajeExito}
            <%}%>
            
           
             </div>
        </form>
    </div>
</body>
 
</html>
