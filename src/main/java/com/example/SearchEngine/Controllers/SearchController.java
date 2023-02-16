package com.example.SearchEngine.Controllers;

import com.example.SearchEngine.Services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class SearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping("/")
    public ModelAndView get(){
        return new ModelAndView("index");
    }

    @GetMapping("/search")
    public ModelAndView getResult(@RequestParam String keyword){
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("results",searchService.getResult(keyword));
        return modelAndView;
    }
}
