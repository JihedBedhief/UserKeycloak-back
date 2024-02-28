package tn.esprit.Pidev.Controllers;


import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Pidev.Entities.Product;
import tn.esprit.Pidev.Repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductRepository productRepository;
    public ProductController(ProductRepository productRepository){
        this.productRepository =productRepository ;
    }


    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProd(@PathVariable Long id ){
        return productRepository.findById(id).get();
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
    return authentication;
    }

}