package br.com.scienceblog.config;

import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.servicies.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    final ArticleService articleService;

    public TestConfig(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        ArticleEntity o1 = new ArticleEntity("AAA", "aaaaa", "aaaaaaaaa");
        ArticleEntity o2 = new ArticleEntity("BBB", "bbbbb", "bbbbbbbbb");

        articleService.save(o1);
        articleService.save(o2);
    }
}
