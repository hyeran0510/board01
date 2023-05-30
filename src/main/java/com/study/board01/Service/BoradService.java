package com.study.board01.Service;

import com.study.board01.controller.entity.Board;
import com.study.board01.controller.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoradService {

     @Autowired
    private BoardRepository boardRepository;

     // 글 작성 처리
    public void write(Board board) {

        boardRepository.save(board);
    }


        //게시글 리스트 처리
    public List<Board> boardlist(){
        return boardRepository.findAll();

    }
        //특정 게시물 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    //특정 게시물 삭제
    //void 는 리턴 안된다`
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }

}
