package com.study.board01.controller;

import com.study.board01.Service.BoradService;
import com.study.board01.controller.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoradService boradService;

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writePro")
    public String boardWritePro(Board board, Model model) {

        boradService.write(board);

        model.addAttribute("message","글 작성 완료");
        model.addAttribute("searchUrl","글 작성 완료");

        return "message";

    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boradService.boardlist());

            return "boardList";
        }

        @GetMapping("/board/view") //localhost:8080/board/view?id=1
        public String boradView (Model model, Integer id) { //넘겨줄때는 매개변수 model

            model.addAttribute("board",boradService.boardView(id));
            return "boardView";
        }

        @GetMapping("/board/delete")
        public String boardDelete(Integer id) {

        boradService.boardDelete(id);

        return "redirect:/board/list";
        }

        @GetMapping("/board/modify/{id}")
        public String boardmodify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board",boradService.boardView(id));


        return "boardmodify";
        }

        @PostMapping("/board/update/{id}")
        public String boardUpdate(@PathVariable ("id")Integer id, Board board) {

            Board boardTemp = boradService.boardView(id); //내용을 가지고오고
            boardTemp.setTitle(board.getTitle()); //덮어씌움
            boardTemp.setContent(board.getContent());

            boradService.write(boardTemp);  //업데이트

            return "redirect:/board/list";
        }

    }



