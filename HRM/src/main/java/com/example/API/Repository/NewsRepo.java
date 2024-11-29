package com.example.API.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API.Model.News;

@Repository
public interface NewsRepo extends JpaRepository<News,Integer> {

	
}
