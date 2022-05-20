package br.com.curtaocodigo.simplerestexample.controller;

import br.com.curtaocodigo.simplerestexample.model.User;
import br.com.curtaocodigo.simplerestexample.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
		userRepository.save(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}

}