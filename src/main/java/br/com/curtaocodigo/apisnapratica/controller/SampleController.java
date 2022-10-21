package br.com.curtaocodigo.apisnapratica.controller;

import br.com.curtaocodigo.apisnapratica.dto.ProductDTO;
import br.com.curtaocodigo.apisnapratica.model.Product;
import br.com.curtaocodigo.apisnapratica.service.SampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("v1/sample")
public class SampleController {

	private SampleService sampleService;

	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		Product product = sampleService.create(new Product(productDTO.getName(),productDTO.getDescription()));
		return new ResponseEntity<>(product.getId(),HttpStatus.CREATED);
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String strId) {
		Long id = null;
		try{
			id = Long.valueOf(strId);
		}catch (NumberFormatException nfe){
			//nothing to do
		}

		Optional<Product> product = sampleService.findById(id);

		return product.isPresent()?
				ResponseEntity.ok(product.get()):
				ResponseEntity.notFound().build();
	}
}