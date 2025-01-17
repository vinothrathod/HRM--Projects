package com.example.API.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	@Column(length = 500)
	private String news_Heading;
	@Column(length = 5000)
	private String news_Content;
	
	@Lob
    @Column(name = "image", length = 3000)
    private byte[] Image;
	
	
	public News() {
		
	}

	

	public News(int id, String news_Heading, String news_Content, byte[] image) {
		super();
		this.id = id;
		this.news_Heading = news_Heading;
		this.news_Content = news_Content;
		Image = image;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNews_Heading() {
		return news_Heading;
	}

	public void setNews_Heading(String news_Heading) {
		this.news_Heading = news_Heading;
	}

	public String getNews_Content() {
		return news_Content;
	}

	public void setNews_Content(String news_Content) {
		this.news_Content = news_Content;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		Image = image;
	}

}
