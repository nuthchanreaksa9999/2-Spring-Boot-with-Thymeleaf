package co.istad.thymeleaf.webapp.service;

import co.istad.thymeleaf.webapp.model.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
//    Find all article
//    POJO
    List<Article> findAll();

    boolean save(Article article, MultipartFile file);

    Article findByUuid(String uuid);


}
