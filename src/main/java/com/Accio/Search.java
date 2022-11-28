package com.Accio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* Create Servlet using @WebServlet */
@WebServlet("/Search")
public class Search extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            String keyword = request.getParameter("keyword");
            Connection connection = DatabaseConnection.getConnection();
            keyword = keyword.toLowerCase();


            /* Getting results from database */
            ResultSet resultSet = connection
                                    .createStatement()
                                    .executeQuery("select pagetitle,pagelink ,(length(lower(pagedata))-length(replace(lower(pagedata),'"+keyword+"','')))/length('java') as countOccurence \n" +
                                    "from pages order by countOccurence  desc limit 30;");


            /*  ArrayList i.e. results that store search results  */
            ArrayList<SearchResult> results = new ArrayList<SearchResult>();

            /* Extract data from result set */
            while(resultSet.next()){
                SearchResult searchResult = new SearchResult();
                searchResult.setTitle(resultSet.getString("pagetitle"));
                searchResult.setLink(resultSet.getString("pagelink"));
                /* add  searchResult to  ArrayList i.e. results */
                results.add(searchResult);
            }



            /* Execute SQL query */
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into history values(?,?)");
            /* 1 specifies the first parameter in the query */
            preparedStatement.setString(1,keyword);
            /* 2 specifies the second parameter in the query */

            preparedStatement.setString(2, "https://myacciosearchengine.herokuapp.com/Search?keyword="+keyword);
            preparedStatement.executeUpdate();

            /* forward request using RequestDispatcher from servlet to jsp */
            request.setAttribute("results",results);
            request.getRequestDispatcher("search.jsp").forward(request,response);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3> This is my servlet " + keyword + "</h3>");

        }
        /* Handle  exceptions */
        catch(IOException ioException) {
            System.out.println(ioException);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        } catch (ServletException servletException){
            servletException.printStackTrace();

        }

    }
}
