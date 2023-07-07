package com.example.searchbook.repository;

import com.example.searchbook.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;
@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1, 300).forEach(i ->{
            Book book = Book.builder()
                    .title("Title..." + i)
                    .content("Content..."+ i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(bookRepository.save(book));
        });
    }
    @Test
    public void updateTest(){
        Optional<Book> result = bookRepository.findById(300L);

        if(result.isPresent()){
            Book book = result.get();
            book.changeTitle("Changed Title....");
            book.changeContent("Changed Content...");

            bookRepository.save(book);
        }
    }

}
