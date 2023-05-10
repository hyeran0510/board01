package com.study.board01.controller;

import com.study.board01.Service.BoradService;
import com.study.board01.controller.entity.Board01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

     @Autowired
     private BoradService boradService;

     @GetMapping("/board/write")
    public String boardWriteForm() {
         return "boardwrite";
     }

     @PostMapping("/board/write")
    public String boardWriteForm(Board01 board01) {

         boradService.write(board01);

         return "";
     }
}
