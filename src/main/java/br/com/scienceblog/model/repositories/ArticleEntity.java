package br.com.scienceblog.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleEntity extends JpaRepository<Integer, ArticleEntity> {}
