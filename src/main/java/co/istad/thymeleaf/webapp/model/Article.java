package co.istad.thymeleaf.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private UUID uuid;
    private String title;
    private String thumbnail;
    private String author;

}
