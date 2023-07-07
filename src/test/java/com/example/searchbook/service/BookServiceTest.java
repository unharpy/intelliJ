package com.example.searchbook.service;

import com.example.searchbook.dto.BookDTO;
import com.example.searchbook.dto.PageRequestDTO;
import com.example.searchbook.dto.PageResultDTO;
import com.example.searchbook.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService service;

    @Test
    public void testRegister(){
        BookDTO guestbookDTO = BookDTO.builder()
                .title("Sample Title")
                .content("Sample Content")
                .writer("user0")
                .build();
        System.out.println(service.register(guestbookDTO));
    }
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<BookDTO, Book> resultDTO = service.getList(pageRequestDTO);

        for (BookDTO bookDTO : resultDTO.getDtoList()) {
            System.out.println(bookDTO);
        }
    }
}
