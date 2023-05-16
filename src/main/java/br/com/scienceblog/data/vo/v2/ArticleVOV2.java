package br.com.scienceblog.data.vo.v2;

import java.io.Serializable;

public class ArticleVOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String subTitle;
    private String author;

    public ArticleVOV2() {}

	public ArticleVOV2(String title, String subTitle, String author) {
		this.title = title;
		this.subTitle = subTitle;
		this.author = author;
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

}
