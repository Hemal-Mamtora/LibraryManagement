<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list}" var="entry">
    <tr>
        <td>${books.get(entry.bookid).getName()}</td>
        <td>${entry.fromDate}</td>
        <td>${entry.toDate}</td>
        <td>
            <form action="./MyBooks" method="post">
                <input type="hidden" name="id" value="${entry.id}" />
                <input type="hidden" name="bookid" value="${entry.bookid}" />
                <input type="submit" value="returnIt" name="returnIt">
            </form>
        </td>
    </tr>
</c:forEach>
</body>
</html>