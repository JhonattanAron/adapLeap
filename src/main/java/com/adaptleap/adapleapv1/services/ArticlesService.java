package com.adaptleap.adapleapv1.services;

import com.adaptleap.adapleapv1.models.Articles;
import com.adaptleap.adapleapv1.repositories.ArticlesRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {
    private ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public Articles registerArticle(String tittle , String imgurl , String p1 , String p2 , String footer){
        Articles articles = new Articles();
        articles.setTittle(tittle);
        articles.setImgUrl(imgurl);
        articles.setParagraphOne(p1);
        articles.setParagraphTwo(p2);
        articles.setFooter(footer);

        return articlesRepository.save(articles);
    }
}
