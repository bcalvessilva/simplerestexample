package br.com.curtaocodigo.simplerestexample.repository;

import br.com.curtaocodigo.simplerestexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
