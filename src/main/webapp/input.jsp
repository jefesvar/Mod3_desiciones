<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>


<c:choose>

    <c:when test="${empty sessionScope.name}">
        <h2>Asignando nombre</h2>
        <form action="input" method="post">
            <input type="text" name="name" placeholder="Escribe tu nombre" />
            <button type="submit">Guardar</button>
        </form>
    </c:when>

    <c:otherwise>
        <h2>Intentos: ${sessionScope.attempts}</h2>
        <p>Nombre en sesión: <b>${sessionScope.name}</b></p>
        <button onclick="window.location='/Game'">Start</button>
    </c:otherwise>
</c:choose>



</body>
</html>