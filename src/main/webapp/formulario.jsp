<%-- 
    Document   : formulario
    Created on : 11 jun. de 2024, 17:49:25
    Author     : www74
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/formulario.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper">
            <h2>Formulario de Estudiantes</h2>
            <form action="EstudianteController" method="post">
                <fieldset>
                    <legend>Ingrese los siguientes datos</legend>
                    <input hidden name="id" value=<c:out value="${requestScope.estudiante.getId()}" default="-1"/> >
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="${requestScope.estudiante.getNombre()}" placeholder="Escriba su nombre">
                    <label for="apellidos">Apellidos:</label>
                    <input type="text" name="apellido" id="apellido" value="${requestScope.estudiante.getApellido()}" placeholder="Escriba sus apellidos">
                    <label for="email">Email:</label>
                    <input type="email" name="email" id="email" value="${requestScope.estudiante.getEmail()}" placeholder="ejemplo@mail.com">
                    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                    <input type="date" name="fNacimiento" id="fechaNacimiento" value="${requestScope.estudiante.getFNacimiento()}" placeholder="Fecha de Nacimiento">
                    <div class="buttons">
                        <a class="button_a" href="index.jsp">
                            <svg width="16" height="16" fill="currentColor"  viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8"/>
                            </svg>
                        </a>
                        <button class="button_b" type="submit">Enviar</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
