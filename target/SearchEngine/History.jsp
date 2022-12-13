<%@page import = "java.util.ArrayList"%>
<%@page import = "com.Accio.HistoryResult"%>

<html>
<head>
    <title>History</title>
    <link rel="icon" type="image/x-icon" href="/image/clipart4692155.png">
<link rel="stylesheet" href="style.css"/>
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

            <%
                ArrayList<HistoryResult> results = (ArrayList<HistoryResult>) request.getAttribute("results");
                for(HistoryResult result : results){
            %>

            <tbody>
                <tr>
                    <td class="key"><%out.println(result.getName());%></td>
                    <td><%out.println(result.getLink());%></td>
                    <td class="open-button"><a href="<%out.println(result.getLink());%>"><button class="openBtn" type = "submit">Open</button></a></td>
                </tr>
            </tbody>

            <%
                }
            %>
        </table>
    </div>
</body>
</html>
