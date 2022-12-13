package com.Accio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/History")
public class History extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            Connection connection = DatabaseConnection.getConnection();
            /* Getting results from database */
            ResultSet resultSet = connection.createStatement().executeQuery("select * from history");
            ArrayList<HistoryResult> results = new ArrayList<HistoryResult>();

            /* Extract data from result set */
            while(resultSet.next()){
                HistoryResult historyResult = new HistoryResult();
                historyResult.setName(resultSet.getString("name"));
                historyResult.setLink(resultSet.getString("link"));
                /* add  HistoryResult to  ArrayList i.e. results */
                results.add(historyResult);
            }

            /* forward request using RequestDispatcher from servlet to jsp */
            request.setAttribute("results",results);
            request.getRequestDispatcher("History.jsp").forward(request,response);

        }
        /* Handle  exceptions */
        catch (SQLException servletException){
            servletException.printStackTrace();
        }catch (ServletException servletException){
            servletException.printStackTrace();
        }catch (IOException ioexception){
            ioexception.printStackTrace();
        }

    }
}
