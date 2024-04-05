package com.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.Post;
import com.workshopmongo.repository.PostRepository;
import com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;


	public Post findByid(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado."));
	}
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}
