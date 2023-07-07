package com.example.searchbook.controller;

import com.example.searchbook.dto.PageRequestDTO;
import com.example.searchbook.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/searchbook")
@Log4j2
@RequiredArgsConstructor
public class BookController {
    private final BookService service;
    @GetMapping("/")
    public String index() {

        return "redirect:/searchbook/list";
    }
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list........." + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));
    }

}
