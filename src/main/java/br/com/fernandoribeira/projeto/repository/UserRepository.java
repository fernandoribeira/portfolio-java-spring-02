package br.com.fernandoribeira.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fernandoribeira.projeto.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
