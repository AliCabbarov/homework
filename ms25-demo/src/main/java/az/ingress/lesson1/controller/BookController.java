package az.ingress.lesson1.controller;

import az.ingress.lesson1.dto.BookRequestDto;
import az.ingress.lesson1.dto.BookResponseDto;
import az.ingress.lesson1.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> get(@PathVariable Integer id,
                                               HttpServletRequest request) {
        BookResponseDto res = bookService.get(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BookRequestDto dto) {
        int id = bookService.create(dto);
        return ResponseEntity.created(URI.create("book/" + id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable Integer id,
                                                  @RequestBody BookRequestDto dto) {
        BookResponseDto response = bookService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
