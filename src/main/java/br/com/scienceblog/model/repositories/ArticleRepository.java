package br.com.scienceblog.model.repositories;

import br.com.scienceblog.model.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {}
