package az.ingress.lesson1.repository;

import az.ingress.lesson1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
