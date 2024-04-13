package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.Category;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.model.UserRole;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import co.edu.escuelaing.cvds.lab7.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Lab7Application {
	private final ProductService ProductService;

	private final UserRepository userRepository;

	@Autowired
	public Lab7Application(
			ProductService ProductService,
			UserRepository userRepository
	) {
		this.ProductService = ProductService;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			log.info("Adding Products....");
			ProductService.addProduct(new Product(1, "Celular", "Samsung", Category.Technology, 1, 4000, 2 ));
			ProductService.addProduct(new Product(2, "Falda", "Chanel", Category.Clothes, 1, 8000, 2));
			ProductService.addProduct(new Product(3, "Hamburguesa", "Comida rica", Category.Food, 1, 9000, 2));

			log.info("\nGetting all Products....");
			ProductService.getAllProducts().forEach(Product -> System.out.println(Product));

			log.info("\nAdding admin@site.org user with Password: admin");
			userRepository.save(new User("admin@site.org", "admin", Arrays.asList(UserRole.ADMINISTRADOR, UserRole.CLIENTE)));
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
