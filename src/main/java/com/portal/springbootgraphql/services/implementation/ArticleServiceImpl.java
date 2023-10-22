package com.portal.springbootgraphql.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.springbootgraphql.models.Article;
import com.portal.springbootgraphql.repositories.ArticleRepository;
import com.portal.springbootgraphql.services.ArticleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAllUserArticles(List<String> ids) {
        return articleRepository.findByIdIn(ids);
    }
}
