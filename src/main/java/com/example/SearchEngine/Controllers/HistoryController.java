package com.example.SearchEngine.Controllers;

import com.example.SearchEngine.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public ModelAndView getHistory(){
        ModelAndView modelAndView = new ModelAndView("History");
        modelAndView.addObject("historyResults",historyService.getHistory());
        return modelAndView;
    }
}
