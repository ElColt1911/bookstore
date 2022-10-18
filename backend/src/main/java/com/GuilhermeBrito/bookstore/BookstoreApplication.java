package com.GuilhermeBrito.bookstore;

import com.GuilhermeBrito.bookstore.domain.Categoria;
import com.GuilhermeBrito.bookstore.domain.Livro;
import com.GuilhermeBrito.bookstore.repositories.CategoriaRepository;
import com.GuilhermeBrito.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
