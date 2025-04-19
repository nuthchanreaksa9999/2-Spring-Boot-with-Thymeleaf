package co.istad.thymeleaf.webapp.controller;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    String viewArticle(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "pages/article/article";
    }

    @GetMapping("/new")
    String viewArticleNew()
    {
        return "pages/article/article-new";
    }

}
