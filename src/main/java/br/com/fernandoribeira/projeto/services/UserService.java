package br.com.fernandoribeira.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernandoribeira.projeto.domain.User;
import br.com.fernandoribeira.projeto.dto.UserDTO;
import br.com.fernandoribeira.projeto.repository.UserRepository;
import br.com.fernandoribeira.projeto.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User oldUser) {
		User newUser = findById(oldUser.getId());
		updateData(newUser, oldUser);
		return repository.save(newUser);
	}
	
	private void updateData(User newUser, User oldUser) {
		newUser.setName(oldUser.getName());
		newUser.setEmail(oldUser.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}
