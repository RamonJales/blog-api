package br.com.scienceblog.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime dateTime;
    @Lob
    private String text;

    public ArticleEntity() {}

    public ArticleEntity(Integer id, String title, String author, LocalDateTime dateTime, String text) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateTime = dateTime;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity articleEntity = (ArticleEntity) o;
        return Objects.equals(id, articleEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
