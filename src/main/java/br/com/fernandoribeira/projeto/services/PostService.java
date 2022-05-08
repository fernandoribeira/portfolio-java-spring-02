package br.com.fernandoribeira.projeto.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernandoribeira.projeto.domain.Post;
import br.com.fernandoribeira.projeto.repository.PostRepository;
import br.com.fernandoribeira.projeto.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		//return repository.findByTitleContainingIgnoreCase(text);
		return repository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxdate) {
		maxdate = new Date(maxdate.getTime() + 24 * 60 *60 * 1000);
		return repository.fullSearch(text, minDate, maxdate);
	}
	
}
