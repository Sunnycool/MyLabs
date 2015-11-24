<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8" />
</head>
<body>
    <h3>finded books:</h3>(<a href="add">add</a>)(<a href="search">search</a>)
    <ol>
        <c:forEach items="${enterprises}" var="book">
            <li>
                ${book.name} ${book.branch} - ${book.employeeCount}
                <a href="add?id=${book.enterpriseId}">edit</a> | <a href="delete?id=${book.enterpriseId}">delete</a>
            </li>
        </c:forEach>
    </ol>
</body>
</html>
