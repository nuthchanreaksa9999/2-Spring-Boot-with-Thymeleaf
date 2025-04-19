package co.istad.thymeleaf.webapp.repository;

import co.istad.thymeleaf.webapp.model.Article;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public class StaticRepository {

    private Faker faker;
    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    private List<Article> articles;

    @PostConstruct
    void init(){
        articles = new ArrayList<>() {{

            for (int i = 0; i < 20; i++) {
                add(new Article(UUID.randomUUID(), faker.book().title(), "thumbnail.png", faker.book().author()));
            }
        }};
    }

}
