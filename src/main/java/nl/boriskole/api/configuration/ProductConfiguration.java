package nl.boriskole.api.configuration;

import nl.boriskole.api.domain.Product;
import nl.boriskole.api.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return  args -> {
            productRepository.saveAll(List.of(
                    new Product(
                            "Milk",
                            1.50,
                            false
                    ),
                    new Product(
                            "Cheese",
                            4.50,
                            true
                    ),
                    new Product(
                            "Orange Juice",
                            2.50,
                            false
                    ),
                    new Product(
                            "Bread",
                            2.00,
                            true
                    ),
                    new Product(
                            "Eggs",
                            2.25,
                            false
                    )
            ));
        };
    }

}
