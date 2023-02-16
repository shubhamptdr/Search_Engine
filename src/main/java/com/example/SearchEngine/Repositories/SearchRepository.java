package com.example.SearchEngine.Repositories;

import com.example.SearchEngine.Models.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<SearchResult,Integer>  {

}
