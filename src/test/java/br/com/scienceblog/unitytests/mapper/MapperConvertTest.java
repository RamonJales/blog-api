package br.com.scienceblog.unitytests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.scienceblog.data.vo.v1.ArticleVO;
import br.com.scienceblog.mapper.Mapper;
import br.com.scienceblog.model.entities.ArticleEntity;

@ExtendWith(MockitoExtension.class)
public class MapperConvertTest {

	@Mock
	private DozerBeanMapper dozerMapper;

	@InjectMocks
	private Mapper mapper;
	
	@Test
	@DisplayName("parse entity to VO object test")
	public void parseEntityToVOTest() {
		Integer id = 1;
		String title = "title 1";
		String subtitle = "subtitle 1";
		String author = "author 1";
		String text = "text 1";
		
		ArticleEntity article = new ArticleEntity(id, title, subtitle, author, LocalDateTime.now(), text);
		ArticleVO articleVO = new ArticleVO(id, title, subtitle, author, text);
		
		Mockito.when(dozerMapper.map(article, ArticleVO.class)).thenReturn(articleVO);
		
		ArticleVO output = mapper.parseObject(article, ArticleVO.class);
		
		verify(dozerMapper, times(1)).map(article, ArticleVO.class);

		assertEquals(article.getId(), output.getId());
		assertEquals(article.getTitle(), output.getTitle());
		assertEquals(article.getSubTitle(), article.getSubTitle());
		assertEquals(article.getAuthor(), output.getAuthor());
		assertEquals(article.getText(), output.getText());
	}
	
	
	@Test
	@DisplayName("parse VO to entity object test")
	public void parseVOToEntityTest() {
		Integer id = 1;
		String title = "title 1";
		String subtitle = "subtitle 1";
		String author = "author 1";
		String text = "text 1";
		
		ArticleVO articleVO = new ArticleVO(id, title, subtitle, author, text);
		ArticleEntity article = new ArticleEntity(id, title, subtitle, author, null, text);
		
		Mockito.when(dozerMapper.map(articleVO, ArticleEntity.class)).thenReturn(article);
		
		ArticleEntity output = mapper.parseObject(articleVO, ArticleEntity.class);
		
		verify(dozerMapper, times(1)).map(articleVO, ArticleEntity.class);
		

		assertEquals(articleVO.getId(), output.getId());
		assertEquals(articleVO.getTitle(), output.getTitle());
		assertEquals(articleVO.getSubTitle(), output.getSubTitle());
		assertEquals(articleVO.getAuthor(), output.getAuthor());
		assertEquals(articleVO.getText(), output.getText());
		assertEquals(null, output.getDate());
	}
	
}
