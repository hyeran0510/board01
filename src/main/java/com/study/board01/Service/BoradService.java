package com.study.board01.Service;

import com.study.board01.controller.entity.Board;
import com.study.board01.controller.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoradService {

     @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }
}
