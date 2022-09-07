package br.com.curtaocodigo.apisnapratica.repository;


import br.com.curtaocodigo.apisnapratica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
