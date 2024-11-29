package com.example.API.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.API.Model.News;
import com.example.API.Service.NewsService;



@CrossOrigin("*")
@RestController

public class NewsController {


	@Autowired
	NewsService newsService;
	
    @GetMapping("/news/list")
	public List<News> getAllNews() {
    	
		return newsService.getAllNews();
    }
    
    @GetMapping("/news/list/{id}")
	public News getNews(@PathVariable int id) {
		News news=(newsService.findById(id));
		
		return news;
	}
	
//	@PostMapping("/news/add")
//	public News createNews(@RequestBody News news)
//	{
//		newsService.addNews(news);
//		return news;
//	}
    
    @PostMapping("/news/add")
    public ResponseEntity<News> addNews(
            @RequestParam("heading") String news_Heading,
            @RequestParam("content") String news_Content, 
            @RequestParam("image") MultipartFile imageFile) throws IOException {

        News news = newsService.saveNews(news_Heading, news_Content, imageFile);
        return ResponseEntity.ok(news);
    }

	
	@PutMapping ("/news/update/{id}")
	public ResponseEntity<News> updateNewsByID(@PathVariable int id, @RequestBody News newsDetails){
			
		News updatedNews=newsService.update(id, newsDetails);
		
		return ResponseEntity.ok(updatedNews);
}
	
//	@DeleteMapping("/news/delete/")
//	public String deleteNews(@RequestParam int newsId) {
//		
//		return newsService.delete(newsId);
//	}
	
	@DeleteMapping("/news/delete/{id}")
	public String deleteNewsById( @PathVariable ("id") int id) {
		return newsService.delete(id);
	}
	
}
