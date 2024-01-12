package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Test
    void findBookById() {

        BookRepository mockBookRepository = mock(BookRepository.class);
        Book reply = new Book("1", "Title1", "Author1");
        when(mockBookRepository.findById(anyString())).thenReturn(reply);

        BookService bookService = new BookService(mockBookRepository);
        Book result = bookService.findBookById("2");

        assertEquals(reply, result);
    }

    @Test
    void findAllBooks() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "Book1", "Author1"));
        books.add(new Book("2", "Book2", "Author2"));
        when(mockBookRepository.findAll()).thenReturn(books);

        BookService bookService = new BookService(mockBookRepository);
        List<Book> result = bookService.findAllBooks();

        assertEquals(books, result);
    }
}