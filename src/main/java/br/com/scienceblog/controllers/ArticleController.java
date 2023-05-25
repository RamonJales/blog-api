package br.com.scienceblog.controllers;

import br.com.scienceblog.data.vo.v1.ArticleVO;
import br.com.scienceblog.data.vo.v2.ArticleVOV2;
import br.com.scienceblog.model.servicies.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleVO> findAll() {
        return articleService.findAll();
    }
    
    @GetMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleVOV2> findAllV2() {
    	return articleService.findAllV2();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleVO findById(@PathVariable Integer id) {
        return articleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ArticleVO> create(@RequestBody ArticleVO obj) {
    	obj = articleService.save(obj);
    	URI uri = ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.path("/{id}")
    			.buildAndExpand(obj.getId())
    			.toUri();
    	
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ArticleVO> update(@PathVariable Integer id, @RequestBody ArticleVO obj) {
        obj = articleService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
