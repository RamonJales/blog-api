package br.com.scienceblog.model.servicies.serviceImpl;

import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.repositories.ArticleRepository;
import br.com.scienceblog.model.servicies.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Optional<ArticleEntity> findById(Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<ArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void save(ArticleEntity obj) {
        articleRepository.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
        articleRepository.deleteById(id);
    }
}
