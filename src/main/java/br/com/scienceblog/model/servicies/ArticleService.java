package br.com.scienceblog.model.servicies;

import br.com.scienceblog.model.entities.ArticleEntity;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Optional<ArticleEntity> findById(Integer id);
    List<ArticleEntity> findAll();
    void save(ArticleEntity obj);
    void deleteById(Integer id);
}
