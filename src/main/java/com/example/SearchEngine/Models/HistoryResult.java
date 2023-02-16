package com.example.SearchEngine.Models;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class HistoryResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sNo;
    private String name;
    private String link;

    public HistoryResult() {
        // no-args constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
