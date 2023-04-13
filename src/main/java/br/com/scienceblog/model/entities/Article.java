package br.com.scienceblog.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime dateTime;
    @Lob
    private String text;

    public Article() {}

    public Article(Integer id, String title, String author, LocalDateTime dateTime, String text) {
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
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
