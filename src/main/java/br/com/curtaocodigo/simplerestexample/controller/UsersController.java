package br.com.curtaocodigo.simplerestexample.controller;

import br.com.curtaocodigo.simplerestexample.model.User;
import br.com.curtaocodigo.simplerestexample.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.util.Optionals.ifPresentOrElse;

@RestController
@RequestMapping("v1/users")
public class UsersController {

	UserRepository userRepository;

	public UsersController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UsersController.class, args);
	}

	@GetMapping
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		return ResponseEntity.of(userRepository.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody User resource) {
		return userRepository.save(resource).getId();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
		return userRepository.findById(id).map(
				value -> updateUserInfo(value, resource))
				.orElseGet(() -> ResponseEntity.of(Optional.empty()));
	}

	private ResponseEntity<User> updateUserInfo(User user, User newUser){
		user.setNome(newUser.getNome());
		user.setIdade(newUser.getIdade());
		return ResponseEntity.of(Optional.of(userRepository.save(user)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try{
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (EmptyResultDataAccessException ex){
			return ResponseEntity.notFound().build();
		}
	}

}