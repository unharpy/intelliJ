package com.example.searchbook.service;

import com.example.searchbook.dto.BookDTO;
import com.example.searchbook.dto.PageRequestDTO;
import com.example.searchbook.dto.PageResultDTO;
import com.example.searchbook.entity.Book;

public interface BookService {
    Long register(BookDTO dto);
    PageResultDTO<BookDTO, Book> getList(PageRequestDTO requestDTO);

    default Book dtoToEntity(BookDTO dto) {
        Book entity = Book.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }
    default BookDTO entityToDto(Book entity){
        BookDTO dto = BookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return  dto;
    }
}
