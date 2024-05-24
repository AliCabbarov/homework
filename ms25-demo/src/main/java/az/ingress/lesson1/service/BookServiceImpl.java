package az.ingress.lesson1.service;

import az.ingress.lesson1.dto.BookRequestDto;
import az.ingress.lesson1.dto.BookResponseDto;
import az.ingress.lesson1.dto.Hello;
import az.ingress.lesson1.model.Book;
import az.ingress.lesson1.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final Hello hello;

    public BookServiceImpl(BookRepository bookRepository, Hello hello) {
        this.bookRepository = bookRepository;
        this.hello = hello;
    }

    @Override
    public int create(BookRequestDto dto) {
        Book book = Book.builder()
                .author(dto.getAuthor())
                .pageCount(dto.getPageCount())
                .name(dto.getName())
                .id(dto.getId())
                .build();
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    @Transactional
    public BookResponseDto update(Integer id, BookRequestDto dto) {
        Book book = getBookById(id);
        book.setAuthor(dto.getAuthor() != null ? dto.getAuthor() : book.getAuthor());
        book.setName(dto.getName() != null ? dto.getName() : book.getName());
        book.setPageCount(dto.getPageCount() <= 0 ? dto.getPageCount() : book.getPageCount());
        return BookResponseDto.builder()
                .author(book.getAuthor())
                .name(book.getName())
                .pageCount(book.getPageCount())
                .build();
    }

    @Override
    public void delete(Integer id) {
        Book bookById = getBookById(id);
        bookRepository.delete(bookById);
    }

    @Override
    public BookResponseDto get(Integer id) {
        Book book = getBookById(id);
        return BookResponseDto.builder()
                .author(book.getAuthor())
                .pageCount(book.getPageCount())
                .name(book.getName())
                .id(book.getId())
                .build();
    }

    private Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found:: " + id));
    }
}
