package br.com.scienceblog.unitytests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;


import br.com.scienceblog.data.vo.v1.ArticleVO;
import br.com.scienceblog.mapper.DozerMapper;
import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.unitytests.mapper.mocks.MockArticle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DozerConvertTest {

    MockArticle inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockArticle();
    }

    @Test
    public void parseEntityToVOTest() {
        ArticleEntity article = inputObject.mockEntity();
        ArticleVO output = DozerMapper.parseObject(article, ArticleVO.class);

        assertEquals(article.getTitle(), output.getTitle());
        assertEquals(article.getAuthor(), output.getAuthor());
        assertEquals(article.getText(), output.getText());
    }

    @Test
    public void parseVOToEntityTest() {
        ArticleVO article = inputObject.mockVO();
        ArticleEntity output = DozerMapper.parseObject(article, ArticleEntity.class);

        assertEquals(null, output.getId());
        assertEquals(article.getTitle(), output.getTitle());
        assertEquals(article.getAuthor(), output.getAuthor());
        assertEquals(article.getText(), output.getText());
        assertEquals(null, output.getDate());
    }

}
