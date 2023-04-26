package br.com.scienceblog.data.vo.v1;

public class ArticleVO {

    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String text;

    public ArticleVO() {}

    public ArticleVO(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
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

}
