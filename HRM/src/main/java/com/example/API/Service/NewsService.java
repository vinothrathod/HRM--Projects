package com.example.API.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.API.Model.News;
import com.example.API.Repository.NewsRepo;

@Service
public class NewsService {


	@Autowired
	private NewsRepo newsRepo;

	public List<News> getAllNews() {

		return newsRepo.findAll();
	}

	public News findById(int id) {
		News news = (newsRepo.findById(id)).get();
		return news;
	}
	
//	public News addNews(News news) {
//		newsRepo.save(news);
//		return news;
//
////			return newsRepo.save(news);
//	}
	
	
	public News saveNews(String news_Heading, String news_Content, MultipartFile file) throws IOException {
		News news = new News();
		news.setNews_Heading(news_Heading);
		news.setNews_Content(news_Content);
		news.setImage(file.getBytes());

		return newsRepo.save(news);
	}
	
	public News update(int id, News newsDetails) {
		News news = newsRepo.findById(id).get();
		
		news.setNews_Heading(newsDetails.getNews_Heading());
		news.setNews_Content(newsDetails.getNews_Content());
		News updatedNews = newsRepo.save(news);

		return (updatedNews);
	}
	
	public String delete(int newsId) {
		newsRepo.deleteById(newsId);

		return "Deleted succesfully";
	}
}
