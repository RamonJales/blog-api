package br.com.blogapi.unitytests.mapper;

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

import br.com.blogapi.data.vo.v1.ArticleVO;
import br.com.blogapi.data.vo.v2.ArticleVOV2;
import br.com.blogapi.mapper.Mapper;
import br.com.blogapi.model.entities.ArticleEntity;

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
	public void parseEntityListToVOV1ListWhenSuccessTest() {
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
		ArticleVO VO1 = new ArticleVO(id, title, subtitle, author, dateTime, text);
		ArticleVO VO2 = new ArticleVO(id + 1, title + "2", subtitle + "2", author + "2", dateTime, text + "2");
		List<ArticleVO> listVO = new ArrayList<>(Arrays.asList(VO1, VO2));
		
		List<ArticleEntity> listEntity = Mapper.parseListObjects(listVO, ArticleEntity.class);
				
		assertNotNull(listEntity);
		assertEquals(2, listEntity.size());
		
		assertEquals(VO1.getId(), listEntity.get(0).getId());
		assertEquals(VO1.getTitle(), listEntity.get(0).getTitle());
		assertEquals(VO1.getSubTitle(), listEntity.get(0).getSubTitle());
		assertEquals(VO1.getAuthor(), listEntity.get(0).getAuthor());
		assertEquals(VO1.getText(), listEntity.get(0).getText());
		assertEquals(VO1.getDateTime(), listEntity.get(0).getDateTime());
		
		assertEquals(VO2.getId(), listEntity.get(1).getId());
		assertEquals(VO2.getTitle(), listEntity.get(1).getTitle());
		assertEquals(VO2.getSubTitle(), listEntity.get(1).getSubTitle());
		assertEquals(VO2.getAuthor(), listEntity.get(1).getAuthor());
		assertEquals(VO2.getText(), listEntity.get(1).getText());
		assertEquals(VO2.getDateTime(), listEntity.get(1).getDateTime());
	}
	
	@Test
	@DisplayName("Parse entity to VO V2 object when success test")
	public void parseEntityToVOV2WhenSuccessTest() {
		
		ArticleEntity article = new ArticleEntity(id, title, subtitle, author, dateTime, text);
						
		ArticleVOV2 output = Mapper.parseObject(article, ArticleVOV2.class);
		
		assertEquals(article.getId(), output.getId());
		assertEquals(article.getTitle(), output.getTitle());
		assertEquals(article.getSubTitle(), article.getSubTitle());
		assertEquals(article.getAuthor(), output.getAuthor());
		assertEquals(article.getDateTime(), output.getDateTime());
	}
	
	@Test
	@DisplayName("Parse VO V2 to entity object when success test")
	public void parseVOV2ToEntityWhenSuccessTest() {
		
		ArticleVOV2 articleVOV2 = new ArticleVOV2(id, title, subtitle, author, dateTime);
						
		ArticleEntity output = Mapper.parseObject(articleVOV2, ArticleEntity.class);
				
		assertEquals(articleVOV2.getId(), output.getId());
		assertEquals(articleVOV2.getTitle(), output.getTitle());
		assertEquals(articleVOV2.getSubTitle(), output.getSubTitle());
		assertEquals(articleVOV2.getAuthor(), output.getAuthor());
		assertEquals(null, output.getText());
		assertEquals(articleVOV2.getDateTime(), output.getDateTime());
	}
	
	@Test
	@DisplayName("Parse entity list to VO V2 list when success test")
	public void parseEntityListToVOV2ListWhenSuccessTest() {
		ArticleEntity entity1 = new ArticleEntity(id, title, subtitle, author, dateTime, text);
		ArticleEntity entity2 = new ArticleEntity(id + 1, title + "2", subtitle + "2", author + "2", dateTime, text + "2");
		List<ArticleEntity> listEntity = new ArrayList<>(Arrays.asList(entity1, entity2));
		
		List<ArticleVOV2> listVOV2 = Mapper.parseListObjects(listEntity, ArticleVOV2.class);
				
		assertNotNull(listVOV2);
		assertEquals(2, listVOV2.size());
		
		assertEquals(entity1.getId(), listVOV2.get(0).getId());
		assertEquals(entity1.getTitle(), listVOV2.get(0).getTitle());
		assertEquals(entity1.getSubTitle(), listVOV2.get(0).getSubTitle());
		assertEquals(entity1.getAuthor(), listVOV2.get(0).getAuthor());
		assertEquals(entity1.getDateTime(), listVOV2.get(0).getDateTime());
		
		assertEquals(entity2.getId(), listVOV2.get(1).getId());
		assertEquals(entity2.getTitle(), listVOV2.get(1).getTitle());
		assertEquals(entity2.getSubTitle(), listVOV2.get(1).getSubTitle());
		assertEquals(entity2.getAuthor(), listVOV2.get(1).getAuthor());
		assertEquals(entity2.getDateTime(), listVOV2.get(1).getDateTime());
	}
	
	@Test
	@DisplayName("Parse VO V2 list to entity list when success test")
	public void parseVOV2ListToEntityListWhenSuccessTest() {
		ArticleVOV2 VO1 = new ArticleVOV2(id, title, subtitle, author, dateTime);
		ArticleVOV2 VO2 = new ArticleVOV2(id + 1, title + "2", subtitle + "2", author + "2", dateTime);
		List<ArticleVOV2> listVO = new ArrayList<>(Arrays.asList(VO1, VO2));
		
		List<ArticleEntity> listEntity = Mapper.parseListObjects(listVO, ArticleEntity.class);
				
		assertNotNull(listEntity);
		assertEquals(2, listEntity.size());
		
		assertEquals(VO1.getId(), listEntity.get(0).getId());
		assertEquals(VO1.getTitle(), listEntity.get(0).getTitle());
		assertEquals(VO1.getSubTitle(), listEntity.get(0).getSubTitle());
		assertEquals(VO1.getAuthor(), listEntity.get(0).getAuthor());
		assertEquals(VO1.getDateTime(), listEntity.get(0).getDateTime());
		assertEquals(null, listEntity.get(0).getText());
		
		assertEquals(VO2.getId(), listEntity.get(1).getId());
		assertEquals(VO2.getTitle(), listEntity.get(1).getTitle());
		assertEquals(VO2.getSubTitle(), listEntity.get(1).getSubTitle());
		assertEquals(VO2.getAuthor(), listEntity.get(1).getAuthor());
		assertEquals(VO2.getDateTime(), listEntity.get(1).getDateTime());
		assertEquals(null, listEntity.get(1).getText());
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
