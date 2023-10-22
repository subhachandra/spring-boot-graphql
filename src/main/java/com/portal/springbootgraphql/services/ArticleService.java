package com.portal.springbootgraphql.services;

import com.portal.springbootgraphql.models.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAllUserArticles(List<String> userId);
}
