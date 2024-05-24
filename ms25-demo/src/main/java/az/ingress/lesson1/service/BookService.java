package az.ingress.lesson1.service;

import az.ingress.lesson1.dto.BookRequestDto;
import az.ingress.lesson1.dto.BookResponseDto;

public interface BookService {
    int create(BookRequestDto dto);

    BookResponseDto update(Integer id, BookRequestDto dto);

    void delete(Integer id);

    BookResponseDto get(Integer id);
}
