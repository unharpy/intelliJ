package com.example.searchbook.service;

import com.example.searchbook.dto.BookDTO;
import com.example.searchbook.dto.PageRequestDTO;
import com.example.searchbook.dto.PageResultDTO;
import com.example.searchbook.entity.Book;
import com.example.searchbook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    @Override
    public Long register(BookDTO dto) {
       log.info("DTO--------");
       log.info(dto);

       Book entity = dtoToEntity(dto);
       log.info(entity);
       repository.save(entity);
       return entity.getGno();
    }
    @Override
    public PageResultDTO<BookDTO, Book> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        Page<Book> result = repository.findAll(pageable);
        Function<Book, BookDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }
}
