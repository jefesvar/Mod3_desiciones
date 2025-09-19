<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>${dialog.text}</h2>

    <c:forEach var="entry" items="${dialog.options}">
        <form action="Game" method="get">
            <input type="hidden" name="id" value="${entry.value}" />
            <button type="submit">${entry.key}</button>
        </form>
    </c:forEach>
</body>
</html>