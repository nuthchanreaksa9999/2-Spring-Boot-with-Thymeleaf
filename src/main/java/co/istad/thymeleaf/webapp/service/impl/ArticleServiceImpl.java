package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.repository.StaticRepository;
import co.istad.thymeleaf.webapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final StaticRepository staticRepository;

    @Override
    public List<Article> findAll() {
        return staticRepository.getArticles();
    }
}
