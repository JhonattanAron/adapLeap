package com.adaptleap.adapleapv1.controllers;
import com.adaptleap.adapleapv1.models.Articles;
import com.adaptleap.adapleapv1.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    private ArticlesRepository articlesRepository;

    @Autowired
    public ArticlesController(ArticlesRepository articlesRepository){
        this.articlesRepository = articlesRepository;

    }

    @GetMapping("/{title}")
    public ModelAndView ejemplo(@PathVariable String title) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ArticleView");
        Articles article = articlesRepository.findByTittle(title);
        modelAndView.addObject("article", article);

        return modelAndView;
    }
    @GetMapping("/api")
    public List<Articles> getArticlesJson(){
        return articlesRepository.findAll();
    }

}
