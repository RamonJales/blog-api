package br.com.scienceblog.model.servicies;

import br.com.scienceblog.controllers.exceptions.ResourceNotFoundException;
import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleEntity findById(Integer id) {
        return articleRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Object not found!"));
    }

    public List<ArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    public ArticleEntity save(ArticleEntity obj) {
        return articleRepository.save(obj);
    }

    public ArticleEntity update(ArticleEntity obj) {
        ArticleEntity entity = articleRepository.findById(obj.getId()).
                orElseThrow(() -> new ResourceNotFoundException("Object not found!"));

        entity.setTitle(obj.getTitle());
        entity.setAuthor(obj.getAuthor());
        entity.setLocalDateTime();
        entity.setText(obj.getText());

        return articleRepository.save(obj);
    }

    public void delete(Integer id) {
        ArticleEntity obj = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        articleRepository.delete(obj);
    }
}
