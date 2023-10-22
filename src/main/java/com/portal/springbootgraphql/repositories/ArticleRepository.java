package com.portal.springbootgraphql.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.portal.springbootgraphql.models.Article;

import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<Article, ObjectId> {

    List<Article> findByIdIn(List<String> ids);
}