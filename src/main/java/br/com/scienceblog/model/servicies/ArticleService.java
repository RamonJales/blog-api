package br.com.scienceblog.model.servicies;

import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Optional<ArticleEntity> findById(Integer id) {
        return articleRepository.findById(id);
    }

    public List<ArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    public ArticleEntity save(ArticleEntity obj) {
        return articleRepository.save(obj);
    }

    public ArticleEntity update(ArticleEntity obj) {
        ArticleEntity entity = articleRepository.findById(obj.getId()).get();

        entity.setTitle(obj.getTitle());
        entity.setAuthor(obj.getAuthor());
        entity.setText(obj.getText());

        return articleRepository.save(obj);
    }

    public void deleteById(Integer id) {
        articleRepository.deleteById(id);
    }
}
