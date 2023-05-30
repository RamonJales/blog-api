package br.com.blogapi.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blogapi.model.entities.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {}
