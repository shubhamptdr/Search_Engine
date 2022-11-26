<%@page import = "java.util.ArrayList"%>
<%@page import = "com.Accio.SearchResult"%>

<html>
<head>

<link rel="stylesheet" href="style.css"/>
</head>
<body>
    <div class="container-Search">
            <form action = "Search" class="main-Search">
                <div class="searchImg-Search">
                    <img src="/Search-Engine/image/clipart4692155.png" alt="SearchEngine" class="logoSearchEngine-Search">
                </div>

                <div class="searchBox-Search">
                    <input
                        type="text"
                        class="query-Search"
                        name = "keyword"
                        placeholder="Search or type a URL"
                    />
                    <div class="icons-Search">
                        <img src="/Search-Engine/image/search.png" alt="search img">

                    </div>
                </div>

                <div class="button-Search">
                    <button class="searchBtn-Search" type="submit">Search</button>
                </div>
            </form>
        </div>

    <section class = "resultTable">
        <div class="searchResult">
            <%
                ArrayList<SearchResult> results = (ArrayList<SearchResult>) request.getAttribute("results");
                for(SearchResult result : results){
            %>

        <div class = "searchLink">
            <p><%out.println(result.getLink());%></p>
        </div>
        <div class = "searchTitle">
            <h3><a href = "<%out.println(result.getLink());%>"><%out.println(result.getTitle());%></a></h3>
        </div>


            <%
                }
            %>

        </div>
    </section>

</body>
</html>
