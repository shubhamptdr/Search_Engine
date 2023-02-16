package com.example.SearchEngine.Services;

import com.example.SearchEngine.Models.SearchResult;
import com.example.SearchEngine.Repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<SearchResult> getResult(String keyword) {
//        List<SearchResult> searchResults = jdbcTemplate.queryForList("select * from pages", SearchResult.class);


//        try {
//            keyword = keyword.toLowerCase();
//            /* Getting results from database */
//
//            Connection connection;
//            connection = null;
//            ResultSet resultSet = connection
//                    .createStatement()
//                    .executeQuery("select pagetitle,pagelink, SUBSTR(pagedata, 1, 300) AS substring,(length(lower(pagedata))-length(replace(lower(pagedata),'"+keyword+"','')))/length('java') as countOccurence \n" +
//                            "from pages order by countOccurence  desc limit 30;");
//
//            /*  ArrayList i.e. results that store search results  */
//            List<SearchResult> results = new ArrayList<>();
//
//            /* Extract data from result set */
//            while (resultSet.next()) {
//                SearchResult searchResult = new SearchResult();
//                searchResult.setTitle(resultSet.getString("pagetitle"));
//                searchResult.setLink(resultSet.getString("pagelink"));
//                searchResult.setData(resultSet.getString("substring"));
//                /* add  searchResult to  ArrayList i.e. results */
//                results.add(searchResult);
//            }


            /* add the search results to the model and return the view */

            return searchRepository.findAll();
//        } catch (SQLException e) {
//            throw new RuntimeException("Error searching for keyword " + keyword, e);
//        }
    }
}
