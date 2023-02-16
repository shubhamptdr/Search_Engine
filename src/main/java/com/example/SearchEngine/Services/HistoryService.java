package com.example.SearchEngine.Services;

import com.example.SearchEngine.Models.HistoryResult;
import com.example.SearchEngine.Models.SearchResult;
import com.example.SearchEngine.Repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public List<HistoryResult> getHistory() {
        return historyRepository.findAll();
    }
}
