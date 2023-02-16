<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.ArrayList"%>
<%@page import = "com.example.SearchEngine.Models.HistoryResult"%>

<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
    <title>History</title>
    <link rel="icon" type="image/x-icon" href="/image/clipart4692155.png">
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body class="history-body">
    <h3>History</h3>
    <div class="container-history">
        <table >
            <thead>
                <tr>
                    <th>Search</th>
                    <th>URL</th>
                    <th class="visit">Visit</th>
                </tr>
            </thead>

                <c:forEach items="${historyResults}" var="result">
            <tbody>
                <tr>
                    <td class="key">${result.name} </td>
                    <td class="key"><c:out value="${result.link}" /></td>

                    <td class="open-button"><a href="${result.link}"><button class="openBtn" type = "submit">Open</button></a></td>
                </tr>
            </tbody>

                </c:forEach>

        </table>
    </div>
</body>
</html>
