package br.com.scienceblog.model.servicies;

import br.com.scienceblog.controllers.exceptions.ResourceNotFoundException;
import br.com.scienceblog.data.vo.v1.ArticleVO;
import br.com.scienceblog.data.vo.v2.ArticleVOV2;
import br.com.scienceblog.mapper.DozerMapper;
import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleVO findById(Integer id) {

        ArticleEntity obj = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found!"));

        return DozerMapper.parseObject(obj, ArticleVO.class);
    }

    public List<ArticleVO> findAll() {
        return DozerMapper.parseListObjects(articleRepository.findAll(), ArticleVO.class);
    }
    
    public List<ArticleVOV2> findAllV2() {
    	return DozerMapper.parseListObjects(articleRepository.findAll(), ArticleVOV2.class);
    }

    public ArticleVO save(ArticleVO obj) {
        ArticleEntity entity = DozerMapper.parseObject(obj, ArticleEntity.class);
        entity.setDate(LocalDateTime.now());
        entity = articleRepository.save(entity);
        return DozerMapper.parseObject(entity, ArticleVO.class);
    }

    public ArticleVO update(Integer id, ArticleVO obj) {
        ArticleEntity entity = articleRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Object not found!"));

        entity.setTitle(obj.getTitle());
        entity.setSubTitle(obj.getSubTitle());
        entity.setAuthor(obj.getAuthor());
        entity.setDate(LocalDateTime.now());
        entity.setText(obj.getText());

        entity = articleRepository.save(entity);

        return DozerMapper.parseObject(entity, ArticleVO.class);
    }

    public void delete(Integer id) {
        ArticleEntity obj = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        articleRepository.delete(obj);
    }
}
