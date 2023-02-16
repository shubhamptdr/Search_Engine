package com.example.SearchEngine.Repositories;

import com.example.SearchEngine.Models.HistoryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryResult,Integer> {
}
