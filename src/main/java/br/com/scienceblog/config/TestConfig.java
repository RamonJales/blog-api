package br.com.scienceblog.config;

import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.servicies.serviceImpl.ArticleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    final ArticleServiceImpl articleService;

    public TestConfig(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        ArticleEntity o1 = new ArticleEntity("AAA", "aaaaa", LocalDateTime.now(), "aaaaaaaaa");
        ArticleEntity o2 = new ArticleEntity("BBB", "bbbbb", LocalDateTime.now(), "bbbbbbbbb");

        articleService.save(o1);
        articleService.save(o2);
    }
}
