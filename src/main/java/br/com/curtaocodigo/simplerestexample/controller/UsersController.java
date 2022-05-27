package br.com.curtaocodigo.simplerestexample.controller;

import br.com.curtaocodigo.simplerestexample.model.User;
import br.com.curtaocodigo.simplerestexample.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/users")
public class UsersController {

    UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //HTTP GET v1/users 200 OK
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //HTTP GET v1/users/1 200 OK
    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable("id")Long id){
        return ResponseEntity.of(userRepository.findById(id));
    }

    //HTTP POST v1/users 201 CREATED
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody User user){
        return userRepository.save(user).getId();
    }


    //HTTP PATCH v1/users/1 200 OK, 404 NOT FOUND
    @PatchMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable("id")Long id, @RequestBody User user){
        return userRepository.findById(id).map(
                userFound -> updateUserInfo(userFound,user)
        ).orElseGet(
                () -> ResponseEntity.of(Optional.empty())
        );
    }

    private ResponseEntity<User> updateUserInfo(User userFound, User user) {
        userFound.setNome(user.getNome());
        userFound.setIdade(user.getIdade());
        return ResponseEntity.of(Optional.of(userRepository.save(userFound)));
    }

    //HTTP DELETE v1/users/1 200 OK 404 NOT FOUND
    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        try{
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(EmptyResultDataAccessException ex){
            return ResponseEntity.notFound().build();
        }
    }

}
