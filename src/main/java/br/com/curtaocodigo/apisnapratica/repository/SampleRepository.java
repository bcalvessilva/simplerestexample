package br.com.curtaocodigo.apisnapratica.repository;

import br.com.curtaocodigo.apisnapratica.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Product, Long> {
}
