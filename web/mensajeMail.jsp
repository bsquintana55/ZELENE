<%-- 
    Document   : FormularioMensaje
    Created on : 13/06/2022, 08:32:45 AM
    Author     : Sena1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail</title>
    </head>
    <body>
        <h1>Envio de correo con java MAIL!</h1>
        <form method="POST" action="DatosMail">
            <table>
                <tr>
                    <td>Destino:</td>
                    <td><input type="text" name="textReceptor"></td>
                </tr>
                
                <tr>
                    <td>Asunto:</td>
                    <td><input type="text" name="textAsunto"></td>
                </tr>
                
               <tr>
                    <td>Mensaje:</td>
                    <td><textarea rows="10" name="textMensaje"></textarea></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>