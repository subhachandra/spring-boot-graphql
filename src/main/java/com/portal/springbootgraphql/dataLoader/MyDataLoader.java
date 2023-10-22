package com.portal.springbootgraphql.dataLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.portal.springbootgraphql.models.User;
import com.portal.springbootgraphql.models.Article;
import com.portal.springbootgraphql.repositories.*;
import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class MyDataLoader {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    
    @Autowired
    MyDataLoader(UserRepository userRepository, ArticleRepository articleRepository){
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }
    @PostConstruct
    private void generateData(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("ram");
        user.setCreatedAt(new Date());
        user.setAge(24);
        user.setArticlesIds(new ArrayList<>());
        users.add(user);
        
        User user1 = new User();
        user1.setName("sam");
        user1.setCreatedAt(new Date());
        user1.setAge(25);
        user1.setArticlesIds(new ArrayList<>());
        users.add(user1);
        
        User user2 = new User();
        user2.setName("ram");
        user2.setCreatedAt(new Date());
        user2.setAge(24);
        user2.setArticlesIds(new ArrayList<>());
        users.add(user2);
        User user3 = new User();
        user3.setName("ram");
        user3.setCreatedAt(new Date());
        user3.setAge(24);
        user3.setArticlesIds(new ArrayList<>());
        users.add(user3);
        
        User user4 = new User();
        user4.setName("sam");
        user4.setCreatedAt(new Date());
        user4.setAge(24);
        user4.setArticlesIds(new ArrayList<>());
        users.add(user4);
        
        users= (List<User>) userRepository.saveAll(users);
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setTitle("Java 8 Lambdas");
        article.setMinutesRead(8);
        article.setAuthorId(users.get(0).getId().toString());
        
        Article article1 = new Article();
        article1.setTitle("Java 11");
        article1.setMinutesRead(8);
        article1.setAuthorId(users.get(1).getId().toString());
        
        Article article2 = new Article();
        article2.setTitle("GraphQL Getting Started");
        article2.setMinutesRead(8);
        article2.setAuthorId(users.get(2).getId().toString());
        
        Article article3 = new Article();
        article3.setTitle("Spring Boot + WebSockets");
        article3.setMinutesRead(18);
        article3.setAuthorId(users.get(3).getId().toString());

        
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        
        articles= (List<Article>) articleRepository.saveAll(articles);
        User me = users.get(0);
        users.get(0).setArticlesIds(Arrays.asList(articles.get(0).getId().toHexString()));
        users.get(0).setArticlesIds(Arrays.asList(articles.get(1).getId().toHexString()));
        users.get(1).setArticlesIds(Arrays.asList(articles.get(2).getId().toHexString()));
        users.get(3).setArticlesIds(Arrays.asList(articles.get(0).getId().toHexString()));
        userRepository.saveAll(users);
        List<String> myFriendsIds = new ArrayList<>();
        for (int i = 1; i<users.size(); i++){
            myFriendsIds.add(users.get(i).getId().toHexString());
        }
        me.setFriendsIds(myFriendsIds);
        userRepository.save(me);
    }
}