package com.study.board01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BoardController {
    @GetMapping("/board/write")
    public String boardwriteForm() {


        return "boardwrite";
    }
}