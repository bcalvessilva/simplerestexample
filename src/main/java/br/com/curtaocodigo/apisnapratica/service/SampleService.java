package br.com.curtaocodigo.apisnapratica.service;

import br.com.curtaocodigo.apisnapratica.model.Product;
import br.com.curtaocodigo.apisnapratica.repository.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SampleService {
    private SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public Product create(Product product){
        product.setId(sampleRepository.save(product).getId());
        return product;
    }

    public Optional<Product> findById(Long id){
        return sampleRepository.findById(id);
    }
}
