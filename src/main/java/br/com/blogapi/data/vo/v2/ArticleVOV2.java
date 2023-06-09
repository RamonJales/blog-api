package br.com.blogapi.data.vo.v2;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ArticleVOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String subTitle;
    private String author;
    private LocalDateTime dateTime;

    public ArticleVOV2() {}

	public ArticleVOV2(Integer id, String title, String subTitle, String author, LocalDateTime dateTime) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.author = author;
		this.dateTime = dateTime;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
