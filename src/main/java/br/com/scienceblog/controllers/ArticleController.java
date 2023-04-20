package br.com.scienceblog.controllers;

import br.com.scienceblog.model.entities.ArticleEntity;
import br.com.scienceblog.model.servicies.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {
    final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleEntity> findAll() {
        return articleService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleEntity findById(@PathVariable Integer id) {
        return articleService.findById(id).get();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleEntity create(@RequestBody ArticleEntity obj) {
        return articleService.save(obj);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleEntity update(@RequestBody ArticleEntity obj) {
        return articleService.update(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        articleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
