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
    @Lob
    private String text;

    public ArticleEntity() {}

    public ArticleEntity(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
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
