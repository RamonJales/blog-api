package br.com.blogapi.model.servicies;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.blogapi.controllers.exceptions.ResourceNotFoundException;
import br.com.blogapi.data.vo.v1.ArticleVO;
import br.com.blogapi.data.vo.v2.ArticleVOV2;
import br.com.blogapi.mapper.Mapper;
import br.com.blogapi.model.entities.ArticleEntity;
import br.com.blogapi.model.repositories.ArticleRepository;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleVO findById(Integer id) {

        ArticleEntity obj = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found!"));

        return Mapper.parseObject(obj, ArticleVO.class);
    }

    public List<ArticleVO> findAll() {
        return Mapper.parseListObjects(articleRepository.findAll(), ArticleVO.class);
    }
    
    public List<ArticleVOV2> findAllV2() {
    	return Mapper.parseListObjects(articleRepository.findAll(), ArticleVOV2.class);
    }

    public ArticleVO save(ArticleVO obj) {
        ArticleEntity entity = Mapper.parseObject(obj, ArticleEntity.class);
        entity.setDateTime(LocalDateTime.now());
        entity = articleRepository.save(entity);
        return Mapper.parseObject(entity, ArticleVO.class);
    }

    public ArticleVO update(Integer id, ArticleVO obj) {
        ArticleEntity entity = articleRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Object not found!"));

        entity.setTitle(obj.getTitle());
        entity.setSubTitle(obj.getSubTitle());
        entity.setAuthor(obj.getAuthor());
        entity.setDateTime(LocalDateTime.now());
        entity.setText(obj.getText());

        entity = articleRepository.save(entity);

        return Mapper.parseObject(entity, ArticleVO.class);
    }

    public void delete(Integer id) {
        ArticleEntity obj = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        articleRepository.delete(obj);
    }
}
