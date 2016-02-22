<%-- 
    Document   : index
    Created on : Feb 18, 2016, 11:22:09 AM
    Author     : emontoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="triqui" scope="request" class="triqui.TriquiGame"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Triqui Game EAFIT </title>
    </head>
    <body>
        <h1>Triqui Game EAFIT</h1>
        
        <p>Juego</p>
        <jsp:getProperty property="board" name="triqui"/><br>
        <p>Turno para: <jsp:getProperty property="player" name="triqui"/><br>
        <p>Ganador? <jsp:getProperty property="winner" name="triqui"/><br>    
        
        <form method="get" action="TriquiServletController">
            <p>posicion <input type="text" size="2" name="pos"/>
            <input type="submit" name="action" value="play"/>
            <input type="submit" name="action" value="reset"/>
        </form>
        
    </body>
</html>
