package br.com.scienceblog.unitytests.mapper;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.MappingException;

import br.com.scienceblog.data.vo.v1.ArticleVO;
import br.com.scienceblog.mapper.Mapper;
import br.com.scienceblog.model.entities.ArticleEntity;

public class MapperConvertTest {
	
	private Integer id = 1;
	private String title = "title 1";
	private String subtitle = "subtitle 1";
	private String author = "author 1";
	private String text = "text 1";
	private LocalDateTime dateTime = LocalDateTime.now();
	
	@Test
	@DisplayName("Parse entity to VO V1 object when success test")
	public void parseEntityToVOV1WhenSuccessTest() {
		
		ArticleEntity article = new ArticleEntity(id, title, subtitle, author, dateTime, text);
						
		ArticleVO output = Mapper.parseObject(article, ArticleVO.class);
		
		assertEquals(article.getId(), output.getId());
		assertEquals(article.getTitle(), output.getTitle());
		assertEquals(article.getSubTitle(), article.getSubTitle());
		assertEquals(article.getAuthor(), output.getAuthor());
		assertEquals(article.getText(), output.getText());
		assertEquals(article.getDateTime(), output.getDateTime());
	}
	
	
	@Test
	@DisplayName("Parse VO V1 to entity object when success test")
	public void parseVOV1ToEntityWhenSuccessTest() {
		
		ArticleVO articleVO = new ArticleVO(id, title, subtitle, author, dateTime, text);
						
		ArticleEntity output = Mapper.parseObject(articleVO, ArticleEntity.class);
				
		assertEquals(articleVO.getId(), output.getId());
		assertEquals(articleVO.getTitle(), output.getTitle());
		assertEquals(articleVO.getSubTitle(), output.getSubTitle());
		assertEquals(articleVO.getAuthor(), output.getAuthor());
		assertEquals(articleVO.getText(), output.getText());
		assertEquals(articleVO.getDateTime(), output.getDateTime());
	}
	
	@Test
	@DisplayName("Parse entity list to VO V1 list when success test")
	public void parseEntityListToVOListWhenSuccessTest() {
		ArticleEntity entity1 = new ArticleEntity(id, title, subtitle, author, dateTime, text);
		ArticleEntity entity2 = new ArticleEntity(id + 1, title + "2", subtitle + "2", author + "2", dateTime, text + "2");
		List<ArticleEntity> listEntity = new ArrayList<>(Arrays.asList(entity1, entity2));
		
		List<ArticleVO> listVO = Mapper.parseListObjects(listEntity, ArticleVO.class);
				
		assertNotNull(listVO);
		assertEquals(2, listVO.size());
		
		assertEquals(entity1.getId(), listVO.get(0).getId());
		assertEquals(entity1.getTitle(), listVO.get(0).getTitle());
		assertEquals(entity1.getSubTitle(), listVO.get(0).getSubTitle());
		assertEquals(entity1.getAuthor(), listVO.get(0).getAuthor());
		assertEquals(entity1.getText(), listVO.get(0).getText());
		assertEquals(entity1.getDateTime(), listVO.get(0).getDateTime());
		
		assertEquals(entity2.getId(), listVO.get(1).getId());
		assertEquals(entity2.getTitle(), listVO.get(1).getTitle());
		assertEquals(entity2.getSubTitle(), listVO.get(1).getSubTitle());
		assertEquals(entity2.getAuthor(), listVO.get(1).getAuthor());
		assertEquals(entity2.getText(), listVO.get(1).getText());
		assertEquals(entity2.getDateTime(), listVO.get(1).getDateTime());
	}
	
	@Test
	@DisplayName("Parse VO V1 list to entity list when success test")
	public void parseVOV1ListToEntityListWhenSuccessTest() {
		ArticleVO VOV1 = new ArticleVO(id, title, subtitle, author, dateTime, text);
		ArticleVO VOV2 = new ArticleVO(id + 1, title + "2", subtitle + "2", author + "2", dateTime, text + "2");
		List<ArticleVO> listVO = new ArrayList<>(Arrays.asList(VOV1, VOV2));
		
		List<ArticleEntity> listEntity = Mapper.parseListObjects(listVO, ArticleEntity.class);
				
		assertNotNull(listEntity);
		assertEquals(2, listEntity.size());
		
		assertEquals(VOV1.getId(), listEntity.get(0).getId());
		assertEquals(VOV1.getTitle(), listEntity.get(0).getTitle());
		assertEquals(VOV1.getSubTitle(), listEntity.get(0).getSubTitle());
		assertEquals(VOV1.getAuthor(), listEntity.get(0).getAuthor());
		assertEquals(VOV1.getText(), listEntity.get(0).getText());
		assertEquals(VOV1.getDateTime(), listEntity.get(0).getDateTime());
		
		assertEquals(VOV2.getId(), listEntity.get(1).getId());
		assertEquals(VOV2.getTitle(), listEntity.get(1).getTitle());
		assertEquals(VOV2.getSubTitle(), listEntity.get(1).getSubTitle());
		assertEquals(VOV2.getAuthor(), listEntity.get(1).getAuthor());
		assertEquals(VOV2.getText(), listEntity.get(1).getText());
		assertEquals(VOV2.getDateTime(), listEntity.get(1).getDateTime());
	}
	
	@Test()
	@DisplayName("Throws MappingException when map Fail Test")
	public void throwsMappingExceptionWhenMapFailTest() {
		
		ArticleEntity article = new ArticleEntity(id, null, subtitle, author, dateTime, text);
						
		MappingException exception = assertThrows(MappingException.class, () -> Mapper.parseObject(article, Integer.class));

		assertThatExceptionOfType(exception.getClass());
		
	}
	
	@Test()
	@DisplayName("Throws IllegalArgumentException When Source Param Is Null Test")
	public void throwsIllegalArgumentExceptionWhenSourceParamIsNullTest() {
								
		assertThrows(IllegalArgumentException.class, () -> Mapper.parseObject(null, ArticleEntity.class));

		assertThatIllegalArgumentException();
		
	}
	
	@Test()
	@DisplayName("Throws IllegalArgumentException When destination Param Is Null Test")
	public void throwsIllegalArgumentExceptionWhenDestinationParamIsNullTest() {
								
		assertThrows(IllegalArgumentException.class, () -> Mapper.parseObject(new ArticleEntity(), null));

		assertThatIllegalArgumentException();
		
	}
}
