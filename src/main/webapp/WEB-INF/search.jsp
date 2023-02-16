<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.ArrayList"%>
<%@page import = "com.example.SearchEngine.Models.SearchResult"%>

<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
    <title>Search Engine</title>
    <link rel="icon" type="image/x-icon" href="/image/clipart4692155.png">
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
    <div class="container-Search">
        <form action="Search" class="main-Search">
            <div class="searchImg-Search">
                <a href="index.jsp">
                    <img src="/image/clipart4692155.png" alt="SearchEngine" class="logoSearchEngine-Search">
                </a>
            </div>

            <div class="searchBox-Search">
                <input
                    type="text"
                    class="query-Search"
                    name="keyword"
                    placeholder="Search or type a URL"
                />
                <div class="icons-Search">
                    <img src="/image/search.png" alt="search img">
                </div>
            </div>

            <div class="button-Search">
                <button class="searchBtn-Search" type="submit">Search</button>
            </div>
        </form>
    </div>

    <section class="resultTable">
        <div class="searchResult">
            <c:forEach items="${results}" var="result">

                    <p>${result.link}</p>

                    <h3><a href="${result.link}">${result.title}</a></h3>
                    <p>${result.data}</p>

            </c:forEach>
        </div>
    </section>

</body>
</html>
