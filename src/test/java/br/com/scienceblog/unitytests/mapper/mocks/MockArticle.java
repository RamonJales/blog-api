package br.com.scienceblog.unitytests.mapper.mocks;

import br.com.scienceblog.data.vo.v1.ArticleVO;
import br.com.scienceblog.model.entities.ArticleEntity;

import java.time.LocalDateTime;

public class MockArticle {

    public ArticleEntity mockEntity() {
        return mockEntity(0);
    }
    public ArticleVO mockVO() {
        return mockVO(0);
    }

    public ArticleEntity mockEntity(Integer number) {
        ArticleEntity article = new ArticleEntity();
        article.setId(number);
        article.setTitle("Tittle test: " + number);
        article.setAuthor("Author test: " + number);
        article.setDate(LocalDateTime.now());
        article.setText("Text test: " + number);
        return article;
    }

    public ArticleVO mockVO(Integer number) {
        ArticleVO article = new ArticleVO();
        article.setTitle("Tittle test: " + number);
        article.setAuthor("Author test: " + number);
        article.setText("Text test: " + number);
        return article;
    }
}
